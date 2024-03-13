package org.vytor.lang.parser;

import org.vytor.lang.lexer.Token;

import java.util.ArrayList;

public class Parser {

    private final ArrayList<Token> tokens;
    private Integer tokenIndex;
    private Token currentToken;

    public Parser(ArrayList<Token> tokens) {
        this.tokens = tokens;
        this.tokenIndex = 0;
        this.currentToken = this.tokens.get(tokenIndex);
    }

    private Token advance() {
        if (this.tokenIndex < tokens.size()) {
            this.tokenIndex++;
            this.currentToken = this.tokens.get(tokenIndex);
        }
        return currentToken;
    }
}
