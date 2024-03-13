package org.vytor.lang.parser;

import org.vytor.lang.lexer.Token;

import java.util.ArrayList;

public class TokenNavigation {
    private final ArrayList<Token> tokens;
    private Integer tokenIndex;
    private Token currentToken;

    public TokenNavigation(ArrayList<Token> tokens) {
        this.tokens = tokens;
        this.tokenIndex = 0;
        this.currentToken = this.tokens.get(tokenIndex);
    }

    public Token advancePosition() {
        if (this.tokenIndex < tokens.size()) {
            this.tokenIndex++;
            this.currentToken = this.tokens.get(tokenIndex);
        }
        return currentToken;
    }
}
