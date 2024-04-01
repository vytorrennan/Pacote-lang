package org.vytor.lang.runtimeValues;

public class FloatValue extends RuntimeValue implements Number{

    public Float value;

    public FloatValue(Float value) {
        super(ValueType.Float);
        this.value = value;
    }

    public java.lang.Number getNumber() {
        return this.value;
    }
}
