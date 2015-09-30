package it.mondogrua.combocount;

import it.mondogrua.combocount.count.Count;
import it.mondogrua.combocount.count.DateCount;
import it.mondogrua.combocount.javafx_count_view.JFXCountViewContainer;
import it.mondogrua.combocount.swing_count_view.CountViewContainer;
import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.SwingUtilities;


public class CountApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Count count = new DateCount();

        createJavaFXCountViewContainer(primaryStage, count);
        createAltJavaFXCountViewContainer(new Stage(), count);
        createSwingCountViewContainer(new Stage(), count);
    }

    private void createJavaFXCountViewContainer(Stage stage, Count count) {
        JFXCountViewContainer countViewContainer = new JFXCountViewContainer();
        countViewContainer.openOn(count, "JavaFX DateCount Example", stage);
        stage.show();
    }

    private void createAltJavaFXCountViewContainer(Stage stage, Count count) {
        JFXCountViewContainer countViewContainer = new JFXCountViewContainer();
        countViewContainer.altOpenOn(count, "Alternative JavaFX DateCount Example", stage);
        stage.show();
    }

    private void createSwingCountViewContainer(Stage stage, Count count) {
        final SwingNode swingNode = new SwingNode();
        createSwingContent(swingNode, count);

        StackPane pane = new StackPane();
        pane.getChildren().add(swingNode);

        stage.setScene(new Scene(pane, 350, 150));
        stage.setTitle("SWING DateCount Example");

        stage.show();
    }

    private void createSwingContent(final SwingNode swingNode, Count count) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CountViewContainer countViewContainer = new CountViewContainer();
                countViewContainer.openOn(count);

                swingNode.setContent(countViewContainer);
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }

}
