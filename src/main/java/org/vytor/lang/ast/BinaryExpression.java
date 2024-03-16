package org.vytor.lang.ast;

public class BinaryExpression extends Expression{

    public Expression left;
    public String operator;
    public Expression right;

    public BinaryExpression(Expression left, String operator, Expression right) {
        super(NodeType.BinaryExpression);
        this.left = left;
        this.operator = operator;
        this.right = right;
    }
}
