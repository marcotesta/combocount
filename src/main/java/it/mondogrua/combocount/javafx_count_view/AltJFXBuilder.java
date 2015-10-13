package it.mondogrua.combocount.javafx_count_view;

import it.mondogrua.combocount.count.Count;
import javafx.scene.control.Label;

public class AltJFXBuilder extends JFXBuilder {

    @Override
    protected Label makeDisplayBoxOn(final Count count) {
        return new AltDisplayBox(count);
    }

}

