package it.mondogrua.combocount.javafx_count_view;

import it.mondogrua.combocount.count.Count;
import it.mondogrua.utils.PluggableAdaptor;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class JFXCountViewContainer extends GridPane {

    public JFXCountViewContainer() {
        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25, 25, 25, 25));
    }

    public void openOn(final Count count, String title, Stage stage) {
        buildViewsOn(count);
        Scene scene = new Scene(this, 300, 150);
        stage.setScene(scene);
        stage.setTitle(title);
    }
    
    public void altOpenOn(final Count count, String title, Stage stage) {
    	altBuildViewsOn(count);
        Scene scene = new Scene(this, 300, 150);
        stage.setScene(scene);
        stage.setTitle(title);
    }
    
    private void buildViewsOn(final Count count) {
        addDisplayBoxOn(count);
        addIncrementButtonOn(count);
        addDecrementButtonOn(count);
        addResetButtonOn(count);
    }

    private void altBuildViewsOn(final Count count) {
    	addDisplayBoxChangeListenerOn(count);
        addIncrementButtonOn(count);
        addDecrementButtonOn(count);
        addResetButtonOn(count);
    }

    private void addDisplayBoxOn(final Count count) {
    	JFXDisplayBox displayBox = makeDisplayBoxOn(count);
        ConstraintFrame constraintFrame = new ConstraintFrame(1, 1);
        add(displayBox, constraintFrame);
    }

    private void addDisplayBoxChangeListenerOn(final Count count) {
    	DisplayBoxChangeListener displayBox = makeDisplayBoxChangeListenerOn(count);
        ConstraintFrame constraintFrame = new ConstraintFrame(1, 1);
        add(displayBox, constraintFrame);
    }

    private void addResetButtonOn(final Count count) {
        Button buttonReset = makeButtonOn(count, "Reset", "reset");
        ConstraintFrame constraintFrame = new ConstraintFrame(2, 2);
        add(buttonReset, constraintFrame);
    }

    private void addDecrementButtonOn(final Count count) {
        Button buttonDecrement = makeButtonOn(count, "Decrement", "decrement");
        ConstraintFrame constraintFrame = new ConstraintFrame(1, 2);
        add(buttonDecrement, constraintFrame);
    }

    private void addIncrementButtonOn(final Count count) {
        Button buttonIncrement = makeButtonOn(count, "Increment", "increment");
        ConstraintFrame constraintFrame = new ConstraintFrame(0, 2);
        add(buttonIncrement, constraintFrame);
    }

    private Button makeButtonOn(final Count count, String label, String action) {
        return new Button(label, new PluggableAdaptor(count , action, new Object[]{}));
    }

    private JFXDisplayBox makeDisplayBoxOn(final Count count) {
        return new JFXDisplayBox(count);
    }

    private DisplayBoxChangeListener makeDisplayBoxChangeListenerOn(final Count count) {
        return new DisplayBoxChangeListener(count);
    }

    private void add(Node node, ConstraintFrame constraintFrame) {
        add(node, constraintFrame.getX(), constraintFrame.getY());
    }

}
