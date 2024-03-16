package org.vytor.lang.lexer;

import java.util.Hashtable;

public record Keywords() {

    public static final Hashtable<String, TokenType> KEYWORDS = new Hashtable<String, TokenType>() {{
        put("var", TokenType.VAR);
    }};
}
