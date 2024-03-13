package org.vytor.lang.lexer;

import org.vytor.lang.exceptions.Exception_;

public class Token {

    public TokenType type;
    public String value;
    public Exception_ exception = null;

    public Token(TokenType type) {
        this.type = type;
        this.value = null;
    }

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    public Token(Exception_ exception) {
        this.exception = exception;
    }

    @Override
    public String toString() {
        if (this.value != null) {
            return this.value + ":" + this.type;
        }
        return this.type.name();
    }
}
