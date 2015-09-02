package it.mondogrua.combocount.javafx_count_view;

import it.mondogrua.utils.ComboObservable;
import javafx.scene.control.Label;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class DisplayBoxChangeListener extends Label implements ChangeListener {

    public DisplayBoxChangeListener(ComboObservable count) {
    	
        count.addObserver(this);
    }

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
    	
    	setText(newValue.toString());
    }

}
