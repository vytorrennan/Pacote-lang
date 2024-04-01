package org.vytor.lang.lexer;

public enum TokenType {
    EOF,
    NULL,
    INT,
    FLOAT,
    IDENTIFIER,
    BINARY_OPERATOR,
    PLUS,
    MINUS,
    MUL,
    DIV,
    EQUALS,
    OPEN_PAREN,
    CLOSE_PAREN,
    OPEN_CURLY_BRACKETS,
    CLOSE_CURLY_BRACKETS,
    EXIT,
    IF,
    ELSE,
    FOR,
    WHILE,
}
