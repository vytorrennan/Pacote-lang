package org.vytor.lang.interpreter.evaluate;

import org.vytor.lang.ast.Program;
import org.vytor.lang.ast.Statement;
import org.vytor.lang.ast.VariableAssignment;
import org.vytor.lang.interpreter.Environment;
import org.vytor.lang.interpreter.Interpreter;
import org.vytor.lang.runtimeValues.NullValue;
import org.vytor.lang.runtimeValues.RuntimeValue;

public class evalStatements {

    public static RuntimeValue evaluateProgram(Program program, Environment env) {
        RuntimeValue result = new NullValue();

        for (Statement node : program.getAllStatements()) {
            result = Interpreter.evaluate(node, env);
        }

        return result;
    }


    public static RuntimeValue evaluateVariableAssignment(VariableAssignment node, Environment env) {
        return env.assignVariable(node.identifier.symbol, Interpreter.evaluate(node.expression, env));
    }

}
