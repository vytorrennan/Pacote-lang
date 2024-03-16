package org.vytor.lang.ast;

public class IntNode extends Expression{

    public Integer number;

    public IntNode(Integer number) {
        super(NodeType.IntNode);
        this.number = number;
    }
}
