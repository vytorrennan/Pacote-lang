package org.vytor.lang.ast;

public class IntNode extends Expression{

    public Integer value;

    public IntNode(Integer value) {
        super(NodeType.IntNode);
        this.value = value;
    }
}
