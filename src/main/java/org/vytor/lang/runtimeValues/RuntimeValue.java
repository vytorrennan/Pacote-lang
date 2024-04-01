package org.vytor.lang.runtimeValues;

public abstract class RuntimeValue {
    public ValueType valueType;
    public Object value;

    public RuntimeValue(ValueType valueType, Object value) {
        this.valueType = valueType;
        this.value = value;
    }
}
