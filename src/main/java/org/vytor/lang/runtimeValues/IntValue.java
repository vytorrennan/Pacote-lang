package org.vytor.lang.runtimeValues;

public class IntValue extends RuntimeValue implements Number{

    public IntValue(Integer value) {
        super(ValueType.Int, value);
    }

    public java.lang.Number getNumber() {
        return (java.lang.Number) this.value;
    }
}
