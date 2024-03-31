package org.vytor.lang.runtimeValues;

public class NullValue extends RuntimeValue {

    public String value = "null";

    public NullValue() {
        super(ValueType.NULL);
    }
}
