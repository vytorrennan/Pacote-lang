package org.vytor.lang.parser;

import org.vytor.lang.lexer.Token;
import org.vytor.lang.lexer.TokenType;

import java.util.LinkedList;

public class TokenNavigation {
    private final LinkedList<Token> tokens;
    private final PositionToken positionToken;
    private Token currentToken;

    public TokenNavigation(LinkedList<Token> tokens) {
        this.tokens = tokens;
        this.positionToken = new PositionToken();
        this.currentToken = this.tokens.get(positionToken.getTokenIndex());
    }


    public boolean isNotTokenEOF() {
        return this.getCurrentToken().type != TokenType.EOF;
    }

    public Token advance() {
        if(isNotTokenEOF()) {
            this.positionToken.advancePosition();
            this.currentToken = this.tokens.get(this.positionToken.getTokenIndex());
        }

        return currentToken;
    }

    public LinkedList<Token> getTokens() {
        return tokens;
    }

    public PositionToken getPositionToken() {
        return positionToken;
    }

    public Token getCurrentToken() {
        return currentToken;
    }
}
