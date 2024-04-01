package org.vytor.lang.runtimeValues;

public class FloatValue extends RuntimeValue implements Number{

    public FloatValue(Float value) {
        super(ValueType.Float, value);
    }

    public java.lang.Number getNumber() {
        return (java.lang.Number) this.value;
    }
}
