package br.ufpe.cin.if688.minijava.symboltable;

import br.ufpe.cin.if688.minijava.ast.BooleanType;
import br.ufpe.cin.if688.minijava.ast.IntArrayType;
import br.ufpe.cin.if688.minijava.ast.IntegerType;
import br.ufpe.cin.if688.minijava.ast.Type;

public class Variable {

	String id;
	Type type;

	public Variable(String id, Type type) {
		this.id = id;
		this.type = type;
	}

	public String id() {
		return id;
	}

	public Type type() {
		return type;
	}

	public String toString() {
		return ">>" + getTypeName(type) + " " + id + "\n";
	}

	private String getTypeName(Type type) {
		if (type instanceof IntegerType) {
			return "int";
		} else if (type instanceof IntArrayType) {
			return "int[]";
		} else if (type instanceof BooleanType) {
			return  "boolean";
		} else {
			return type.toString();
		}
	}


} // Variable