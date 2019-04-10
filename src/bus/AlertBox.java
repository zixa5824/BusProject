/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

/**
 *
 * @author Mahmoud
 */
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {

    public static void display(String title, String message) {
        Stage errorAlert = new Stage();

        
        errorAlert.initModality(Modality.APPLICATION_MODAL);
        errorAlert.setTitle(title);
        errorAlert.setMinWidth(500);

        Label error = new Label();
        error.setText(message);
        Button closeButton = new Button("CLOSE");
        closeButton.setOnAction(e -> errorAlert.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(error, closeButton);
        layout.setAlignment(Pos.CENTER);

        
        Scene scene = new Scene(layout);
        errorAlert.setScene(scene);
        errorAlert.showAndWait();
    }

    public static void saveDisplay(String title, String message, Scene homeScene, Stage stage) {
        Stage errorAlert = new Stage();
        errorAlert.initModality(Modality.APPLICATION_MODAL);
        errorAlert.setTitle(title);
        errorAlert.setMinWidth(500);

        Label error = new Label();
        error.setPrefWidth(331);
        error.setPrefHeight(65);
        error.setLayoutX(93);
        error.setLayoutY(79);
        error.setText(message);
        Button yesButton = new Button("YES");
        yesButton.setLayoutX(403);
        yesButton.setLayoutY(224);
        Button noButton = new Button("NO");
        noButton.setLayoutX(461);
        noButton.setLayoutY(224);
        yesButton.setOnAction(e -> {errorAlert.close(); stage.setScene(homeScene);});
        noButton.setOnAction(e-> errorAlert.close());
        Pane layout = new Pane();
        layout.getChildren().addAll(error, yesButton,noButton);
        Scene scene = new Scene(layout);
        layout.setPrefSize(516,269);
        errorAlert.setScene(scene);
        errorAlert.showAndWait();
    }

}
