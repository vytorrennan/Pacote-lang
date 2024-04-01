package org.vytor.lang.interpreter;

import org.vytor.lang.ast.*;
import org.vytor.lang.interpreter.evaluate.evalExpressions;
import org.vytor.lang.interpreter.evaluate.evalStatements;
import org.vytor.lang.runtimeValues.*;


public class Interpreter {

    public Interpreter() {

    }

    public static RuntimeValue evaluate(Statement node, Environment env) {

        switch (node.nodeType) {
            case IntNode:
                return new IntValue(((IntNode) node).value);
            case FloatNode:
                return new FloatValue(((FloatNode) node).value);
            case BinaryExpression:
                return evalExpressions.evaluateBinaryExpression((BinaryExpression) node, env);
            case Identifier:
                return evalExpressions.evaluateIdentifier((Identifier) node, env);
            case VariableAssignment:
                return evalStatements.evaluateVariableAssignment((VariableAssignment) node, env);
            case Program:
                return evalStatements.evaluateProgram((Program) node, env);
            default:
                System.out.println("This node has not bean set on interpreter yet: " + node);
                System.exit(0);
                return new NullValue();
        }
    }
}