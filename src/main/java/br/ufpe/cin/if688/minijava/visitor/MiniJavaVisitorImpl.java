package br.ufpe.cin.if688.minijava.visitor;

import br.ufpe.cin.if688.minijava.ANTLR.MiniJavaParser;
import br.ufpe.cin.if688.minijava.ANTLR.MiniJavaVisitor;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import br.ufpe.cin.if688.minijava.ast.*;

public class MiniJavaVisitorImpl implements MiniJavaVisitor<Program> {

    @Override
    public Program visit(ParseTree parseTree) {
        return null;
    }

    @Override
    public Program visitChildren(RuleNode ruleNode) {
        return null;
    }

    @Override
    public Program visitErrorNode(ErrorNode errorNode) {
        return null;
    }

    @Override
    public Program visitTerminal(TerminalNode terminalNode) {
        return null;
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
    public Program visitAssignment(MiniJavaParser.AssignmentContext ctx) {
        return null;
    }

    @Override
    public Program visitClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        return null;
    }

    @Override
    public Program visitExpression(MiniJavaParser.ExpressionContext ctx) {
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
    public Program visitGoal(MiniJavaParser.GoalContext ctx) {
        return null;
    }

    @Override
    public Program visitIdentifier(MiniJavaParser.IdentifierContext ctx) {
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
    public Program visitMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx) {
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
    public Program visitParameterList(MiniJavaParser.ParameterListContext ctx) {
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
    public Program visitStatement(MiniJavaParser.StatementContext ctx) {
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
    public Program visitType(MiniJavaParser.TypeContext ctx) {
        return null;
    }

    @Override
    public Program visitVarDeclaration(MiniJavaParser.VarDeclarationContext ctx) {
        return null;
    }

    @Override
    public Program visitWhileStatement(MiniJavaParser.WhileStatementContext ctx) {
        return null;
    }
}
