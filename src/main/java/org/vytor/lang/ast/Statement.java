package org.vytor.lang.ast;

public abstract class Statement {
    public NodeType nodeType;

    public Statement(NodeType nodeType) {
        this.nodeType = nodeType;
    }

    @Override
    public String toString() {
        return "Statement{" +
                "nodeType=" + nodeType +
                '}';
    }
}
