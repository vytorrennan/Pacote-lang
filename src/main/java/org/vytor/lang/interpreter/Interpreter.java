package org.vytor.lang.interpreter;

import org.vytor.lang.ast.*;
import org.vytor.lang.runtimeValues.*;


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

    private IntValue evaluateIntBinaryExpression(IntValue left, String operator, IntValue right) {
        Integer result = null;
        switch (operator) {
            case "+":
                result = left.value + right.value;
                break;
            case "-":
                result = left.value - right.value;
                break;
            case "*":
                result = left.value * right.value;
                break;
            case "/":
                result = left.value / right.value;
                break;
            case "%":
                result = left.value % right.value;
                break;
        }

        return new IntValue(result);
    }

    private FloatValue evaluateFloatBinaryExpression(FloatValue left, String operator, FloatValue right) {
        Float result = null;
        switch (operator) {
            case "+":
                result = left.value + right.value;
                break;
            case "-":
                result = left.value - right.value;
                break;
            case "*":
                result = left.value * right.value;
                break;
            case "/":
                result = left.value / right.value;
                break;
            case "%":
                result = left.value % right.value;
                break;
        }

        return new FloatValue(result);
    }

    private RuntimeValue evaluateBinaryExpression(BinaryExpression binaryExpr) {

        RuntimeValue left = evaluate(binaryExpr.left);
        String operator = binaryExpr.operator;
        RuntimeValue right = evaluate(binaryExpr.right);

        if (left.valueType == ValueType.Int) {
            if (right.valueType == ValueType.Int) {
                return evaluateIntBinaryExpression((IntValue) left, operator, (IntValue) right);
            }
        }
        if (left.valueType == ValueType.Float) {
            if (right.valueType == ValueType.Float) {
                return evaluateFloatBinaryExpression((FloatValue) left, operator, (FloatValue) right);
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
