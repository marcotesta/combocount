package it.mondogrua.combocount.javafx_count_view;

import it.mondogrua.combocount.Builder;
import it.mondogrua.combocount.count.Count;
import it.mondogrua.utils.PluggableAdaptor;
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
    public void addDisplayBoxOn(final Count count, int x, int y) {
    	add(makeDisplayBoxOn(count), x, y);
    }

	@Override
    public void addResetButtonOn(final Count count, int x, int y) {
        add(makeButtonOn(count, "Reset", "reset"), x, y);
    }

	@Override
	public void addDecrementButtonOn(final Count count, int x, int y) {
        add(makeButtonOn(count, "Decrement", "decrement"), x, y);
    }

	@Override
	public void addIncrementButtonOn(final Count count, int x, int y) {
        add(makeButtonOn(count, "Increment", "increment"), x, y);
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

	protected Button makeButtonOn(final Count count, String label, String action) {
        return new Button(label, new PluggableAdaptor(count , action, new Object[]{}));
    }

    protected Label makeDisplayBoxOn(final Count count) {
        return new JFXDisplayBox(count.asSimpleStringProperty());
    }

	private void add(Node node, int x, int y) {
    	pane.add(node, x, y);
    }

}
