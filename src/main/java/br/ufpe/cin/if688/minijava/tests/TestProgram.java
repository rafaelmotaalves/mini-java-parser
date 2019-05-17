package br.ufpe.cin.if688.minijava.tests;

import br.ufpe.cin.if688.minijava.ANTLR.MiniJavaLexer;
import br.ufpe.cin.if688.minijava.ANTLR.MiniJavaParser;
import br.ufpe.cin.if688.minijava.ast.Program;
import br.ufpe.cin.if688.minijava.visitor.MiniJavaVisitorImpl;
import br.ufpe.cin.if688.minijava.visitor.PrettyPrintVisitor;
import br.ufpe.cin.if688.minijava.visitor.BuildSymbolTableVisitor;
import br.ufpe.cin.if688.minijava.visitor.TypeCheckVisitor;
import br.ufpe.cin.if688.minijava.symboltable.SymbolTable;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class TestProgram {

    public static void main(String[] args) throws IOException {
        String filePath = "/home/rafaelmota/mini-java-parser/src/main/java/br/ufpe/cin/if688/minijava/tests/program.txt";
        CharStream charStream = CharStreams.fromFileName(filePath);
        MiniJavaLexer lexer = new MiniJavaLexer(charStream);

        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        MiniJavaParser parser = new MiniJavaParser(commonTokenStream);

        MiniJavaVisitorImpl miniJava = new MiniJavaVisitorImpl();
        Program program = miniJava.visit(parser.goal());

        BuildSymbolTableVisitor buildSymbolTable = new BuildSymbolTableVisitor();
        buildSymbolTable.visit(program);
        SymbolTable symbolTable = buildSymbolTable.getSymbolTable();

        System.out.println(symbolTable);

        TypeCheckVisitor typeCheckVisitor = new TypeCheckVisitor(symbolTable);

        try {
            typeCheckVisitor.visit(program);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}