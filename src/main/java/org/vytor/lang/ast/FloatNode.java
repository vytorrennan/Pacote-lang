package org.vytor.lang.ast;

public class FloatNode extends Expression{

    public float number;

    public FloatNode(float number) {
        super(NodeType.FloatNode);
    }
}
