package org.vytor.lang.lexer;

import java.util.Hashtable;

public record Keywords() {

    public static final Hashtable<String, TokenType> KEYWORDS = new Hashtable<String, TokenType>() {{
        put("exit", TokenType.EXIT);
        put("true", TokenType.TRUE);
        put("false", TokenType.FALSE);
        put("var", TokenType.VAR);
        put("if", TokenType.IF);
        put("else", TokenType.ELSE);
        put("for", TokenType.FOR);
        put("while", TokenType.WHILE);
    }};
}
