package org.vytor.lang.runtimeValues;

public class IntValue extends RuntimeValue implements Number{

    public Integer value;

    public IntValue(Integer value) {
        super(ValueType.Int);
        this.value = value;
    }

    public java.lang.Number getNumber() {
        return this.value;
    }
}
