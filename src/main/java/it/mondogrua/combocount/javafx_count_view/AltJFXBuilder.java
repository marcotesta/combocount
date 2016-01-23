package it.mondogrua.combocount.javafx_count_view;

import it.mondogrua.valuemodel.ValueModel;
import javafx.scene.control.Label;

public class AltJFXBuilder extends JFXBuilder {

    @Override
    protected Label makeDisplayBoxOn(final ValueModel valueModel) {
        return new AltDisplayBox(valueModel);
    }

}

