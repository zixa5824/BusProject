package bus;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
        Admin admin = new Admin();
        scene = new Scene(mainPane, 788, 529);

        Rectangle sideRect = new Rectangle(0, 0, 163, 529);
        sideRect.setFill(Color.BLACK);

        Button logoutButton = new Button("Logout");
        logoutButton.setLayoutX(39);
        logoutButton.setLayoutY(14);
        logoutButton.setPrefWidth(85);
        logoutButton.setPrefHeight(46);

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

        fillTables(account, vehiclesTable, driversTable);
        infoPane.getChildren().addAll(welcomeLabel, nameLabel, vehiclesTable, driversTable);
        // -------------------------------------------------------------------------------------------------------------

        // Contents of create trip pane --------------------------------------------------------------------------------
        Pane createTripPane = new Pane();
        createTripPane.setLayoutX(163);
        createTripPane.setLayoutY(0);
        createTripPane.setPrefWidth(625);
        createTripPane.setPrefHeight(529);
        createTripPane.setVisible(false);

        Label headLabel = new Label("Creating Trip");
        headLabel.setFont(font);
        headLabel.setPrefWidth(107);
        headLabel.setPrefHeight(46);
        headLabel.setLayoutX(259);
        headLabel.setLayoutY(49);

        Label sourceLabel = new Label("Source:");
        sourceLabel.setFont(font);
        sourceLabel.setPrefWidth(65);
        sourceLabel.setPrefHeight(46);
        sourceLabel.setLayoutX(14);
        sourceLabel.setLayoutY(130);

        Label timeLabel = new Label("Depart Time:");
        timeLabel.setFont(font);
        timeLabel.setPrefWidth(107);
        timeLabel.setPrefHeight(46);
        timeLabel.setLayoutX(14);
        timeLabel.setLayoutY(216);

        Label stopsLabel = new Label("Number of Stops:");
        stopsLabel.setFont(font);
        stopsLabel.setPrefWidth(139);
        stopsLabel.setPrefHeight(46);
        stopsLabel.setLayoutX(14);
        stopsLabel.setLayoutY(308);

        Label costLabel = new Label("Cost:");
        costLabel.setFont(font);
        costLabel.setPrefWidth(107);
        costLabel.setPrefHeight(46);
        costLabel.setLayoutX(14);
        costLabel.setLayoutY(396);

        Label destinationLabel = new Label("Destination:");
        destinationLabel.setFont(font);
        destinationLabel.setPrefWidth(107);
        destinationLabel.setPrefHeight(46);
        destinationLabel.setLayoutX(332);
        destinationLabel.setLayoutY(130);

        Label dateLabel = new Label("Date:");
        dateLabel.setFont(font);
        dateLabel.setPrefWidth(107);
        dateLabel.setPrefHeight(46);
        dateLabel.setLayoutX(332);
        dateLabel.setLayoutY(216);

        Label vehicleLabel = new Label("Vehicle:");
        vehicleLabel.setFont(font);
        vehicleLabel.setPrefWidth(107);
        vehicleLabel.setPrefHeight(46);
        vehicleLabel.setLayoutX(332);
        vehicleLabel.setLayoutY(308);

        Label driverLabel = new Label("Driver:");
        driverLabel.setFont(font);
        driverLabel.setPrefWidth(107);
        driverLabel.setPrefHeight(46);
        driverLabel.setLayoutX(332);
        driverLabel.setLayoutY(396);

        TextField sourceField = new TextField();
        sourceField.setLayoutX(155);
        sourceField.setLayoutY(141);

        TextField timeField = new TextField();
        timeField.setLayoutX(155);
        timeField.setLayoutY(227);

        TextField stopsField = new TextField();
        stopsField.setLayoutX(155);
        stopsField.setLayoutY(319);

        TextField costField = new TextField();
        costField.setLayoutX(155);
        costField.setLayoutY(407);

        TextField destinationField = new TextField();
        destinationField.setLayoutX(431);
        destinationField.setLayoutY(141);

        DatePicker datePicker = new DatePicker();
        datePicker.setLayoutX(431);
        datePicker.setLayoutY(227);
        datePicker.setPrefWidth(149);
        datePicker.setPrefHeight(25);

        ComboBox vehicleBox = new ComboBox();
        vehicleBox.setLayoutX(431);
        vehicleBox.setLayoutY(317);
        vehicleBox.setPrefWidth(149);
        vehicleBox.setPrefHeight(25);

        ComboBox driverBox = new ComboBox();
        driverBox.setLayoutX(431);
        driverBox.setLayoutY(407);
        driverBox.setPrefWidth(149);
        driverBox.setPrefHeight(25);

        Button saveButton = new Button("Save Trip");
        saveButton.setLayoutX(431);
        saveButton.setLayoutY(464);
        saveButton.setPrefWidth(107);
        saveButton.setPrefHeight(38);

        createTripPane.getChildren().addAll(
                headLabel, sourceLabel, timeLabel, stopsLabel, costLabel, destinationLabel, dateLabel, driverLabel,
                sourceField, timeField, stopsField, costField, destinationField, datePicker, driverBox, saveButton,
                vehicleBox, vehicleLabel
        );

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

        mainPane.getChildren().addAll(infoPane, viewTripsPane, createTripPane, sideRect, logoutButton, infoButton, createTripButton, viewTripsButton);
        // End of drawing scene ----------------------------------------------------------------------------------------

        // Events Section ----------------------------------------------------------------------------------------------
        logoutButton.setOnAction(event -> {
            stage.setScene(homeScene);
        });
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
        saveButton.setOnAction(event -> {
            sourceField.clear();
            timeField.clear();
            stopsField.clear();
            costField.clear();
            destinationField.clear();

        });
        // End of events -----------------------------------------------------------------------------------------------
    }

    public Scene getScene() {
        return scene;
    }

    public void fillTables(Account account, TableView vehiclesTable, TableView driversTable) {
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
