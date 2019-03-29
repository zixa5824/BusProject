package bus;

import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ManagerScene {

    private Scene scene;
    private Scene homeScene;


    ManagerScene(Stage stage, Account account) {
        // Drawing the Scene -------------------------------------------------------------------------------------------
        Pane mainPane = new Pane();
        scene = new Scene(mainPane, 788, 529);

        Rectangle sideRect = new Rectangle(0, 0, 163, 529);
        sideRect.setFill(Color.BLACK);

        Font font = new Font(16);

        // Contents of info pane ---------------------------------------------------------------------------------------
        Pane infoPane = new Pane();
        infoPane.setLayoutX(163);
        infoPane.setLayoutY(0);
        infoPane.setPrefWidth(625);
        infoPane.setPrefHeight(529);

        Label welcomeLabel = new Label("Welcome Manager");
        welcomeLabel.setAlignment(Pos.CENTER);
        welcomeLabel.setFont(font);
        welcomeLabel.setLayoutX(234);
        welcomeLabel.setLayoutY(56);
        welcomeLabel.setPrefWidth(157);
        welcomeLabel.setPrefHeight(38);

        Label nameLabel = new Label();
        nameLabel.setText(account.getFirstName() + " " + account.getLastName());
        nameLabel.setAlignment(Pos.CENTER);
        nameLabel.setFont(font);
        nameLabel.setLayoutX(234);
        nameLabel.setLayoutY(112);
        nameLabel.setPrefWidth(157);
        nameLabel.setPrefHeight(38);

        // First Table

        TableColumn<String[], String> vehiclesColumn = new TableColumn("Vehicles");
        vehiclesColumn.setCellValueFactory(param -> {
            return new SimpleStringProperty(param.getValue()[0]);
        });

        TableColumn<String[], String> numberOfDriversColumn = new TableColumn("# of drivers");
        numberOfDriversColumn.setCellValueFactory(param -> {
            return new SimpleStringProperty(param.getValue()[1]);
        });

        TableView vehiclesTable = new TableView();
        vehiclesTable.setPrefWidth(150);
        vehiclesTable.setPrefHeight(200);
        vehiclesTable.setLayoutX(84);
        vehiclesTable.setLayoutY(207);
        vehiclesTable.setEditable(false);
        vehiclesTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        vehiclesTable.getColumns().addAll(vehiclesColumn, numberOfDriversColumn);


        // Second Table

        TableColumn<String[], String> driversColumn = new TableColumn("Drivers");
        driversColumn.setMinWidth(110);
        driversColumn.setCellValueFactory(param -> {
            return new SimpleStringProperty(param.getValue()[0]);
        });

        TableColumn<String[], String> vehicleColumn = new TableColumn("Vehicle");
        vehicleColumn.setMinWidth(20);
        vehicleColumn.setCellValueFactory(param -> {
            return new SimpleStringProperty(param.getValue()[1]);
        });

        TableView driversTable = new TableView();
        driversTable.setPrefWidth(226);
        driversTable.setPrefHeight(200);
        driversTable.setLayoutX(315);
        driversTable.setLayoutY(207);
        driversTable.setEditable(false);
        driversTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        driversTable.getColumns().addAll(driversColumn, vehicleColumn);

        fillTables(account,vehiclesTable,driversTable);
        infoPane.getChildren().addAll(welcomeLabel, nameLabel, vehiclesTable, driversTable);
        // -------------------------------------------------------------------------------------------------------------

        // Contents of create trip pane --------------------------------------------------------------------------------
        Pane createTripPane = new Pane();
        createTripPane.setLayoutX(163);
        createTripPane.setLayoutY(0);
        createTripPane.setPrefWidth(625);
        createTripPane.setPrefHeight(529);

        Label testLabel = new Label("TEST");
        testLabel.setAlignment(Pos.CENTER);
        testLabel.setFont(font);
        testLabel.setLayoutX(234);
        testLabel.setLayoutY(56);
        testLabel.setPrefWidth(157);
        testLabel.setPrefHeight(38);

        Button testBut = new Button("Test");
        createTripPane.getChildren().addAll(testBut,testLabel);
        createTripPane.setVisible(false);

        // -------------------------------------------------------------------------------------------------------------

        // Contents of view trips pane ---------------------------------------------------------------------------------
        Pane viewTripsPane = new Pane();
        viewTripsPane.setLayoutX(163);
        viewTripsPane.setLayoutY(0);
        viewTripsPane.setPrefWidth(625);
        viewTripsPane.setPrefHeight(529);
        viewTripsPane.setVisible(false);
        // -------------------------------------------------------------------------------------------------------------

        Button infoButton = new Button("General Info");
        infoButton.setLayoutX(0);
        infoButton.setLayoutY(95);
        infoButton.setPrefWidth(163);
        infoButton.setPrefHeight(46);
        infoButton.setBackground(new Background(new BackgroundFill(Color.PALEGOLDENROD, CornerRadii.EMPTY, Insets.EMPTY)));

        Button createTripButton = new Button("Create Trip");
        createTripButton.setLayoutX(0);
        createTripButton.setLayoutY(242);
        createTripButton.setPrefWidth(163);
        createTripButton.setPrefHeight(46);
        createTripButton.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));


        Button viewTripsButton = new Button("View All Trips");
        viewTripsButton.setLayoutX(0);
        viewTripsButton.setLayoutY(400);
        viewTripsButton.setPrefWidth(163);
        viewTripsButton.setPrefHeight(46);
        viewTripsButton.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        mainPane.getChildren().addAll(infoPane, viewTripsPane, createTripPane, sideRect, infoButton, createTripButton, viewTripsButton);
        // End of drawing scene ----------------------------------------------------------------------------------------

        // Events Section ----------------------------------------------------------------------------------------------
        infoButton.setOnAction(event -> {
            infoPane.setVisible(true);
            createTripPane.setVisible(false);
            viewTripsPane.setVisible(false);
            infoButton.setBackground(new Background(new BackgroundFill(Color.PALEGOLDENROD, CornerRadii.EMPTY, Insets.EMPTY)));
            createTripButton.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            viewTripsButton.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        });

        createTripButton.setOnAction(event -> {
            infoPane.setVisible(false);
            createTripPane.setVisible(true);
            viewTripsPane.setVisible(false);
            infoButton.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            createTripButton.setBackground(new Background(new BackgroundFill(Color.PALEGOLDENROD, CornerRadii.EMPTY, Insets.EMPTY)));
            viewTripsButton.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        });

        viewTripsButton.setOnAction(event -> {
            infoPane.setVisible(false);
            createTripPane.setVisible(false);
            viewTripsPane.setVisible(true);
            infoButton.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            createTripButton.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            viewTripsButton.setBackground(new Background(new BackgroundFill(Color.PALEGOLDENROD, CornerRadii.EMPTY, Insets.EMPTY)));
        });
        // End of events -----------------------------------------------------------------------------------------------
    }

    public Scene getScene() {
        return scene;
    }

    public void fillTables(Account account, TableView vehiclesTable, TableView driversTable){
        ArrayList<String> driverNumbersList = account.driversNumbers();
        ArrayList<String> driverList = account.driversList();
        int listIndex = 0;
        int listRows = driverNumbersList.size() / 2;
        int driverListRows = driverList.size() / 2;
        String[][] driversNumbersArray = new String[listRows][2];
        String[][] driversListArray = new String[driverListRows][2];

        for (int i = 0; i < listRows; i++) {
            for (int j = 0; j < 2; j++) {
                driversNumbersArray[i][j] = driverNumbersList.get(listIndex++);
            }
        }

        listIndex = 0;
        for (int i = 0; i < driverListRows; i++) {
            for (int j = 0; j < 2; j++) {
                driversListArray[i][j] = driverList.get(listIndex++);
            }
        }

        for (int i = 0; i < listRows; i++) {
            vehiclesTable.getItems().add(driversNumbersArray[i]);
        }

        for (int i = 0; i < driverListRows; i++) {
            driversTable.getItems().add(driversListArray[i]);
        }
    }

    public void setHomeScene(Scene homeScene) {
        this.homeScene = homeScene;
    }
}
