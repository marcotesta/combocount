package it.mondogrua.combocount.javafx_count_view;


import it.mondogrua.utils.ComboObservable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;

public class JFXDisplayBox extends Label  {

    private final SimpleStringProperty observer;

    public JFXDisplayBox(ComboObservable count) {
        this.observer = new SimpleStringProperty();
        textProperty().bind(Bindings.convert(observer));
        count.addObserver(observer);
    }

}
