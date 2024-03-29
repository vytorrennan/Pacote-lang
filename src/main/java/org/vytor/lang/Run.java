package org.vytor.lang;

import org.vytor.lang.ast.Program;
import org.vytor.lang.ast.Statement;
import org.vytor.lang.lexer.Lexer;
import org.vytor.lang.lexer.Token;
import org.vytor.lang.parser.Parser;

import java.util.LinkedList;

public class Run {

    public static LinkedList<Statement> run(String sourceCode) {
        Lexer lexer = new Lexer(sourceCode);
        Parser parser = new Parser(lexer.makeTokens());
        return parser.parseToAST().allStatements;
    }
}
