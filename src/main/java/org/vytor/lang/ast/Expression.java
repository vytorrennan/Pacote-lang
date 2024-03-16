package org.vytor.lang.ast;

public abstract class Expression extends Statement{
    public Expression(NodeType nodeType) {
        super(nodeType);
    }
}
