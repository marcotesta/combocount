package it.mondogrua.combocount.count;

public abstract class Count {

    private Object _value;
    private Object _resetValue;

    public Count() {
        initialize();
    }

    protected void initialize() {
        reset();
    }

    public Object getValue() {
        return _value;
    }

    public void setValue(Object aValue) {
        _value = aValue;
    }

    public Object getResetValue() {
        return _resetValue;
    }

    public void setResetValue(Object aResetValue) {
        _resetValue = aResetValue;
    }

    public void reset() {
        setValue(_resetValue);
    }

    abstract public void increment();

    abstract public void decrement();
}
