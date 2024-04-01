package org.vytor.lang.interpreter;

import org.vytor.lang.ast.*;
import org.vytor.lang.runtimeValues.*;
import org.vytor.lang.runtimeValues.Number;


public class Interpreter {

    public Interpreter() {

    }

    private RuntimeValue evaluateProgram(Program program, Environment env) {
        RuntimeValue result = new NullValue();

        for (Statement node : program.getAllStatements()) {
            result = evaluate(node, env);
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

        if (left instanceof Integer && right instanceof Integer && !operator.equals("/")) {
            return (Integer) ((int) ((float) result));
        } else {
            return result;
        }
    }

    private RuntimeValue evaluateBinaryExpression(BinaryExpression binaryExpr, Environment env) {

        RuntimeValue left = evaluate(binaryExpr.left, env);
        String operator = binaryExpr.operator;
        RuntimeValue right = evaluate(binaryExpr.right, env);


        if ((left.valueType == ValueType.Float || left.valueType == ValueType.Int) &&
                (right.valueType == ValueType.Float || right.valueType == ValueType.Int)) {

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

    private RuntimeValue evaluateIdentifier(Identifier node, Environment env) {
        return env.getValueOfVariable(node.symbol);
    }

    private RuntimeValue evaluateVariableAssignment(VariableAssignment node, Environment env) {
        return env.assignVariable(node.identifier.symbol, evaluate(node.expression, env));
    }

    public RuntimeValue evaluate(Statement node, Environment env) {

        switch (node.nodeType) {
            case IntNode:
                return new IntValue(((IntNode) node).value);
            case FloatNode:
                return new FloatValue(((FloatNode) node).value);
            case BinaryExpression:
                return evaluateBinaryExpression((BinaryExpression) node, env);
            case Identifier:
                return evaluateIdentifier((Identifier) node, env);
            case VariableAssignment:
                return evaluateVariableAssignment((VariableAssignment) node, env);
            case Program:
                return evaluateProgram((Program) node, env);
            default:
                System.out.println("This node has not bean set on interpreter yet: " + node);
                System.exit(0);
                return new NullValue();
        }
    }
}