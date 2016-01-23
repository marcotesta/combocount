package it.mondogrua.combocount.count;

import java.util.Observable;

public class JavaUtilsObservable extends Observable {
	
	private Count count;

	public JavaUtilsObservable(Count count) {
		this.count = count;
	}
	
	
    public void changed(String attribute) {
        setChanged();
        notifyObservers(attribute);
        clearChanged();
    }
    
    public Object getValue() {
        return count.getValue();
    }

}
