package it.mondogrua.combocount.javafx_count_view;


import it.mondogrua.valuemodel.ValueModel;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;

public class JFXDisplayBox extends Label  {

    private final SimpleStringProperty observer;

    public JFXDisplayBox(ValueModel valueModel) {
        this.observer = new SimpleStringProperty();
        textProperty().bind(Bindings.convert(observer));
        observer.bind(valueModel.asSimpleStringProperty());
    }
}
