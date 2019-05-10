package br.ufpe.cin.if688.minijava.visitor;

import br.ufpe.cin.if688.minijava.ANTLR.MiniJavaVisitor;
import br.ufpe.cin.if688.minijava.ast.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import br.ufpe.cin.if688.minijava.ANTLR.MiniJavaParser;

import javax.swing.plaf.nimbus.State;
import java.beans.Expression;

import static java.lang.Integer.parseInt;

public class MiniJavaVisitorImpl implements MiniJavaVisitor<Program> {


    private Program currentProgram;
    private MainClass currentMain;
    private ClassDecl currentClass;
    private Identifier currentIdentifier;
    private String currentSymbol;
    private Type currentType;
    private MethodDecl currentMethod;
    private Exp currentExp;
    private Statement currentStatement;
    private ExpList currentExpList;

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
        ctx.mainClass().accept(this);
        MainClass mainClass = currentMain;

        ClassDeclList classDeclarationList = new ClassDeclList();

        currentProgram = new Program(currentMain,  classDeclarationList);

        for (MiniJavaParser.ClassDeclarationContext classDeclarationCtx : ctx.classDeclaration()) {
            classDeclarationCtx.accept(this);
        }

        return currentProgram;
    }

    @Override
    public Program visitMainClass(MiniJavaParser.MainClassContext ctx) {
        ctx.identifier(0).accept(this);
        Identifier className = currentIdentifier;

        ctx.identifier(1).accept(this);
        Identifier args = currentIdentifier;

        ctx.statement().accept(this);
        Statement mainStatement = currentStatement;

        currentMain = new MainClass(className, args, mainStatement);
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
        MiniJavaParser.NotExpressionContext notExpression = ctx.notExpression();
        MiniJavaParser.ObjectInstatiationContext objInstatiation = ctx.objectInstatiation();
        MiniJavaParser.ArrayInstatiationContext arrayInstatiation = ctx.arrayInstatiation();
        MiniJavaParser.ParentesisContext parentesisContext = ctx.parentesis();

        if (ctx.TRUE() != null) {
            currentExp = new True();
        } else if (ctx.FALSE() != null) {
            currentExp = new False();
        } else if (ctx.THIS() != null) {
            currentExp = new This();
        } else if (ctx.INTEGER() != null) {
            ctx.INTEGER().accept(this);
            currentExp = new IntegerLiteral(parseInt(currentSymbol));
        } else if (ctx.identifier() != null && ctx.DOT() == null) {
            ctx.identifier().accept(this);
            currentExp = new IdentifierExp(currentIdentifier.toString());
        } else if (notExpression != null) {
            notExpression.accept(this);
        } else if (objInstatiation != null) {
            objInstatiation.accept(this);
        } else if (arrayInstatiation != null) {
            arrayInstatiation.accept(this);
        } else if (parentesisContext != null) {
            parentesisContext.accept(this);
        } else if (ctx.LENGTH() != null) {
            // array length
            ctx.expression(0).accept(this);

            currentExp = new ArrayLength(currentExp);
        } else if (ctx.OPEN_BRACKET() != null && ctx.CLOSE_BRACKET() != null) {
            // array lookup
            ctx.expression(0).accept(this);
            Exp array = currentExp;
            ctx.expression(1).accept(this);
            Exp index = currentExp;

            currentExp = new ArrayLookup(array, index);
        } else if (ctx.OPEN_PARENTESIS() !=  null && ctx.CLOSE_PARENTESIS() != null) {
            // method call

            ctx.expression(0).accept(this);
            Exp leftExp = currentExp;

            ctx.identifier().accept(this);
            Identifier methodName = currentIdentifier;

            ctx.parameterListCall().accept(this);

            currentExp = new Call(leftExp, methodName, currentExpList);
        } else {
            // operation

            ctx.expression(0).accept(this);
            Exp left = currentExp;

            ctx.expression(1).accept(this);
            Exp right = currentExp;

            if (ctx.PLUS() != null) {
                currentExp = new Plus(left, right);
            } else if (ctx.MINUS() != null) {
                currentExp = new Minus(left, right);
            } else if (ctx.TIMES() != null) {
                currentExp = new Times(left, right);
            } else if (ctx.LESS_THAN() != null) {
                currentExp = new LessThan(left, right);
            } else if (ctx.AND() != null) {
                currentExp = new And(left, right);
            }
        }

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
    public Program visitNotExpression(MiniJavaParser.NotExpressionContext ctx) {
        ctx.expression().accept(this);

        currentExp = new Not(currentExp);
        return currentProgram;
    }


    @Override
    public Program visitObjectInstatiation(MiniJavaParser.ObjectInstatiationContext ctx) {
        ctx.identifier().accept(this);
        Identifier objClass = currentIdentifier;

        currentExp = new NewObject(objClass);

        return currentProgram;
    }


    @Override
    public Program visitArrayInstatiation(MiniJavaParser.ArrayInstatiationContext ctx) {
        ctx.expression().accept(this);
        Exp index = currentExp;

        currentExp = new NewArray(index);

        return currentProgram;
    }

    @Override
    public Program visitParentesis(MiniJavaParser.ParentesisContext ctx) {
        ctx.expression().accept(this);

        return currentProgram;
    }

    @Override
    public Program visitParameterListCall(MiniJavaParser.ParameterListCallContext ctx) {
        ExpList parameterList = new ExpList();


        for (MiniJavaParser.ExpressionContext parameterCtx : ctx.expression()) {
            parameterCtx.accept(this);

            parameterList.addElement(currentExp);
        }

        currentExpList = parameterList;

        return currentProgram;
    }



    @Override
    public Program visitAssignment(MiniJavaParser.AssignmentContext ctx) {
        ctx.identifier().accept(this);
        Identifier variableIdentifier = currentIdentifier;

        ctx.expression().accept(this);
        Exp assignmentExp = currentExp;


        Assign assignment = new Assign(variableIdentifier, assignmentExp);
        currentStatement = assignment;

        return currentProgram;
    }


    @Override
    public Program visitArrayAssignment(MiniJavaParser.ArrayAssignmentContext ctx) {
        ctx.identifier().accept(this);
        Identifier arrayName = currentIdentifier;

        ctx.expression(0).accept(this);
        Exp index = currentExp;

        ctx.expression(1).accept(this);
        Exp value = currentExp;

        currentStatement = new ArrayAssign(arrayName, index, value);

        return currentProgram;
    }


    @Override
    public Program visitIfStatement(MiniJavaParser.IfStatementContext ctx) {
        ctx.expression().accept(this);
        Exp condition =  currentExp;

        ctx.statement(0).accept(this);
        Statement mainStm = currentStatement;

        ctx.statement(1).accept(this);
        Statement elseStm = currentStatement;

        currentStatement = new If(condition, mainStm, elseStm);

        return currentProgram;
    }


    @Override
    public Program visitPrint(MiniJavaParser.PrintContext ctx) {
        ctx.expression().accept(this);
        Exp value = currentExp;

        currentStatement = new Print(value);

        return currentProgram;
    }

    @Override
    public Program visitStatementBlock(MiniJavaParser.StatementBlockContext ctx) {
        StatementList stmList = new StatementList();

        for (MiniJavaParser.StatementContext stmCtx : ctx.statement()) {
            stmCtx.accept(this);
            stmList.addElement(currentStatement);
        }


        currentStatement = new Block(stmList);

        return currentProgram;
    }

    @Override
    public Program visitWhileStatement(MiniJavaParser.WhileStatementContext ctx) {
        ctx.expression().accept(this);
        Exp condition = currentExp;

        ctx.statement().accept(this);
        Statement code = currentStatement;

        currentStatement = new While(condition, code);

        return currentProgram;
    }
}
