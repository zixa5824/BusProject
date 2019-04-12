package bus;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.UUID;

public class ManagerScene {

    private Scene scene;
    private Scene homeScene;
    private Admin admin;


    ManagerScene(Stage stage, Account account) {
        // Drawing the Scene -------------------------------------------------------------------------------------------
        Pane mainPane = new Pane();
        admin = new Admin();
        scene = new Scene(mainPane, 788, 529);

        Rectangle sideRect = new Rectangle(0, 0, 120, 529);
        sideRect.setFill(Color.DARKCYAN);

        Button logoutButton = new Button("Logout");
        logoutButton.setLayoutX(18);
        logoutButton.setLayoutY(14);
        logoutButton.setPrefWidth(85);
        logoutButton.setPrefHeight(46);

        Font font = new Font(16);

        // Contents of info pane ---------------------------------------------------------------------------------------
        Pane infoPane = new Pane();
        infoPane.setLayoutX(119);
        infoPane.setLayoutY(0);
        infoPane.setPrefWidth(669);
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
        vehiclesTable.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
        vehiclesTable.getColumns().addAll(vehiclesColumn, numberOfDriversColumn);


        // Second Table

        TableColumn<Account, String> driverFirstNameColumn = new TableColumn("First Name");
        driverFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Account, String> driverLastNameColumn = new TableColumn("Last Name");
        driverLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Account, String> vehicleColumn = new TableColumn("Vehicle");
        vehicleColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableView driversTable = new TableView();
        driversTable.setPrefWidth(226);
        driversTable.setPrefHeight(200);
        driversTable.setLayoutX(315);
        driversTable.setLayoutY(207);
        driversTable.setEditable(false);
        driversTable.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
        driversTable.getColumns().addAll(driverFirstNameColumn, driverLastNameColumn, vehicleColumn);

        infoPane.getChildren().addAll(welcomeLabel, nameLabel, vehiclesTable, driversTable);
        // -------------------------------------------------------------------------------------------------------------

        // Contents of create trip pane --------------------------------------------------------------------------------
        Pane createTripPane = new Pane();
        createTripPane.setLayoutX(119);
        createTripPane.setLayoutY(0);
        createTripPane.setPrefWidth(669);
        createTripPane.setPrefHeight(529);
        createTripPane.setVisible(false);

        Label headLabel = new Label("Creating Trip");
        headLabel.setFont(font);
        headLabel.setPrefWidth(107);
        headLabel.setPrefHeight(46);
        headLabel.setLayoutX(279);
        headLabel.setLayoutY(49);

        Label sourceLabel = new Label("Source:");
        sourceLabel.setFont(font);
        sourceLabel.setPrefWidth(65);
        sourceLabel.setPrefHeight(46);
        sourceLabel.setLayoutX(14);
        sourceLabel.setLayoutY(130);

        // Prints which drivers are being listed
        Label stateLabel = new Label();
        stateLabel.setFont(font);
        stateLabel.setPrefWidth(200);
        stateLabel.setLayoutX(431);
        stateLabel.setLayoutY(380);

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

        Label typeLabel = new Label("Trip Type:");
        typeLabel.setFont(font);
        typeLabel.setPrefWidth(107);
        typeLabel.setPrefHeight(46);
        typeLabel.setLayoutX(14);
        typeLabel.setLayoutY(460);

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
        Label date = new Label();
        datePicker.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
            date.setText(newValue);
        });
        datePicker.setLayoutX(431);
        datePicker.setLayoutY(227);
        datePicker.setPrefWidth(149);
        datePicker.setPrefHeight(25);

        ComboBox vehicleBox = new ComboBox();
        for (Vehicle vehicle:admin.listVehicles()) {
            vehicleBox.getItems().add(vehicle.getType());
        }
        vehicleBox.setLayoutX(431);
        vehicleBox.setLayoutY(317);
        vehicleBox.setPrefWidth(149);
        vehicleBox.setPrefHeight(25);

        ComboBox typeBox = new ComboBox();
        typeBox.getItems().addAll("Internal", "External");
        typeBox.setLayoutX(155);
        typeBox.setLayoutY(471);
        typeBox.setPrefWidth(149);
        typeBox.setPrefHeight(25);

        ComboBox currencyBox = new ComboBox();
        currencyBox.setLayoutX(76);
        currencyBox.setLayoutY(407);
        currencyBox.setPrefWidth(77);
        currencyBox.setPrefHeight(25);
        currencyBox.getItems().addAll("EGP", "USD");


        ComboBox driverBox = new ComboBox();
        driverBox.setLayoutX(431);
        driverBox.setLayoutY(407);
        driverBox.setPrefWidth(149);
        driverBox.setPrefHeight(25);

        // ComboBox corresponding to driverBoxEdit storing in it the account ID of the drivers
        ComboBox driverIDBox = new ComboBox();

        Button saveButton = new Button("Save Trip");
        saveButton.setLayoutX(431);
        saveButton.setLayoutY(464);
        saveButton.setPrefWidth(107);
        saveButton.setPrefHeight(38);

        Button saveButtonEdit = new Button("Save Edited Trip");
        saveButtonEdit.setVisible(false);
        saveButtonEdit.setLayoutX(431);
        saveButtonEdit.setLayoutY(464);
        saveButtonEdit.setPrefWidth(107);
        saveButtonEdit.setPrefHeight(38);

        Button back = new Button("Back");
        back.setVisible(false);
        back.setLayoutX(20);
        back.setLayoutY(20);

        Label oldDateLabel = new Label("");
        oldDateLabel.setVisible(false);
        oldDateLabel.setLayoutX(datePicker.getLayoutX() + 170);
        oldDateLabel.setLayoutY(datePicker.getLayoutY());

        Label oldVehicleLabel = new Label("");
        oldVehicleLabel.setVisible(false);
        oldVehicleLabel.setLayoutX(vehicleBox.getLayoutX() + 170);
        oldVehicleLabel.setLayoutY(vehicleBox.getLayoutY());

        Label oldDriverLabel = new Label("");
        oldDriverLabel.setVisible(false);
        oldDriverLabel.setLayoutX(driverBox.getLayoutX() + 170);
        oldDriverLabel.setLayoutY(driverBox.getLayoutY());

        createTripPane.getChildren().addAll(
                headLabel, sourceLabel, timeLabel, stopsLabel, costLabel, destinationLabel, dateLabel, driverLabel,
                sourceField, timeField, stopsField, costField, destinationField, datePicker, driverBox, saveButton,
                vehicleBox, vehicleLabel, typeLabel, typeBox, stateLabel, currencyBox, saveButtonEdit,
                back, oldDateLabel, oldVehicleLabel, oldDriverLabel
        );

        // -------------------------------------------------------------------------------------------------------------

        // Contents of view trips pane ---------------------------------------------------------------------------------
        Pane viewTripsPane = new Pane();
        viewTripsPane.setLayoutX(119);
        viewTripsPane.setLayoutY(0);
        viewTripsPane.setPrefWidth(669);
        viewTripsPane.setPrefHeight(529);
        viewTripsPane.setVisible(false);

        Button editButton = new Button("Edit Trip");
        editButton.setLayoutX(197);
        editButton.setLayoutY(428);

        Button deleteButton = new Button("Delete Trip");
        deleteButton.setLayoutX(338);
        deleteButton.setLayoutY(428);
//tripID, driverAccountID, driverName, source, destination, departTime, dateEdit, numberOfStops, type, vehicle, price;
        TableColumn<Trips, String> driverNameColumn = new TableColumn("Driver");
        driverNameColumn.setCellValueFactory(new PropertyValueFactory<>("driverName"));

        TableColumn<Trips, String> sourceColumn = new TableColumn("Source");
        sourceColumn.setCellValueFactory(new PropertyValueFactory<>("source"));

        TableColumn<Trips, String> destinationColumn = new TableColumn("Destination");
        destinationColumn.setCellValueFactory(new PropertyValueFactory<>("destination"));

        TableColumn<Trips, String> timeColumn = new TableColumn("Time");
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("departTime"));

        TableColumn<Trips, String> dateColumn = new TableColumn("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Trips, String> stopsColumn = new TableColumn("Stops");
        stopsColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfStops"));

        TableColumn<Trips, String> typeColumn = new TableColumn("Type");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<Trips, String> vehicleTypeColumn = new TableColumn("Vehicle");
        vehicleTypeColumn.setCellValueFactory(new PropertyValueFactory<>("vehicle"));

        TableColumn<Trips, String> priceColumn = new TableColumn("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Trips, String> tripIDColumn = new TableColumn();
        tripIDColumn.setCellValueFactory(new PropertyValueFactory<>("tripID"));
        tripIDColumn.setVisible(false);

        TableView allTripsTable = new TableView();
        allTripsTable.setLayoutX(13);
        allTripsTable.setLayoutY(66);
        allTripsTable.setPrefWidth(639);
        allTripsTable.setPrefHeight(313);
        allTripsTable.getColumns().addAll(driverNameColumn, sourceColumn, destinationColumn, timeColumn, dateColumn,
                stopsColumn, typeColumn, vehicleTypeColumn, priceColumn, tripIDColumn);
        allTripsTable.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);

        viewTripsPane.getChildren().addAll(editButton, deleteButton, allTripsTable);

        // -------------------------------------------------------------------------------------------------------------

        // -------------------------------------------------------------------------------------------------------------
        Button infoButton = new Button("General Info");
        infoButton.setLayoutX(0);
        infoButton.setLayoutY(95);
        infoButton.setPrefWidth(120);
        infoButton.setPrefHeight(46);
        infoButton.setBackground(new Background(new BackgroundFill(Color.PALEGOLDENROD, CornerRadii.EMPTY, Insets.EMPTY)));

        Button createTripButton = new Button("Create Trip");
        createTripButton.setLayoutX(0);
        createTripButton.setLayoutY(242);
        createTripButton.setPrefWidth(120);
        createTripButton.setPrefHeight(46);
        createTripButton.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        Button viewTripsButton = new Button("View All Trips");
        viewTripsButton.setLayoutX(0);
        viewTripsButton.setLayoutY(400);
        viewTripsButton.setPrefWidth(120);
        viewTripsButton.setPrefHeight(46);
        viewTripsButton.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        fillTables(vehiclesTable, driversTable, allTripsTable);
        mainPane.getChildren().addAll(infoPane, viewTripsPane, createTripPane, sideRect,
                logoutButton, infoButton, createTripButton, viewTripsButton);
        // End of drawing scene ----------------------------------------------------------------------------------------

        // Events Section ----------------------------------------------------------------------------------------------
        logoutButton.setOnAction(event -> {
            stage.setScene(homeScene);
        });
        // -------------------------------------------------------------------------------------------------------------

        infoButton.setOnAction(event -> {
            infoPane.setVisible(true);
            createTripPane.setVisible(false);
            viewTripsPane.setVisible(false);
            infoButton.setBackground(new Background(new BackgroundFill(Color.PALEGOLDENROD, CornerRadii.EMPTY, Insets.EMPTY)));
            createTripButton.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            viewTripsButton.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        });
        // -------------------------------------------------------------------------------------------------------------

        createTripButton.setOnAction(event -> {
            infoPane.setVisible(false);
            createTripPane.setVisible(true);
            viewTripsPane.setVisible(false);
            infoButton.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            createTripButton.setBackground(new Background(new BackgroundFill(Color.PALEGOLDENROD, CornerRadii.EMPTY, Insets.EMPTY)));
            viewTripsButton.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        });
        // -------------------------------------------------------------------------------------------------------------

        viewTripsButton.setOnAction(event -> {
            infoPane.setVisible(false);
            createTripPane.setVisible(false);
            viewTripsPane.setVisible(true);
            infoButton.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            createTripButton.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            viewTripsButton.setBackground(new Background(new BackgroundFill(Color.PALEGOLDENROD, CornerRadii.EMPTY, Insets.EMPTY)));
        });
        // -------------------------------------------------------------------------------------------------------------
        saveButton.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            Alert info = new Alert(Alert.AlertType.INFORMATION);

            if (sourceField.getText().isEmpty() || timeField.getText().isEmpty() || stopsField.getText().isEmpty() ||
                    costField.getText().isEmpty() || destinationField.getText().isEmpty() ||
                    typeBox.getSelectionModel().isEmpty() || currencyBox.getSelectionModel().isEmpty() ||
                    vehicleBox.getSelectionModel().isEmpty() || driverBox.getSelectionModel().isEmpty() ||
                    date.getText().isEmpty()
            ) {
                alert.setContentText("Fill empty fields before saving");
                alert.show();
                return;
            }

            // To get the index of selected driver in the driver combo box
            int selectedIndex = driverBox.getSelectionModel().getSelectedIndex();
            String randomID = UUID.randomUUID().toString().substring(0, 7);
            admin.saveTrip(new Trips(randomID, driverIDBox.getItems().get(selectedIndex).toString(),
                    driverBox.getValue().toString(), sourceField.getText(), destinationField.getText(),
                    timeField.getText(), date.getText(), stopsField.getText(), typeBox.getValue().toString(),
                    vehicleBox.getValue().toString(), currencyBox.getValue().toString() + costField.getText())
            );

            sourceField.clear();
            timeField.clear();
            stopsField.clear();
            costField.clear();
            destinationField.clear();
            driverBox.getItems().clear();
            vehicleBox.getSelectionModel().clearSelection();
            currencyBox.getSelectionModel().clearSelection();
            typeBox.getSelectionModel().clearSelection();
            stateLabel.setText("");
            info.setContentText("Trip saved");
            info.show();
            refreshTripTable(allTripsTable);

        });
        // -------------------------------------------------------------------------------------------------------------
        driverBox.setOnMouseClicked(event -> {

            Alert alert = new Alert(Alert.AlertType.ERROR);

            if (vehicleBox.getSelectionModel().isEmpty()) {
                alert.setContentText("Choose vehicle first");
                alert.show();
                return;
            }
            String driverType = vehicleBox.getValue().toString();
            stateLabel.setText("Listing " + driverType + " drivers");
            driverBox.getItems().clear();
            driverIDBox.getItems().clear();

            ArrayList<Account> driversList = admin.listDrivers(driverType);

            for (Account val : driversList) {
                driverBox.getItems().add(val.getFirstName() + " " + val.getLastName());
            }

            for (Account val : driversList) {
                driverIDBox.getItems().add(val.getAccountID());
            }
        });
        // -------------------------------------------------------------------------------------------------------------

        vehicleBox.setOnMouseClicked(event -> {
            driverBox.getItems().clear();
            stateLabel.setText("");
        });
        // -------------------------------------------------------------------------------------------------------------
        deleteButton.setOnAction(event -> {
            int selectedTableIndex = allTripsTable.getSelectionModel().getSelectedIndex();
            Trips selectedTrip = (Trips) allTripsTable.getItems().get(selectedTableIndex);
            allTripsTable.getSelectionModel().clearSelection(selectedTableIndex);
            admin.deleteTrip(selectedTrip);
            refreshTripTable(allTripsTable);
        });
        // -------------------------------------------------------------------------------------------------------------
        back.setOnAction(event -> {
            viewTripsPane.setVisible(true);
            sideRect.setVisible(true);
            sideRect.setVisible(true);
            logoutButton.setVisible(true);
            saveButton.setVisible(true);
            infoButton.setVisible(true);
            createTripButton.setVisible(true);
            viewTripsButton.setVisible(true);
            oldDateLabel.setVisible(false);
            oldVehicleLabel.setVisible(false);
            oldDriverLabel.setVisible(false);
            infoPane.setVisible(false);
            createTripPane.setVisible(false);
            saveButtonEdit.setVisible(false);
            back.setVisible(false);
            headLabel.setText("Creating Trip");

            sourceField.clear();
            timeField.clear();
            stopsField.clear();
            costField.clear();
            destinationField.clear();
            driverBox.getItems().clear();
            vehicleBox.getSelectionModel().clearSelection();
            currencyBox.getSelectionModel().clearSelection();
            typeBox.getSelectionModel().clearSelection();
            stateLabel.setText("");

            createTripPane.setLayoutX(119);
            createTripPane.setLayoutY(0);
            createTripPane.setPrefWidth(669);
            createTripPane.setPrefHeight(529);

        });
        // -------------------------------------------------------------------------------------------------------------
        editButton.setOnAction(event -> {
            try {
                int selectedTableIndex = allTripsTable.getSelectionModel().getSelectedIndex();
                Trips selectedTrip = (Trips) allTripsTable.getItems().get(selectedTableIndex);
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Select trip to edit");
                alert.show();
                return;
            }
            int selectedTableIndex = allTripsTable.getSelectionModel().getSelectedIndex();
            Trips selectedTrip = (Trips) allTripsTable.getItems().get(selectedTableIndex);
            createTripPane.setVisible(true);
            saveButtonEdit.setVisible(true);
            back.setVisible(true);
            oldDateLabel.setVisible(true);
            oldVehicleLabel.setVisible(true);
            oldDriverLabel.setVisible(true);
            infoPane.setVisible(false);
            viewTripsPane.setVisible(false);
            sideRect.setVisible(false);
            logoutButton.setVisible(false);
            saveButton.setVisible(false);
            infoButton.setVisible(false);
            createTripButton.setVisible(false);
            viewTripsButton.setVisible(false);
            headLabel.setText("Editing Trip");

            createTripPane.setLayoutX(0);
            createTripPane.setLayoutY(0);
            createTripPane.setPrefWidth(788);
            createTripPane.setPrefHeight(529);

            sourceField.setText(selectedTrip.getSource());
            timeField.setText(selectedTrip.getDepartTime());
            stopsField.setText(selectedTrip.getNumberOfStops());
            destinationField.setText(selectedTrip.getDestination());
            costField.setText(selectedTrip.getPrice().substring(3));
            oldDateLabel.setText("Date was: " + selectedTrip.getDate());
            oldVehicleLabel.setText("Vehicle was: " + selectedTrip.getVehicle());
            oldDriverLabel.setText("Driver was: " + selectedTrip.getDriverName());

            // To get selected currency
            if (selectedTrip.getPrice().substring(0, 3).equals("EGP"))
                currencyBox.getSelectionModel().select(0);
            else
                currencyBox.getSelectionModel().select(1);
            //----------

            typeBox.getSelectionModel().select(selectedTrip.getType());


        });
        // -------------------------------------------------------------------------------------------------------------
        saveButtonEdit.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            Alert info = new Alert(Alert.AlertType.INFORMATION);
            if (sourceField.getText().isEmpty() || timeField.getText().isEmpty() || stopsField.getText().isEmpty() ||
                    costField.getText().isEmpty() || destinationField.getText().isEmpty() ||
                    typeBox.getSelectionModel().isEmpty() || currencyBox.getSelectionModel().isEmpty() ||
                    vehicleBox.getSelectionModel().isEmpty() || driverBox.getSelectionModel().isEmpty() ||
                    date.getText().isEmpty()
            ) {
                alert.setContentText("Fill empty fields before saving");
                alert.show();
                return;
            }
            int selectedDriverIndex = driverBox.getSelectionModel().getSelectedIndex();

            int selectedTableIndex = allTripsTable.getSelectionModel().getSelectedIndex();
            Trips oldTrip = (Trips) allTripsTable.getItems().get(selectedTableIndex);

            Trips editedTrip = new Trips(oldTrip.getTripID(), driverIDBox.getItems().get(selectedDriverIndex).toString(),
                    driverBox.getValue().toString(), sourceField.getText(), destinationField.getText(),
                    timeField.getText(), date.getText(), stopsField.getText(), typeBox.getValue().toString(),
                    vehicleBox.getValue().toString(), currencyBox.getValue().toString() + costField.getText());

            admin.saveEditedTrip(oldTrip, editedTrip);
            refreshTripTable(allTripsTable);

            sourceField.clear();
            timeField.clear();
            stopsField.clear();
            costField.clear();
            destinationField.clear();
            driverBox.getItems().clear();
            vehicleBox.getSelectionModel().clearSelection();
            currencyBox.getSelectionModel().clearSelection();
            typeBox.getSelectionModel().clearSelection();
            stateLabel.setText("");

            info.setContentText("Trip Edited");
            info.show();
            back.fire();

        });
        // -------------------------------------------------------------------------------------------------------------
        // End of events -----------------------------------------------------------------------------------------------
    }

    public Scene getScene() {
        return scene;
    }

    public void fillTables(TableView vehiclesTable, TableView driversTable, TableView tripsTable) {
        ArrayList<String> driverNumbersList = admin.driversNumbers();
        ArrayList<Account> driverList = admin.listDrivers("All");
        ArrayList<Trips> tripsArrayList = admin.listTrips();
        int listIndex = 0;
        int listRows = driverNumbersList.size() / 2;
        String[][] driversNumbersArray = new String[listRows][2];
        ObservableList<Account> observableList = FXCollections.observableArrayList();
        ObservableList<Trips> tripsObservableList = FXCollections.observableArrayList();
        // -------------------------------------------------------------------------------
        for (int i = 0; i < listRows; i++) {
            for (int j = 0; j < 2; j++) {
                driversNumbersArray[i][j] = driverNumbersList.get(listIndex++);
            }
        }

        for (int i = 0; i < listRows; i++) {
            vehiclesTable.getItems().add(driversNumbersArray[i]);
        }
        // -------------------------------------------------------------------------------
        for (int i = 0; i < driverList.size(); i++) {
            observableList.add(driverList.get(i));
        }
        driversTable.setItems(observableList);
        // -------------------------------------------------------------------------------

        for (int i = 0; i < tripsArrayList.size(); i++) {
            tripsObservableList.add(tripsArrayList.get(i));
        }
        tripsTable.setItems(tripsObservableList);

    }

    public void refreshTripTable(TableView tripsTable) {
        ArrayList<Trips> tripsArrayList = admin.listTrips();
        ObservableList<Trips> tripsObservableList = FXCollections.observableArrayList();
        for (int i = 0; i < tripsArrayList.size(); i++) {
            tripsObservableList.add(tripsArrayList.get(i));
        }
        tripsTable.setItems(tripsObservableList);
    }

    public void setHomeScene(Scene homeScene) {
        this.homeScene = homeScene;
    }
}
