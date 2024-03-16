package org.vytor.lang.parser;

import org.vytor.lang.lexer.Token;
import org.vytor.lang.lexer.TokenType;

import java.util.LinkedList;

public class Parser {

    private final LinkedList<Token> tokens;
    private final TokenNavigation tokenNavigation;

    public Parser(LinkedList<Token> tokens) {
        this.tokens = tokens;
        this.tokenNavigation = new TokenNavigation(tokens);
    }

}
