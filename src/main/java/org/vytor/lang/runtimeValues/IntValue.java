package org.vytor.lang.runtimeValues;

public class IntValue extends RuntimeValue{

    public Integer value;

    public IntValue(Integer value) {
        super(ValueType.Int);
        this.value = value;
    }
}
