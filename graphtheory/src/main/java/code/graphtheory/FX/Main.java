package code.graphtheory.FX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            RootBorderPane root = new RootBorderPane();
            Scene scene = new Scene(root, 1050, 350);
            primaryStage.setTitle("GUI-Graphentool");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, e.getMessage());
        }
    }

    public static void showAlert(Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType, message, ButtonType.OK);
        alert.setTitle("Hinweis");
        alert.setHeaderText(null); // nice to have
        alert.showAndWait(); // ...andWait ... modality
    }
}
