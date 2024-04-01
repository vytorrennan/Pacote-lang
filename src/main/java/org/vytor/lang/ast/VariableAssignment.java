package org.vytor.lang.ast;

public class VariableAssignment extends Statement{
    public Identifier identifier;
    public Expression expression;

    public VariableAssignment(Identifier identifier, Expression expression) {
        super(NodeType.VariableAssignment);
        this.identifier = identifier;
        this.expression = expression;
    }
}
