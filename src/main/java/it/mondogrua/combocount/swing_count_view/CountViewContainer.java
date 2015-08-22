package it.mondogrua.combocount.swing_count_view;

import it.mondogrua.combocount.count.Count;
import it.mondogrua.utils.PluggableAdaptor;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CountViewContainer extends JPanel {
    private static final long serialVersionUID = 9192784649759977233L;

    public void openOn(final Count count) {
        buildViewsOn(count);
    }

    // Private Methods --------------------------------------------------------

    private void buildViewsOn(final Count count) {
        addDisplayBoxOn(count);
        addIncrementButtonOn(count);
        addDecrementButtonOn(count);
        addResetButtonOn(count);
    }

    private void addDisplayBoxOn(final Count count) {
        DisplayBox displayBox = makeDisplayBoxOn(count, "getValue");
        GridBagConstraints constraintFrame = makeConstraintFrame(1, 1);
        add(displayBox, constraintFrame);
    }

    private void addResetButtonOn(final Count count) {
        JButton button = makeButtonOn(count, "Reset", "reset");
        GridBagConstraints constraintFrame = makeConstraintFrame(2, 0);
        add(button, constraintFrame);
    }

    private void addDecrementButtonOn(final Count count) {
        JButton button = makeButtonOn(count, "Decrement", "decrement");
        GridBagConstraints constraintFrame = makeConstraintFrame(1, 0);
        add(button, constraintFrame);
    }

    private void addIncrementButtonOn(final Count count) {
        JButton button = makeButtonOn(count, "Increment", "increment");
        GridBagConstraints constraintFrame = makeConstraintFrame(0, 0);
        add(button, constraintFrame);
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
        return new DisplayBox(count.asJavaUtilObservable(), action);
    }

    private GridBagConstraints makeConstraintFrame(int x, int y) {
        GridBagConstraints constraintFrame = new GridBagConstraints();
        constraintFrame.insets = new Insets(5, 5, 5, 5);
        constraintFrame.gridx = x;
        constraintFrame.gridy = y;
        return constraintFrame;
    }
}
