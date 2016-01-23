package it.mondogrua.combocount.count;

import java.util.Observer;


public aspect CountJavaUtilObserving {
	
	private JavaUtilsObservable Count.javaUtilObservable = new JavaUtilsObservable(this);

    public void Count.addObserver(Observer observer) {
    	javaUtilObservable.addObserver(observer);
    }
    
    public java.util.Observable Count.asJavaUtilObservable() {
        return javaUtilObservable;
    }

    pointcut changes(Count p): target(p) && call(void Count.setValue(Object));

    after(Count p): changes(p) {
    	p.javaUtilObservable.changed("getValue");
    }
}
