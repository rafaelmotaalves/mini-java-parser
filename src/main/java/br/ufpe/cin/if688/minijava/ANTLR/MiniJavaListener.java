// Generated from /home/rafaelmota/mini-java-parser/src/main/java/br/ufpe/cin/if688/minijava/MiniJava.g4 by ANTLR 4.7.2

package br.ufpe.cin.if688.minijava.ANTLR;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniJavaParser}.
 */
public interface MiniJavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#goal}.
	 * @param ctx the parse tree
	 */
	void enterGoal(MiniJavaParser.GoalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#goal}.
	 * @param ctx the parse tree
	 */
	void exitGoal(MiniJavaParser.GoalContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void enterMainClass(MiniJavaParser.MainClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void exitMainClass(MiniJavaParser.MainClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(MiniJavaParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(MiniJavaParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(MiniJavaParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(MiniJavaParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MiniJavaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MiniJavaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#statementBlock}.
	 * @param ctx the parse tree
	 */
	void enterStatementBlock(MiniJavaParser.StatementBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#statementBlock}.
	 * @param ctx the parse tree
	 */
	void exitStatementBlock(MiniJavaParser.StatementBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MiniJavaParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MiniJavaParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MiniJavaParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MiniJavaParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(MiniJavaParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(MiniJavaParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(MiniJavaParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(MiniJavaParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#arrayAssignment}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssignment(MiniJavaParser.ArrayAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#arrayAssignment}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssignment(MiniJavaParser.ArrayAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MiniJavaParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MiniJavaParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#expressionLeft}.
	 * @param ctx the parse tree
	 */
	void enterExpressionLeft(MiniJavaParser.ExpressionLeftContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#expressionLeft}.
	 * @param ctx the parse tree
	 */
	void exitExpressionLeft(MiniJavaParser.ExpressionLeftContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#parentesis}.
	 * @param ctx the parse tree
	 */
	void enterParentesis(MiniJavaParser.ParentesisContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#parentesis}.
	 * @param ctx the parse tree
	 */
	void exitParentesis(MiniJavaParser.ParentesisContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#expressionRight}.
	 * @param ctx the parse tree
	 */
	void enterExpressionRight(MiniJavaParser.ExpressionRightContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#expressionRight}.
	 * @param ctx the parse tree
	 */
	void exitExpressionRight(MiniJavaParser.ExpressionRightContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(MiniJavaParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(MiniJavaParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#parameterListCall}.
	 * @param ctx the parse tree
	 */
	void enterParameterListCall(MiniJavaParser.ParameterListCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#parameterListCall}.
	 * @param ctx the parse tree
	 */
	void exitParameterListCall(MiniJavaParser.ParameterListCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#and}.
	 * @param ctx the parse tree
	 */
	void enterAnd(MiniJavaParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#and}.
	 * @param ctx the parse tree
	 */
	void exitAnd(MiniJavaParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#plus}.
	 * @param ctx the parse tree
	 */
	void enterPlus(MiniJavaParser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#plus}.
	 * @param ctx the parse tree
	 */
	void exitPlus(MiniJavaParser.PlusContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#minus}.
	 * @param ctx the parse tree
	 */
	void enterMinus(MiniJavaParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#minus}.
	 * @param ctx the parse tree
	 */
	void exitMinus(MiniJavaParser.MinusContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#times}.
	 * @param ctx the parse tree
	 */
	void enterTimes(MiniJavaParser.TimesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#times}.
	 * @param ctx the parse tree
	 */
	void exitTimes(MiniJavaParser.TimesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#lessThan}.
	 * @param ctx the parse tree
	 */
	void enterLessThan(MiniJavaParser.LessThanContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#lessThan}.
	 * @param ctx the parse tree
	 */
	void exitLessThan(MiniJavaParser.LessThanContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#arrayLength}.
	 * @param ctx the parse tree
	 */
	void enterArrayLength(MiniJavaParser.ArrayLengthContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#arrayLength}.
	 * @param ctx the parse tree
	 */
	void exitArrayLength(MiniJavaParser.ArrayLengthContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#arrayLookup}.
	 * @param ctx the parse tree
	 */
	void enterArrayLookup(MiniJavaParser.ArrayLookupContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#arrayLookup}.
	 * @param ctx the parse tree
	 */
	void exitArrayLookup(MiniJavaParser.ArrayLookupContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(MiniJavaParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(MiniJavaParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#objectInstatiation}.
	 * @param ctx the parse tree
	 */
	void enterObjectInstatiation(MiniJavaParser.ObjectInstatiationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#objectInstatiation}.
	 * @param ctx the parse tree
	 */
	void exitObjectInstatiation(MiniJavaParser.ObjectInstatiationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#arrayInstatiation}.
	 * @param ctx the parse tree
	 */
	void enterArrayInstatiation(MiniJavaParser.ArrayInstatiationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#arrayInstatiation}.
	 * @param ctx the parse tree
	 */
	void exitArrayInstatiation(MiniJavaParser.ArrayInstatiationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(MiniJavaParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(MiniJavaParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MiniJavaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MiniJavaParser.TypeContext ctx);
}