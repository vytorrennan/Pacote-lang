package org.vytor.lang.interpreter;

import org.vytor.lang.ast.*;
import org.vytor.lang.runtimeValues.*;
import org.vytor.lang.runtimeValues.Number;


public class Interpreter {

    public Interpreter() {

    }

    private RuntimeValue evaluateProgram(Program program) {
        RuntimeValue result = new NullValue();

        for (Statement node : program.getAllStatements()) {
            result = evaluate(node);
        }

        return result;
    }

    private java.lang.Number arithmeticOfNumbers(java.lang.Number left, String operator, java.lang.Number right) {
        java.lang.Number result = null;

        switch (operator) {
            case "+":
                result = (left instanceof Integer ? (Integer) left : (Float) left) +
                        (right instanceof Integer ? (Integer) right : (Float) right);
                break;
            case "-":
                result = (left instanceof Integer ? (Integer) left : (Float) left) -
                        (right instanceof Integer ? (Integer) right : (Float) right);
                break;
            case "*":
                result = (left instanceof Integer ? (Integer) left : (Float) left) *
                        (right instanceof Integer ? (Integer) right : (Float) right);
                break;
            case "/":
                result = (left instanceof Integer ? (Integer) left : (Float) left) /
                        (right instanceof Integer ? (Integer) right : (Float) right);
                break;
            case "%":
                result = (left instanceof Integer ? (Integer) left : (Float) left) %
                        (right instanceof Integer ? (Integer) right : (Float) right);
                break;
        }

        if (left instanceof Integer && right instanceof Integer) {
            return (Integer) ((int) ((float) result));
        } else {
            return result;
        }
    }



    private RuntimeValue evaluateBinaryExpression(BinaryExpression binaryExpr) {

        RuntimeValue left = evaluate(binaryExpr.left);
        String operator = binaryExpr.operator;
        RuntimeValue right = evaluate(binaryExpr.right);

        if (left.valueType == ValueType.Float || left.valueType == ValueType.Int &&
                right.valueType == ValueType.Float || right.valueType == ValueType.Int) {

            java.lang.Number result =
                    arithmeticOfNumbers(((Number) left).getNumber(), operator, ((Number) right).getNumber());

            if (result instanceof Integer) {
                return new IntValue((Integer) result);
            } else {
                return new FloatValue((Float) result);
            }
        }

        return new NullValue();
    }

    public RuntimeValue evaluate(Statement node) {

        switch (node.nodeType) {
            case IntNode:
                return new IntValue(((IntNode) node).value);
            case FloatNode:
                return new FloatValue(((FloatNode) node).value);
            case BinaryExpression:
                return evaluateBinaryExpression((BinaryExpression) node);
            case Program:
                return evaluateProgram((Program) node);
            case Null:
                return new NullValue();
            default:
                System.out.println("This node has not bean set on interpreter yet: " + node);
                System.exit(0);
                return new NullValue();
        }
    }
}
