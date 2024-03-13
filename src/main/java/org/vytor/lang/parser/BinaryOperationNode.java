package org.vytor.lang.parser;

import org.vytor.lang.lexer.Token;

public class BinaryOperationNode {
    private NumberNode leftNumberNode;
    private Token operator;
    private NumberNode rightNumberNode;

    public BinaryOperationNode(NumberNode leftNumberNode, Token operator, NumberNode rightNumberNode) {
        this.leftNumberNode = leftNumberNode;
        this.operator = operator;
        this.rightNumberNode = rightNumberNode;
    }

    @Override
    public String toString() {
        return "BinaryOperationNode{" +
                "leftNumberNode=" + leftNumberNode +
                ", operator=" + operator +
                ", rightNumberNode=" + rightNumberNode +
                '}';
    }
}
