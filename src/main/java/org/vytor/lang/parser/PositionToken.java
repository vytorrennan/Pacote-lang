package org.vytor.lang.parser;

import org.vytor.lang.lexer.Token;

import java.util.ArrayList;

public class PositionToken {
    private Integer tokenIndex;

    public PositionToken() {
        this.tokenIndex = 0;
    }

    public void advancePosition() {
        this.tokenIndex++;
    }

    public Integer getTokenIndex() {
        return tokenIndex;
    }

}
