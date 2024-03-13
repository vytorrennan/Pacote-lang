package org.vytor.lang.parser;

import org.vytor.lang.lexer.Token;

public class NumberNode {
    private Token token;

    public NumberNode(Token token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return this.token.toString();
    }
}
