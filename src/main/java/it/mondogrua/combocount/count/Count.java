package it.mondogrua.combocount.count;

import it.mondogrua.utils.ComboObservable;


public abstract class Count extends ComboObservable {

    private Object _value;
    private Object _resetValue;

    public Count() {
        initialize();
    }

    protected void initialize() {
        reset();
    }

    @Override
    public Object getValue() {
        return _value;
    }

    public void setValue(Object aValue) {
        _value = aValue;
        changed("getValue");
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
