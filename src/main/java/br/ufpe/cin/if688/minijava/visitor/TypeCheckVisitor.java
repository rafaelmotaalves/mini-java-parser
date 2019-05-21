package br.ufpe.cin.if688.minijava.visitor;

import br.ufpe.cin.if688.minijava.ast.And;
import br.ufpe.cin.if688.minijava.ast.ArrayAssign;
import br.ufpe.cin.if688.minijava.ast.ArrayLength;
import br.ufpe.cin.if688.minijava.ast.ArrayLookup;
import br.ufpe.cin.if688.minijava.ast.Assign;
import br.ufpe.cin.if688.minijava.ast.Block;
import br.ufpe.cin.if688.minijava.ast.BooleanType;
import br.ufpe.cin.if688.minijava.ast.Call;
import br.ufpe.cin.if688.minijava.ast.ClassDeclExtends;
import br.ufpe.cin.if688.minijava.ast.ClassDeclSimple;
import br.ufpe.cin.if688.minijava.ast.False;
import br.ufpe.cin.if688.minijava.ast.Formal;
import br.ufpe.cin.if688.minijava.ast.Identifier;
import br.ufpe.cin.if688.minijava.ast.IdentifierExp;
import br.ufpe.cin.if688.minijava.ast.IdentifierType;
import br.ufpe.cin.if688.minijava.ast.If;
import br.ufpe.cin.if688.minijava.ast.IntArrayType;
import br.ufpe.cin.if688.minijava.ast.IntegerLiteral;
import br.ufpe.cin.if688.minijava.ast.IntegerType;
import br.ufpe.cin.if688.minijava.ast.LessThan;
import br.ufpe.cin.if688.minijava.ast.MainClass;
import br.ufpe.cin.if688.minijava.ast.MethodDecl;
import br.ufpe.cin.if688.minijava.ast.Minus;
import br.ufpe.cin.if688.minijava.ast.NewArray;
import br.ufpe.cin.if688.minijava.ast.NewObject;
import br.ufpe.cin.if688.minijava.ast.Not;
import br.ufpe.cin.if688.minijava.ast.Plus;
import br.ufpe.cin.if688.minijava.ast.Print;
import br.ufpe.cin.if688.minijava.ast.Program;
import br.ufpe.cin.if688.minijava.ast.This;
import br.ufpe.cin.if688.minijava.ast.Times;
import br.ufpe.cin.if688.minijava.ast.True;
import br.ufpe.cin.if688.minijava.ast.Type;
import br.ufpe.cin.if688.minijava.ast.VarDecl;
import br.ufpe.cin.if688.minijava.ast.While;
import br.ufpe.cin.if688.minijava.ast.Exp;
import br.ufpe.cin.if688.minijava.exceptions.PrintException;
import br.ufpe.cin.if688.minijava.symboltable.Method;
import br.ufpe.cin.if688.minijava.symboltable.SymbolTable;
import br.ufpe.cin.if688.minijava.symboltable.Class;

import java.util.Enumeration;

public class TypeCheckVisitor implements IVisitor<Type>{

	private SymbolTable symbolTable;

	public TypeCheckVisitor(SymbolTable st) {
		symbolTable = st;
	}

	private Class currClass;
	private Method currMethod;

	// MainClass m;
	// ClassDeclList cl;
	public Type visit(Program n) {
		n.m.accept(this);
		for (int i = 0; i < n.cl.size(); i++) {
			n.cl.elementAt(i).accept(this);
		}
		return null;
	}

	// Identifier i1,i2;
	// Statement s;
	public Type visit(MainClass n) {
		n.s.accept(this);
		return null;
	}

	// Identifier i;
	// VarDeclList vl;
	// MethodDeclList ml;
	public Type visit(ClassDeclSimple n) {
		currClass = symbolTable.getClass(n.i.toString());

		for (int i = 0; i < n.vl.size(); i++) {
			n.vl.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.ml.size(); i++) {
			n.ml.elementAt(i).accept(this);
		}

		currClass = null;
		return null;
	}

	// Identifier i;
	// Identifier j;
	// VarDeclList vl;
	// MethodDeclList ml;
	public Type visit(ClassDeclExtends n) {
		currClass = symbolTable.getClass(n.i.toString());

		if (symbolTable.getClass(n.j.toString()) == null) {
			PrintException.idNotFound(n.j.toString());
		}

		for (int i = 0; i < n.vl.size(); i++) {
			n.vl.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.ml.size(); i++) {
			n.ml.elementAt(i).accept(this);
		}

		currClass = null;
		return null;
	}

	// Type t;
	// Identifier i;
	public Type visit(VarDecl n) {
		n.t.accept(this);
		n.i.accept(this);
		return null;
	}

	// Type t;
	// Identifier i;
	// FormalList fl;
	// VarDeclList vl;
	// StatementList sl;
	// Exp e;
	public Type visit(MethodDecl n) {
		n.t.accept(this);

		currMethod = currClass.getMethod(n.i.toString());

		for (int i = 0; i < n.fl.size(); i++) {
			n.fl.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.vl.size(); i++) {
			n.vl.elementAt(i).accept(this);
		}
		for (int i = 0; i < n.sl.size(); i++) {
			n.sl.elementAt(i).accept(this);
		}


		Type returnType = n.e.accept(this);
		if (!symbolTable.compareTypes(returnType, n.t)) {
			PrintException.typeMatch(n.t, returnType);
			return null;
		}

		currMethod = null;

		return null;
	}

	// Type t;
	// Identifier i;
	public Type visit(Formal n) {
		Type formalType = n.t.accept(this);
		n.i.accept(this);

		return formalType;
	}

	public Type visit(IntArrayType n) {
		return new IntegerType();
	}

	public Type visit(BooleanType n) {
		return new BooleanType();
	}

	public Type visit(IntegerType n) {
		return new IntegerType();
	}

	// String s;
	public Type visit(IdentifierType n) {
		return new IdentifierType(n.s);
	}

	// StatementList sl;
	public Type visit(Block n) {
		for (int i = 0; i < n.sl.size(); i++) {
			n.sl.elementAt(i).accept(this);
		}
		return null;
	}

	// Exp e;
	// Statement s1,s2;
	public Type visit(If n) {
		Type conditionType = n.e.accept(this);
		if (symbolTable.compareTypes(new BooleanType(), conditionType)) {
			n.s1.accept(this);
			n.s2.accept(this);
			return null;
		}

		PrintException.typeMatch(new BooleanType(), conditionType);

		return null;
	}

	// Exp e;
	// Statement s;
	public Type visit(While n) {
		Type conditionType = n.e.accept(this);
		if (symbolTable.compareTypes(new BooleanType(), conditionType)) {
			n.s.accept(this);
			return null;
		}

		PrintException.typeMatch(new BooleanType(), conditionType);

		return null;
	}

	// Exp e;
	public Type visit(Print n) {
		n.e.accept(this);
		return null;
	}

	// Identifier i;
	// Exp e;
	public Type visit(Assign n) {
		Type leftType = n.i.accept(this);
		Type rightType = n.e.accept(this);

		if (symbolTable.compareTypes(leftType, rightType)) {
			return leftType;
		}

		PrintException.typeMatch(leftType, rightType);

		return null;
	}

	// Identifier i;
	// Exp e1,e2;
	public Type visit(ArrayAssign n) {
		Type arrType = n.i.accept(this);

		if (symbolTable.compareTypes(arrType, new IntArrayType())) {
			Type indexType = n.e1.accept(this);
			if (symbolTable.compareTypes(new IntegerType(), indexType)) {
				Type valueType = n.e2.accept(this);
				if (symbolTable.compareTypes(new IntegerType(), valueType)) {
					return arrType;
				}

				PrintException.typeMatch(new IntegerType(), valueType);
			}

			PrintException.typeMatch(new IntegerType(), indexType);
		}

		PrintException.typeMatch(new IntArrayType(), arrType);

		return null;
	}

	// Exp e1,e2;
	public Type visit(And n) {
		Type leftType = n.e1.accept(this);
		Type rightType = n.e2.accept(this);

		if (symbolTable.compareTypes(new BooleanType(), leftType)) {
			if (symbolTable.compareTypes(new BooleanType(), rightType)) {
				return new BooleanType();
			}
			PrintException.typeMatch(new BooleanType(), rightType);
		}
		PrintException.typeMatch(new BooleanType(), leftType);

		return null;
	}

	// Exp e1,e2;
	public Type visit(LessThan n) {
		Type leftType = n.e1.accept(this);
		Type rightType = n.e2.accept(this);

		if (symbolTable.compareTypes(new IntegerType(), leftType)) {
			if (symbolTable.compareTypes(new IntegerType(), rightType)) {
				return new BooleanType();
			}
			PrintException.typeMatch(new IntegerType(), rightType);
		}
		PrintException.typeMatch(new IntegerType(), leftType);

		return null;
	}

	// Exp e1,e2;
	public Type visit(Plus n) {
		Type leftType = n.e1.accept(this);
		Type rightType = n.e2.accept(this);

		return validateArithmeticExp(leftType, rightType);
	}

	// Exp e1,e2;
	public Type visit(Minus n) {
		Type leftType = n.e1.accept(this);
		Type rightType = n.e2.accept(this);

		return validateArithmeticExp(leftType, rightType);
	}

	// Exp e1,e2;
	public Type visit(Times n) {
		Type leftType = n.e1.accept(this);
		Type rightType = n.e2.accept(this);

		return validateArithmeticExp(leftType, rightType);
	}

	private Type validateArithmeticExp (Type leftType, Type rightType) {
		if (symbolTable.compareTypes(new IntegerType(), leftType)) {
			if (symbolTable.compareTypes(new IntegerType(), rightType)) {
				return new IntegerType();
			}

			PrintException.typeMatch(new IntegerType(), rightType);
		}
		PrintException.typeMatch(new IntegerType(), leftType);

		return null;
	}

	// Exp e1,e2;
	public Type visit(ArrayLookup n) {
		Type arrExpType = n.e1.accept(this);

		if (symbolTable.compareTypes(arrExpType, new IntArrayType())) {
			Type indexType = n.e2.accept(this);

			if (symbolTable.compareTypes(indexType, new IntegerType())) {
				return new IntegerType();
			}

			PrintException.typeMatch(new IntegerType(), indexType);
		}

		PrintException.typeMatch(new IntArrayType(), arrExpType);

		return null;
	}

	// Exp e;
	public Type visit(ArrayLength n) {
		Type expType = n.e.accept(this);

		if (symbolTable.compareTypes(expType, new IntArrayType())) {
			return new IntegerType();
		}

		PrintException.typeMatch(new IntArrayType(), expType);
		return null;
	}

	// Exp e;
	// Identifier i;
	// ExpList el;
	public Type visit(Call n) {
		String methodName = n.i.toString();
		String className;
		Exp leftExp = n.e;

		Type leftType = leftExp.accept(this);
		className = "";
		if (leftType instanceof IdentifierType) {
			className = ((IdentifierType) leftType).s;
		}

		Method method = symbolTable.getMethod(methodName, className);

		int paramsSize = 0;
		Enumeration params = method.getParams();
		while (params.hasMoreElements()) {
			paramsSize ++;
			params.nextElement();
		}

		if (n.el.size() > paramsSize) {
			PrintException.tooManyArguments(methodName);
		} else if (n.el.size() < paramsSize) {
			PrintException.tooFewArguments(methodName);
		} else {
			for (int i = 0; i < n.el.size(); i++) {
				Type actualType = n.el.elementAt(i).accept(this);
				Type expectedType = method.getParamAt(i).type();

				if (!symbolTable.compareTypes(actualType, expectedType)) {
					PrintException.typeMatch(expectedType, actualType);
				}
			}
		}

		return method.type();
	}

	// int i;
	public Type visit(IntegerLiteral n) {
		return new IntegerType();
	}

	public Type visit(True n) {
		return new BooleanType();
	}

	public Type visit(False n) {
		return new BooleanType();
	}

	// String s;
	public Type visit(IdentifierExp n) {
		return new Identifier(n.s).accept(this);
	}

	public Type visit(This n) {
		return currClass.type();
	}

	// Exp e;
	public Type visit(NewArray n) {
		n.e.accept(this);
		return new IntArrayType();
	}

	// Identifier i;
	public Type visit(NewObject n) {
		Class objectClass = symbolTable.getClass(n.i.toString());

		return new IdentifierType(objectClass.getId());
	}

	// Exp e;
	public Type visit(Not n) {
		Type expressionType = n.e.accept(this);

		if (symbolTable.compareTypes(expressionType, new BooleanType())) {
			return new BooleanType();
		}

		PrintException.typeMatch(new BooleanType(), expressionType);
		return null;
	}

	// String s;
	public Type visit(Identifier n) {
		String varId = n.toString();
		if (currMethod != null) {
			return symbolTable.getVarType(currMethod, currClass, varId);
		} else if (currClass != null){
			Type a = currClass.getVar(varId).type();
			return a;
		}

		PrintException.idNotFound(varId);
		return null;
	}
}