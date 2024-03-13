package org.vytor.lang.exceptions;

import org.vytor.lang.lexer.PositionSourceCode;

public class IllegalCharException extends Exception_ {

    public IllegalCharException(PositionSourceCode position, Character lastChar) {
        super("IllegalCharException",
                "In line: " + position.getLine() + "In column: " + position.getColumn() +
                        "At the '" + lastChar + "' Character");
    }

}
