package org.vytor.lang.ast;

public class FloatNode extends Expression{

    public float value;

    public FloatNode(float value) {
        super(NodeType.FloatNode);
        this.value = value;
    }
}
