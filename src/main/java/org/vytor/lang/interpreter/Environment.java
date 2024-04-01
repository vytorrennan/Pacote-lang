package org.vytor.lang.interpreter;

import org.vytor.lang.runtimeValues.RuntimeValue;

import java.util.HashMap;

public class Environment {

    private final Environment parent;
    private final HashMap<String, RuntimeValue> variables;

    public Environment(Environment parent) {
        this.parent = parent;
        this.variables = new HashMap<String, RuntimeValue>();
    }

    public Environment() {
        this.parent = null;
        this.variables = new HashMap<String, RuntimeValue>();
    }

    public RuntimeValue declareVariable(String variableName, RuntimeValue value) {
        if (this.variables.containsKey(variableName)) {
            throw new RuntimeException("Variable already exists.");
        }

        this.variables.put(variableName, value);
        return value;
    }

    public Environment findVariableEnvironment(String variableName) {
        if (this.variables.containsKey(variableName)) {
            return this;
        }
        if (this.parent == null) {
            return null;
        }
        return this.parent.findVariableEnvironment(variableName);
    }

    public RuntimeValue assignVariable(String variableName, RuntimeValue value) {
        Environment env = findVariableEnvironment(variableName);
        if (env == null) {
            declareVariable(variableName, value);
        } else {
            env.variables.put(variableName, value);
        }
        return value;
    }

    public RuntimeValue getValueOfVariable(String variableName) {
        Environment env = findVariableEnvironment(variableName);
        if (env == null) {
            throw new RuntimeException("Variable does not exist.");
        }
        return env.variables.get(variableName);
    }
}
