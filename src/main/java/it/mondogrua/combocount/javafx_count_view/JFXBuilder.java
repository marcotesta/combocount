package it.mondogrua.combocount.javafx_count_view;

import it.mondogrua.combocount.Builder;
import it.mondogrua.utils.PluggableAdaptor;
import it.mondogrua.valuemodel.ValueModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class JFXBuilder implements Builder {

	private GridPane pane;

	@Override
	public void addPane() {
		makePane();
	}

	@Override    	
    public void addDisplayBoxOn(final ValueModel valueModel, int x, int y) {
    	add(makeDisplayBoxOn(valueModel), x, y);
    }

	@Override
    public void addResetButtonOn(final ValueModel valueModel, int x, int y) {
        add(makeButtonOn(valueModel, "Reset", "reset"), x, y);
    }

	@Override
	public void addDecrementButtonOn(final ValueModel valueModel, int x, int y) {
        add(makeButtonOn(valueModel, "Decrement", "decrement"), x, y);
    }

	@Override
	public void addIncrementButtonOn(final ValueModel valueModel, int x, int y) {
        add(makeButtonOn(valueModel, "Increment", "increment"), x, y);
    }

	@Override
	public Scene getScene(int x, int y) {

        return new Scene(pane, x, y);
	}

	protected void makePane() {
		pane = new GridPane();
    	pane.setAlignment(Pos.CENTER);
    	pane.setHgap(10);
    	pane.setVgap(10);
    	pane.setPadding(new Insets(25, 25, 25, 25));
	}

	protected Button makeButtonOn(final ValueModel valueModel, String label, String action) {
        return new Button(label, new PluggableAdaptor(valueModel , action, new Object[]{}));
    }

    protected Label makeDisplayBoxOn(final ValueModel valueModel) {
        return new JFXDisplayBox(valueModel);
    }

	private void add(Node node, int x, int y) {
    	pane.add(node, x, y);
    }

}
