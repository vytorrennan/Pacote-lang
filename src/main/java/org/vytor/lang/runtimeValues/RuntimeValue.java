package org.vytor.lang.runtimeValues;

public abstract class RuntimeValue {
    public ValueType valueType;

    public RuntimeValue(ValueType valueType) {
        this.valueType = valueType;
    }
}
