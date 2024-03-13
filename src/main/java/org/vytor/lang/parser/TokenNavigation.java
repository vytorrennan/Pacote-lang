package org.vytor.lang.parser;

import org.vytor.lang.lexer.Token;

import java.util.ArrayList;

public class TokenNavigation {
    private final ArrayList<Token> tokens;
    private final PositionToken positionToken;
    private Token currentToken;

    public TokenNavigation(ArrayList<Token> tokens, PositionToken positionToken) {
        this.tokens = tokens;
        this.positionToken = positionToken;
        this.currentToken = this.tokens.get(positionToken.getTokenIndex());
    }

    public Token advance() {
        if (this.positionToken.getTokenIndex() < tokens.size()) {
            this.positionToken.advancePosition();
            this.currentToken = this.tokens.get(this.positionToken.getTokenIndex());
        } else {
            this.currentToken = null;
        }

        return currentToken;
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }

    public PositionToken getPositionToken() {
        return positionToken;
    }

    public Token getCurrentToken() {
        return currentToken;
    }

}
