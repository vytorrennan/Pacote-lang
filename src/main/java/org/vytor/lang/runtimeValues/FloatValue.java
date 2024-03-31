package org.vytor.lang.runtimeValues;

public class FloatValue extends RuntimeValue{

    public Float value;

    public FloatValue(Float value) {
        super(ValueType.Float);
        this.value = value;
    }
}
