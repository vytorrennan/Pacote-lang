package org.vytor.lang.ast;

public class Identifier extends Expression{

    public String symbol;

    public Identifier(String symbol) {
        super(NodeType.Identifier);
        this.symbol = symbol;
    }
}
