package br.ufpe.cin.if688.minijava.visitor;

import br.ufpe.cin.if688.minijava.ANTLR.MiniJavaParser;
import br.ufpe.cin.if688.minijava.ANTLR.MiniJavaVisitor;
import jdk.nashorn.internal.ir.Assignment;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import br.ufpe.cin.if688.minijava.ast.*;

import java.beans.Expression;

public class MiniJavaVisitorImpl implements MiniJavaVisitor<Program> {


    private Program currentProgram;
    private ClassDecl currentClass;
    private Identifier currentIdentifier;
    private String currentSymbol;
    private Type currentType;
    private MethodDecl currentMethod;
    private Exp currentExp;
    private Statement currentStatement;

    @Override
    public Program visit(ParseTree parseTree) {
        parseTree.accept(this);
        return currentProgram;
    }


    @Override
    public Program visitChildren(RuleNode ruleNode) {
        System.out.println(ruleNode);
        return ruleNode.accept(this);
    }

    @Override
    public Program visitErrorNode(ErrorNode errorNode) {
        System.out.println(errorNode);
        return errorNode.accept(this);
    }

    @Override
    public Program visitTerminal(TerminalNode terminalNode) {
        currentSymbol = terminalNode.getSymbol().getText();
        return currentProgram;
    }

    @Override
    public Program visitGoal(MiniJavaParser.GoalContext ctx) {
        ClassDeclList classDeclarationList = new ClassDeclList();
        currentProgram = new Program(null,  classDeclarationList);

        for (MiniJavaParser.ClassDeclarationContext classDeclarationCtx : ctx.classDeclaration()) {
            classDeclarationCtx.accept(this);
        }

        ctx.mainClass().accept(this);

        return currentProgram;
    }

    @Override
    public Program visitClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        MiniJavaParser.IdentifierContext classNameCtx = ctx.identifier(0);
        classNameCtx.accept(this);
        Identifier className = currentIdentifier;

        MiniJavaParser.IdentifierContext extendsClassNameCtx = ctx.identifier(1);
        boolean hasExtends = extendsClassNameCtx != null;

        VarDeclList varDeclList = new VarDeclList();
        MethodDeclList methodDeclList = new MethodDeclList();

        if (hasExtends) {
            extendsClassNameCtx.accept(this);
            Identifier extendsClassName = currentIdentifier;

            currentClass = new ClassDeclExtends(className, extendsClassName, varDeclList, methodDeclList);
        } else {
            currentClass = new ClassDeclSimple(className, varDeclList, methodDeclList);
        }

        for (MiniJavaParser.VarDeclarationContext varDeclarationContext : ctx.varDeclaration()) {
            varDeclarationContext.accept(this);
        }

        for (MiniJavaParser.MethodDeclarationContext methodDeclarationCtx : ctx.methodDeclaration()) {
            methodDeclarationCtx.accept(this);
        }

        currentClass = null;
        return currentProgram;
    }

    @Override
    public Program visitIdentifier(MiniJavaParser.IdentifierContext ctx) {
        ctx.IDENTIFIER().accept(this);

        currentIdentifier = new Identifier(currentSymbol);

        return currentProgram;
    }

    @Override
    public Program visitVarDeclaration(MiniJavaParser.VarDeclarationContext ctx) {
        MiniJavaParser.TypeContext typeCtx = ctx.type();
        MiniJavaParser.IdentifierContext indentifierCtx = ctx.identifier();

        indentifierCtx.accept(this);
        Identifier variableIdentifier = currentIdentifier;

        typeCtx.accept(this);
        Type variableType = currentType;


        VarDecl varDeclaration = new VarDecl(variableType, variableIdentifier);

        if (currentMethod != null && currentMethod instanceof MethodDecl) {
            currentMethod.vl.addElement(varDeclaration);
        } else if (currentClass instanceof ClassDeclSimple) {
            ((ClassDeclSimple) currentClass).vl.addElement(varDeclaration);
        } else if (currentClass instanceof ClassDeclExtends) {
            ((ClassDeclExtends) currentClass).vl.addElement(varDeclaration);
        }

        return currentProgram;
    }

    @Override
    public Program visitType(MiniJavaParser.TypeContext ctx) {
        if (ctx.BOOLEAN() != null) {
            currentType = new BooleanType();
        } else if (ctx.INT() != null) {
            currentType = new IntegerType();
        } else if (ctx.INT_ARRAY() != null) {
            currentType = new IntArrayType();
        } else {
            ctx.identifier().accept(this);
            currentType = new IdentifierType(currentIdentifier.s);
        }
        return currentProgram;
    }

    @Override
    public Program visitMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx) {
        ctx.type().accept(this);
        Type returnType = currentType;

        ctx.identifier().accept(this);
        Identifier name = currentIdentifier;

        ctx.expression().accept(this);
        Exp returnExp = currentExp;

        FormalList formalList = new FormalList();
        VarDeclList varDeclList = new VarDeclList();
        StatementList statementList = new StatementList();

        currentMethod = new MethodDecl(
                returnType,
                name,
                formalList,
                varDeclList,
                statementList,
                returnExp
        );

        ctx.parameterList().accept(this);

        for (MiniJavaParser.VarDeclarationContext varDeclCtx : ctx.varDeclaration()) {
            varDeclCtx.accept(this);
        }

        for (MiniJavaParser.StatementContext stmCtx : ctx.statement()) {
            stmCtx.accept(this);
        }

        currentMethod = null;

        return currentProgram;
    }


    @Override
    public Program visitParameterList(MiniJavaParser.ParameterListContext ctx) {

        for (int i = 0; i < ctx.type().size(); i++) {
            ctx.type(i).accept(this);
            Type parameterType = currentType;

            ctx.identifier(i).accept(this);
            Identifier parameterIdentifier = currentIdentifier;

            Formal formal = new Formal(parameterType, parameterIdentifier);

            currentMethod.fl.addElement(formal);
        }

        return currentProgram;
    }

    @Override
    public Program visitExpression(MiniJavaParser.ExpressionContext ctx) {
        // TODO: Remover Mock
        currentExp = new True();

        return currentProgram;
    }

    @Override
    public Program visitStatement(MiniJavaParser.StatementContext ctx) {
        if (ctx.assignment() != null) {
            ctx.assignment().accept(this);
        } else if (ctx.arrayAssignment() != null) {
            ctx.arrayAssignment().accept(this);
        } else if (ctx.ifStatement() != null) {
            ctx.ifStatement().accept(this);
        } else if (ctx.statementBlock() != null) {
            ctx.statementBlock().accept(this);
        } else if (ctx.print().accept(this) != null) {
            ctx.print().accept(this);
        } else if (ctx.whileStatement().accept(this) != null) {
            ctx.whileStatement().accept(this);
        }

        return currentProgram;
    }


    @Override
    public Program visitAssignment(MiniJavaParser.AssignmentContext ctx) {
        ctx.identifier().accept(this);
        Identifier variableIdentifier = currentIdentifier;

        ctx.expression().accept(this);
        Exp assigmentExp = currentExp;


        Assignment assignment = new Assignment(variableIdentifier, assigmentExp);
        currentStatement =
    }

    @Override
    public Program visitAnd(MiniJavaParser.AndContext ctx) {
        return null;
    }

    @Override
    public Program visitArrayAssignment(MiniJavaParser.ArrayAssignmentContext ctx) {
        return null;
    }

    @Override
    public Program visitArrayInstatiation(MiniJavaParser.ArrayInstatiationContext ctx) {
        return null;
    }

    @Override
    public Program visitArrayLength(MiniJavaParser.ArrayLengthContext ctx) {
        return null;
    }

    @Override
    public Program visitArrayLookup(MiniJavaParser.ArrayLookupContext ctx) {
        return null;
    }

    @Override
    public Program visitExpressionLeft(MiniJavaParser.ExpressionLeftContext ctx) {
        return null;
    }

    @Override
    public Program visitExpressionRight(MiniJavaParser.ExpressionRightContext ctx) {
        return null;
    }

    @Override
    public Program visitIfStatement(MiniJavaParser.IfStatementContext ctx) {
        return null;
    }

    @Override
    public Program visitLessThan(MiniJavaParser.LessThanContext ctx) {
        return null;
    }

    @Override
    public Program visitMainClass(MiniJavaParser.MainClassContext ctx) {
        return null;
    }

    @Override
    public Program visitMethodCall(MiniJavaParser.MethodCallContext ctx) {
        return null;
    }

    @Override
    public Program visitMinus(MiniJavaParser.MinusContext ctx) {
        return null;
    }

    @Override
    public Program visitNotExpression(MiniJavaParser.NotExpressionContext ctx) {
        return null;
    }

    @Override
    public Program visitObjectInstatiation(MiniJavaParser.ObjectInstatiationContext ctx) {
        return null;
    }

    @Override
    public Program visitParameterListCall(MiniJavaParser.ParameterListCallContext ctx) {
        return null;
    }

    @Override
    public Program visitParentesis(MiniJavaParser.ParentesisContext ctx) {
        return null;
    }

    @Override
    public Program visitPlus(MiniJavaParser.PlusContext ctx) {
        return null;
    }

    @Override
    public Program visitPrint(MiniJavaParser.PrintContext ctx) {
        return null;
    }

    @Override
    public Program visitStatementBlock(MiniJavaParser.StatementBlockContext ctx) {
        return null;
    }

    @Override
    public Program visitTimes(MiniJavaParser.TimesContext ctx) {
        return null;
    }

    @Override
    public Program visitWhileStatement(MiniJavaParser.WhileStatementContext ctx) {
        return null;
    }
}
