package it.mondogrua.combocount.javafx_count_view;


import it.mondogrua.utils.ComboObservable;
import it.mondogrua.utils.PropertyObserver;
import javafx.beans.binding.Bindings;
import javafx.scene.control.Label;

public class DisplayBox extends Label  {

    private final PropertyObserver observer;

    public DisplayBox(ComboObservable count) {
        this.observer = new PropertyObserver();
        textProperty().bind(Bindings.convert(observer));
        count.addObserver(observer);
    }

}
