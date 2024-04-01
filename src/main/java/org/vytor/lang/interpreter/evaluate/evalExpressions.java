package org.vytor.lang.interpreter.evaluate;

import org.vytor.lang.ast.BinaryExpression;
import org.vytor.lang.ast.Identifier;
import org.vytor.lang.interpreter.Environment;
import org.vytor.lang.interpreter.Interpreter;
import org.vytor.lang.runtimeValues.*;
import org.vytor.lang.runtimeValues.Number;


public class evalExpressions {



    private static java.lang.Number arithmeticOfNumbers(java.lang.Number left, String operator, java.lang.Number right) {
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

    public static RuntimeValue evaluateBinaryExpression(BinaryExpression binaryExpr, Environment env) {

        RuntimeValue left = Interpreter.evaluate(binaryExpr.left, env);
        String operator = binaryExpr.operator;
        RuntimeValue right = Interpreter.evaluate(binaryExpr.right, env);


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

    public static RuntimeValue evaluateIdentifier(Identifier node, Environment env) {
        return env.getValueOfVariable(node.symbol);
    }

}
