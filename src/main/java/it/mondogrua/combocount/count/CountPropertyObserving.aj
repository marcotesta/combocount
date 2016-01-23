package it.mondogrua.combocount.count;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;

public aspect CountPropertyObserving {
	
	private SimpleStringProperty Count.propertyObservable = new SimpleStringProperty();

    public void Count.addObserver(SimpleStringProperty propertyObserver) {
    	propertyObservable.bind(propertyObserver);
    }
    
    public void Count.addObserver(ChangeListener<? super String> changeListener) {
    	propertyObservable.addListener(changeListener);
	}

	public SimpleStringProperty Count.asSimpleStringProperty() {
		return propertyObservable;
	}

    pointcut changes(Count p): target(p) && call(void Count.setValue(Object));

    after(Count p): changes(p) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
            	p.propertyObservable.set(p.getValue().toString());
            }
       });
    }

}
