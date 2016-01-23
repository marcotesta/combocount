package it.mondogrua.combocount.swing_count_view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import it.mondogrua.combocount.Builder;
import it.mondogrua.combocount.count.Count;
import it.mondogrua.utils.PluggableAdaptor;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class SwingBuilder implements Builder {

    private JPanel panel;
    
    @Override
	public void addPane() {
		panel = new JPanel();
    	panel.setLayout(new GridBagLayout());
	}
    
    @Override
    public void addDisplayBoxOn(final Count count, int x, int y) {
        add(makeDisplayBoxOn(count, "getValue"), x, y);
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

        final SwingNode swingNode = new SwingNode();
        swingNode.setContent(panel);

        StackPane pane = new StackPane();
        pane.getChildren().add(swingNode);

        return new Scene(pane, x, y);
	}

    private JButton makeButtonOn(final Count count, String label, String action) {
        JButton button = new JButton(label);
        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent event) {
                new PluggableAdaptor(count , action, new Object[]{}).execute();
            }
        });

        return button;
    }

    private DisplayBox makeDisplayBoxOn(final Count count, String action) {
        return new DisplayBox(count, action);
    }

    private GridBagConstraints makeConstraintFrame(int x, int y) {
        GridBagConstraints constraintFrame = new GridBagConstraints();
        constraintFrame.insets = new Insets(5, 5, 5, 5);
        constraintFrame.gridx = x;
        constraintFrame.gridy = y;
        return constraintFrame;
    }
    
	private void add(JComponent node, int x, int y) {
		panel.add(node, makeConstraintFrame(x, y));
    }

}
