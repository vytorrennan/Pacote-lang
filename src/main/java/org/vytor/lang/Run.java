package org.vytor.lang;

import org.vytor.lang.lexer.Lexer;
import org.vytor.lang.lexer.Token;

import java.util.ArrayList;

public class Run {

    public static ArrayList<Token> run(String sourceCode) {
        Lexer lexer = new Lexer(sourceCode);
        return lexer.makeTokens();
    }
}
