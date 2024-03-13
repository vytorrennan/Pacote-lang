package org.vytor.lang.parser;

import org.vytor.lang.lexer.Token;

import java.util.ArrayList;

public class Parser {

    private final ArrayList<Token> tokens;
    private TokenNavigation tokenNavigation;

    public Parser(ArrayList<Token> tokens, TokenNavigation tokenNavigation) {
        this.tokens = tokens;
        this.tokenNavigation = tokenNavigation;
    }

    

}
