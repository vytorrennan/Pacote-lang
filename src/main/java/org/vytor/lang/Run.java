package org.vytor.lang;

import org.vytor.lang.lexer.Lexer;
import org.vytor.lang.lexer.Token;

import java.util.LinkedList;

public class Run {

    public static LinkedList<Token> run(String sourceCode) {
        Lexer lexer = new Lexer(sourceCode);
        return lexer.makeTokens();
    }
}
