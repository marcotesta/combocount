package it.mondogrua.combocount.javafx_count_view;

import it.mondogrua.combocount.count.Count;
import it.mondogrua.utils.PluggableAdaptor;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class JFXCountViewContainer extends GridPane {

    public JFXCountViewContainer() {
        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25, 25, 25, 25));
    }

    public void openOn(final Count count, Builder builder) {
        buildViewsOn(count, builder);
    }
    

	private void buildViewsOn(final Count count, Builder builder) {
        addDisplayBoxOn(count,builder);
        addIncrementButtonOn(count, builder);
        addDecrementButtonOn(count, builder);
        addResetButtonOn(count, builder);
    }


    private void addDisplayBoxOn(final Count count, Builder builder) {
    	Label displayBox = builder.makeDisplayBoxOn(count);
        ConstraintFrame constraintFrame = new ConstraintFrame(1, 1);
        add(displayBox, constraintFrame);
    }

    private void addResetButtonOn(final Count count, Builder builder) {
        Button buttonReset = builder.makeButtonOn(count, "Reset", "reset");
        ConstraintFrame constraintFrame = new ConstraintFrame(2, 2);
        add(buttonReset, constraintFrame);
    }

    private void addDecrementButtonOn(final Count count, Builder builder) {
        Button buttonDecrement = builder.makeButtonOn(count, "Decrement", "decrement");
        ConstraintFrame constraintFrame = new ConstraintFrame(1, 2);
        add(buttonDecrement, constraintFrame);
    }

    private void addIncrementButtonOn(final Count count, Builder builder) {
        Button buttonIncrement = builder.makeButtonOn(count, "Increment", "increment");
        ConstraintFrame constraintFrame = new ConstraintFrame(0, 2);
        add(buttonIncrement, constraintFrame);
    }



    private void add(Node node, ConstraintFrame constraintFrame) {
        add(node, constraintFrame.getX(), constraintFrame.getY());
    }
    
    public interface Builder {
        public Button makeButtonOn(final Count count, String label, String action); 
        public Label makeDisplayBoxOn(final Count count) ;
    }
    
    static public class JFXBuilder implements Builder {
    	
        public Button makeButtonOn(final Count count, String label, String action) {
            return new Button(label, new PluggableAdaptor(count , action, new Object[]{}));
        }

        public Label makeDisplayBoxOn(final Count count) {
            return new JFXDisplayBox(count);
        }
    }

    static public class AltJFXBuilder implements Builder {
    	
        public Button makeButtonOn(final Count count, String label, String action) {
            return new Button(label, new PluggableAdaptor(count , action, new Object[]{}));
        }

        public Label makeDisplayBoxOn(final Count count) {
            return new AltDisplayBox(count);
        }
    }
}
