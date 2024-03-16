package org.vytor.lang.parser;

import org.vytor.lang.lexer.Token;
import org.vytor.lang.lexer.TokenType;

import java.util.ArrayList;

public class Parser {

    private final ArrayList<Token> tokens;
    private final TokenNavigation tokenNavigation;

    public Parser(ArrayList<Token> tokens, TokenNavigation tokenNavigation) {
        this.tokens = tokens;
        this.tokenNavigation = tokenNavigation;
    }

    public NumberNode factor() {
        Token token = this.tokenNavigation.getCurrentToken();
        this.tokenNavigation.advance();
        if (token.type == TokenType.INT || token.type == TokenType.FLOAT) {
            return new NumberNode(token);
        } else {
            return null;
        }
    }


}
