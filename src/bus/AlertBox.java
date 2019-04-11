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
    private static boolean check = false;
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
    public static Trips reserveDisplay(String title, String message, Trips selectedTrip) {
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
        Button oneWayTripButton = new Button("OneWay Trip");
        oneWayTripButton.setLayoutX(280);
        oneWayTripButton.setLayoutY(224);
        Button roundTripButton = new Button("Round Trip");
        roundTripButton.setLayoutX(400);
        roundTripButton.setLayoutY(224);
        oneWayTripButton.setOnAction(e->{
            check = true;
            errorAlert.close();
        });
        roundTripButton.setOnAction(e-> {
            String currency = selectedTrip.getPrice().substring(0,3);
            String price = selectedTrip.getPrice().substring(3);
            System.out.println(currency+price);
            selectedTrip.setPrice(currency+Integer.toString((int) (Integer.parseInt(price)*0.7)));
            check = true;
            errorAlert.close();
        });
        Pane layout = new Pane();
        layout.getChildren().addAll(error, oneWayTripButton,roundTripButton);
        Scene scene = new Scene(layout);
        layout.setPrefSize(516,269);
        errorAlert.setScene(scene);
        errorAlert.showAndWait();
        return  selectedTrip;
    }

    public static boolean isCheck() {
        return check;
    }
}
