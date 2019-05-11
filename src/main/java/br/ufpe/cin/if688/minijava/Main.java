package br.ufpe.cin.if688.minijava;

import br.ufpe.cin.if688.minijava.ANTLR.MiniJavaLexer;
import br.ufpe.cin.if688.minijava.ANTLR.MiniJavaParser;
import br.ufpe.cin.if688.minijava.ast.Program;
import br.ufpe.cin.if688.minijava.visitor.MiniJavaVisitorImpl;
import br.ufpe.cin.if688.minijava.visitor.PrettyPrintVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        CharStream charStream = CharStreams.fromStream(System.in);
        MiniJavaLexer lexer = new MiniJavaLexer(charStream);

        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        MiniJavaParser parser = new MiniJavaParser(commonTokenStream);

        MiniJavaVisitorImpl miniJava = new MiniJavaVisitorImpl();
        Program program = miniJava.visit(parser.goal());

        PrettyPrintVisitor printVisitor = new PrettyPrintVisitor();
        printVisitor.visit(program);
    }
}