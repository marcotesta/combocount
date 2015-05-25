package it.mondogrua.combocount;

import it.mondogrua.combocount.count.Count;
import it.mondogrua.combocount.count.IntegerCount;
import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.SwingUtilities;


public class CountApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Count count = new IntegerCount();

        it.mondogrua.combocount.javafx_count_view.CountViewContainer countViewContainer =
                new it.mondogrua.combocount.javafx_count_view.CountViewContainer();
        countViewContainer.openOn(count, "DateCount Example", primaryStage);

        final SwingNode swingNode = new SwingNode();
        createSwingContent(swingNode, count);

        StackPane pane = new StackPane();
        pane.getChildren().add(swingNode);

        Stage stage = new Stage();
        stage.setScene(new Scene(pane, 350, 150));
        stage.setTitle("DateCount Example");

        stage.show();

        primaryStage.show();
    }

    private void createSwingContent(final SwingNode swingNode, Count count) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                it.mondogrua.combocount.swing_count_view.CountViewContainer countViewContainer =
                        new it.mondogrua.combocount.swing_count_view.CountViewContainer();
                countViewContainer.openOn(count);

                swingNode.setContent(countViewContainer);
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }

}
