package it.mondogrua.combocount.count;


public class IntegerCount extends Count {

    public IntegerCount() {
        super();
    }

    @Override
    protected void initialize() {
        setResetValue(0);
        super.initialize();
    };

    @Override
    public void increment() {
        setValue((Integer)getValue() + 1);
    }

    @Override
    public void decrement() {
        setValue((Integer)getValue() - 1);
    }

}
