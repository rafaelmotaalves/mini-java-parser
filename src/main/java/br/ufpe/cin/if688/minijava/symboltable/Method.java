package br.ufpe.cin.if688.minijava.symboltable;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import br.ufpe.cin.if688.minijava.ast.BooleanType;
import br.ufpe.cin.if688.minijava.ast.IntArrayType;
import br.ufpe.cin.if688.minijava.ast.IntegerType;
import br.ufpe.cin.if688.minijava.ast.Type;

public class Method {

	String id;
	Type type;
	public Vector<Variable> params;
	public Hashtable<Object, Variable> vars;

	public Method(String id, Type type) {
		this.id = id;
		this.type = type;
		vars = new Hashtable<Object, Variable>();
		params = new Vector<Variable>();
	}

	public String getId() {
		return id;
	}

	public Type type() {
		return type;
	}

	public boolean addParam(String id, Type type) {
		if (containsParam(id))
			return false;
		else {
			params.addElement(new Variable(id, type));
			return true;
		}
	}

	public Enumeration getParams() {
		return params.elements();
	}

	public Variable getParamAt(int i) {
		if (i < params.size())
			return (Variable) params.elementAt(i);
		else
			return null;
	}

	public boolean addVar(String id, Type type) {
		if (vars.containsKey(id))
			return false;
		else {
			vars.put(id, new Variable(id, type));
			return true;
		}
	}

	public boolean containsVar(String id) {
		return vars.containsKey(id);
	}

	public boolean containsParam(String id) {
		for (int i = 0; i < params.size(); i++)
			if (((Variable) params.elementAt(i)).id.equals(id))
				return true;
		return false;
	}

	public Variable getVar(String id) {
		if (containsVar(id))
			return (Variable) vars.get(id);
		else
			return null;
	}

	public Variable getParam(String id) {

		for (int i = 0; i < params.size(); i++)
			if (((Variable) params.elementAt(i)).id.equals(id))
				return (Variable) (params.elementAt(i));

		return null;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(">");
		sb.append(getTypeName(type));
		sb.append(" ");
		sb.append(getId());
		sb.append("()");
		sb.append("\n");
		sb.append(">Parameters:\n");
		for (Variable var : params) {
			sb.append(var.toString());
		}
		sb.append(">Variables:\n");
		for (Object varKey : vars.keySet()) {
			Variable var = getVar((String) varKey);
			sb.append(var.toString());
		}
		return sb.toString();
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

} // Method