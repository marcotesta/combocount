package it.mondogrua.combocount.javafx_count_view;

import it.mondogrua.utils.ComboObservable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;

public class AltDisplayBox extends Label {
	
    private final ChangeListener<? super String> observer;

    public AltDisplayBox(ComboObservable count) {
    	observer = new ChangeListener<Object>() {
    		@Override
    		public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
    			
    			setText(newValue.toString());
    		}
    	};

    	count.addObserver(observer);
    }


}
