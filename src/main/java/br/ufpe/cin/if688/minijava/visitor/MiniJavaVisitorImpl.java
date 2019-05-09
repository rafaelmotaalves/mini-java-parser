package br.ufpe.cin.if688.minijava.visitor;

import br.ufpe.cin.if688.minijava.ANTLR.MiniJavaParser;
import br.ufpe.cin.if688.minijava.ANTLR.MiniJavaVisitor;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class MiniJavaVisitorImpl<T> implements MiniJavaVisitor<T> {

    @Override
    public T visit(ParseTree parseTree) {
        return null;
    }

    @Override
    public T visitChildren(RuleNode ruleNode) {
        return null;
    }

    @Override
    public T visitErrorNode(ErrorNode errorNode) {
        return null;
    }

    @Override
    public T visitTerminal(TerminalNode terminalNode) {
        return null;
    }

    @Override
    public T visitAnd(MiniJavaParser.AndContext ctx) {
        return null;
    }

    @Override
    public T visitArrayAssignment(MiniJavaParser.ArrayAssignmentContext ctx) {
        return null;
    }

    @Override
    public T visitArrayInstatiation(MiniJavaParser.ArrayInstatiationContext ctx) {
        return null;
    }

    @Override
    public T visitArrayLength(MiniJavaParser.ArrayLengthContext ctx) {
        return null;
    }

    @Override
    public T visitArrayLookup(MiniJavaParser.ArrayLookupContext ctx) {
        return null;
    }

    @Override
    public T visitAssignment(MiniJavaParser.AssignmentContext ctx) {
        return null;
    }

    @Override
    public T visitClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        return null;
    }

    @Override
    public T visitExpression(MiniJavaParser.ExpressionContext ctx) {
        return null;
    }

    @Override
    public T visitExpressionLeft(MiniJavaParser.ExpressionLeftContext ctx) {
        return null;
    }

    @Override
    public T visitExpressionRight(MiniJavaParser.ExpressionRightContext ctx) {
        return null;
    }

    @Override
    public T visitGoal(MiniJavaParser.GoalContext ctx) {
        return null;
    }

    @Override
    public T visitIdentifier(MiniJavaParser.IdentifierContext ctx) {
        return null;
    }

    @Override
    public T visitIfStatement(MiniJavaParser.IfStatementContext ctx) {
        return null;
    }

    @Override
    public T visitLessThan(MiniJavaParser.LessThanContext ctx) {
        return null;
    }

    @Override
    public T visitMainClass(MiniJavaParser.MainClassContext ctx) {
        return null;
    }

    @Override
    public T visitMethodCall(MiniJavaParser.MethodCallContext ctx) {
        return null;
    }

    @Override
    public T visitMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx) {
        return null;
    }

    @Override
    public T visitMinus(MiniJavaParser.MinusContext ctx) {
        return null;
    }

    @Override
    public T visitNotExpression(MiniJavaParser.NotExpressionContext ctx) {
        return null;
    }

    @Override
    public T visitObjectInstatiation(MiniJavaParser.ObjectInstatiationContext ctx) {
        return null;
    }

    @Override
    public T visitParameterList(MiniJavaParser.ParameterListContext ctx) {
        return null;
    }

    @Override
    public T visitParameterListCall(MiniJavaParser.ParameterListCallContext ctx) {
        return null;
    }

    @Override
    public T visitParentesis(MiniJavaParser.ParentesisContext ctx) {
        return null;
    }

    @Override
    public T visitPlus(MiniJavaParser.PlusContext ctx) {
        return null;
    }

    @Override
    public T visitPrint(MiniJavaParser.PrintContext ctx) {
        return null;
    }

    @Override
    public T visitStatement(MiniJavaParser.StatementContext ctx) {
        return null;
    }

    @Override
    public T visitStatementBlock(MiniJavaParser.StatementBlockContext ctx) {
        return null;
    }

    @Override
    public T visitTimes(MiniJavaParser.TimesContext ctx) {
        return null;
    }

    @Override
    public T visitType(MiniJavaParser.TypeContext ctx) {
        return null;
    }

    @Override
    public T visitVarDeclaration(MiniJavaParser.VarDeclarationContext ctx) {
        return null;
    }

    @Override
    public T visitWhileStatement(MiniJavaParser.WhileStatementContext ctx) {
        return null;
    }
}
