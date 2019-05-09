// Generated from /home/rafaelmota/mini-java-parser/src/main/java/br/ufpe/cin/if688/minijava/MiniJava.g4 by ANTLR 4.7.2
package br.ufpe.cin.if688.minijava.ANTLR;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniJavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniJavaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#goal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoal(MiniJavaParser.GoalContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#mainClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainClass(MiniJavaParser.MainClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(MiniJavaParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(MiniJavaParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MiniJavaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#statementBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementBlock(MiniJavaParser.StatementBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MiniJavaParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MiniJavaParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(MiniJavaParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(MiniJavaParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#arrayAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAssignment(MiniJavaParser.ArrayAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MiniJavaParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#expressionLeft}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionLeft(MiniJavaParser.ExpressionLeftContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#parentesis}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentesis(MiniJavaParser.ParentesisContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#expressionRight}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionRight(MiniJavaParser.ExpressionRightContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(MiniJavaParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#parameterListCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterListCall(MiniJavaParser.ParameterListCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(MiniJavaParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#plus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus(MiniJavaParser.PlusContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#minus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(MiniJavaParser.MinusContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#times}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimes(MiniJavaParser.TimesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#lessThan}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThan(MiniJavaParser.LessThanContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#arrayLength}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLength(MiniJavaParser.ArrayLengthContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#arrayLookup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLookup(MiniJavaParser.ArrayLookupContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#notExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(MiniJavaParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#objectInstatiation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectInstatiation(MiniJavaParser.ObjectInstatiationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#arrayInstatiation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInstatiation(MiniJavaParser.ArrayInstatiationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(MiniJavaParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MiniJavaParser.TypeContext ctx);
}