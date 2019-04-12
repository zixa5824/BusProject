package bus;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import jdk.nashorn.internal.objects.annotations.Property;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ClientScene {

    private Scene scene;
    private Scene homeScene;
    private boolean save = false;

    public ClientScene(Stage stage , Account account) {
        Pane pane = new Pane();
        //client scene
        scene = new Scene(pane, 1222, 541);
        Label label = new Label();
        //Setting CLIENT NAME
        label.setText("Client Name: " + account.getFirstName() + " " + account.getLastName());
        label.setLayoutX(14);
        label.setLayoutY(14);
        label.setPrefWidth(368);
        label.setPrefHeight(31);
        //----
        Label tripsAva = new Label();
        tripsAva.setText("Trips Available");
        tripsAva.setLayoutX(249);
        tripsAva.setLayoutY(67);
        tripsAva.setPrefWidth(96);
        tripsAva.setPrefHeight(21);
        //----
        Label tripsRes = new Label();
        tripsRes.setText("Trips Reserved");
        tripsRes.setLayoutX(854);
        tripsRes.setLayoutY(67);
        tripsRes.setPrefWidth(101);
        tripsRes.setPrefHeight(21);
        //----
        TableView tableAva = new TableView();
        tableAva.setLayoutX(14);
        tableAva.setLayoutY(92);
        tableAva.setPrefWidth(600);
        tableAva.setPrefHeight(340);
        //----
        TableView tableRes = new TableView();
        tableRes.setLayoutX(625);
        tableRes.setLayoutY(92);
        tableRes.setPrefWidth(585);
        tableRes.setPrefHeight(340);
        //----
        Button btnRes = new Button();
        btnRes.setText("Reserve");
        btnRes.setLayoutX(260);
        btnRes.setLayoutY(438);
        //----
        Button btnDel = new Button();
        btnDel.setText("Delete");
        btnDel.setLayoutX(882);
        btnDel.setLayoutY(438);
        //----
        Button btnOut = new Button();
        btnOut.setText("Logout");
        btnOut.setLayoutX(14);
        btnOut.setLayoutY(496);
        btnOut.setPrefWidth(70);
        btnOut.setPrefHeight(31);
        //----
        Button btnSave = new Button();
        btnSave.setText("Save");
        btnSave.setLayoutX(1138);
        btnSave.setLayoutY(496);
        btnSave.setPrefWidth(70);
        btnSave.setPrefHeight(31);
        //ADD ALL BUTTONS >> LABELS >> SCROLL BARS >> TABLE VIEWS to THE PANE.
        pane.getChildren().addAll(btnDel,tableAva,tableRes,label,tripsAva,tripsRes,btnOut,btnRes,btnSave);
        // End of drawing scene ----------------------------------------------------------------------------------------

        // Events Section ----------------------------------------------------------------------------------------------

        // Logout Button Event -----------------------------------------------------------------------------------------
        btnOut.setOnAction(e -> {
            if(!save){
                AlertBox.saveDisplay("Save","Are you sure you want to logout without saving?", homeScene, stage);
            }
            else
                stage.setScene(homeScene);
        });
        // End of logout event------------------------------------------------------------------------------------------

        // End of events -----------------------------------------------------------------------------------------------
        //Show trips for the client in TABLE view ---- IN PROGRESS
        ObservableList<Trips> tripsObservableList = FXCollections.observableArrayList();
        ObservableList<Trips> resObservable = FXCollections.observableArrayList();
        Client client = new Client();
        ArrayList<Trips> trips = client.listTrips();
        ArrayList<Trips> reservedTrips;

        for (int i = 0; i < trips.size(); i++) {
            tripsObservableList.add(trips.get(i));
        }
        //FIRST TABLE
        //tripID, driverAccountID, driverName, source, destination, departTime, date, numberOfStops, type, vehicle, price;
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

        tableAva.setItems(tripsObservableList);

        tableAva.getColumns().addAll(driverNameColumn, sourceColumn, destinationColumn, timeColumn, dateColumn,
                stopsColumn, typeColumn, vehicleTypeColumn, priceColumn, tripIDColumn);
        tableAva.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
        //--------------------------
        //Table TWO
        TableColumn<Trips, String> driverNameColumn2 = new TableColumn("Driver");
        driverNameColumn2.setCellValueFactory(new PropertyValueFactory<>("driverName"));

        TableColumn<Trips, String> sourceColumn2 = new TableColumn("Source");
        sourceColumn2.setCellValueFactory(new PropertyValueFactory<>("source"));

        TableColumn<Trips, String> destinationColumn2 = new TableColumn("Destination");
        destinationColumn2.setCellValueFactory(new PropertyValueFactory<>("destination"));

        TableColumn<Trips, String> timeColumn2 = new TableColumn("Time");
        timeColumn2.setCellValueFactory(new PropertyValueFactory<>("departTime"));

        TableColumn<Trips, String> dateColumn2 = new TableColumn("Date");
        dateColumn2.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Trips, String> stopsColumn2 = new TableColumn("Stops");
        stopsColumn2.setCellValueFactory(new PropertyValueFactory<>("numberOfStops"));

        TableColumn<Trips, String> typeColumn2 = new TableColumn("Type");
        typeColumn2.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<Trips, String> vehicleTypeColumn2 = new TableColumn("Vehicle");
        vehicleTypeColumn2.setCellValueFactory(new PropertyValueFactory<>("vehicle"));

        TableColumn<Trips, String> priceColumn2 = new TableColumn("Price");
        priceColumn2.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Trips, String> tripIDColumn2 = new TableColumn();
        tripIDColumn2.setCellValueFactory(new PropertyValueFactory<>("tripID"));
        tripIDColumn2.setVisible(false);

        tableRes.getColumns().addAll(driverNameColumn2, sourceColumn2, destinationColumn2, timeColumn2, dateColumn2,
                stopsColumn2, typeColumn2, vehicleTypeColumn2, priceColumn2, tripIDColumn2);
        tableRes.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);

        //Loading Reserved Trips for saved account of clients

        ObservableList<Trips> obsTable1 = FXCollections.observableArrayList(), obsTable2 = FXCollections.observableArrayList();
        reservedTrips = client.loadSavedTrips(account.getAccountID());
        if(!reservedTrips.isEmpty()) {

            for (int i = 0; i < reservedTrips.size(); i++) {
                for (int j = 0; j < trips.size(); j++) {
                    if (trips.get(j) == reservedTrips.get(i)) {
                        trips.remove(j);
                        j = trips.size();
                    }
                }
            }
            for (int i = 0; i < trips.size() ; i++) {
                obsTable1.add(trips.get(i));
            }
            for (int i = 0; i < reservedTrips.size(); i++) {
                obsTable2.add(reservedTrips.get(i));
            }
            tableAva.setItems(obsTable1);
            tableRes.setItems(obsTable2);
            save = true;
        }
        //---------------

        //RESERVE TRIP
        Ticket ticket = new Ticket();
        ticket.setAccountID(account.getAccountID());
        btnRes.setOnAction(e -> {
            try
            {
                save = false;
                AlertBox alertBox = new AlertBox();
                Trips selectedTrip = (Trips) tableAva.getItems().get(tableAva.getSelectionModel().getSelectedIndex());
                selectedTrip = alertBox.reserveDisplay("Choose an Option","Please select Round Trip or One way Trip", selectedTrip);
                if(!alertBox.isCheck())  {
                    return;
                }
                reservedTrips.add(selectedTrip);
                trips.remove(selectedTrip);
                // Clear the reserved trips observable list and refill with the array list with newly added reserved trip
                resObservable.clear();
                for (Trips trip : reservedTrips) {
                    resObservable.add(trip);
                }
                tableRes.setItems(resObservable);

                // Remove the reserved trip from the trips table
                tripsObservableList.clear();
                for (Trips trip : trips) {
                    tripsObservableList.add(trip);
                }
                tableAva.setItems(tripsObservableList);
            }catch(ArrayIndexOutOfBoundsException i){
                AlertBox.display("ERROR","Please make sure to select the trip to reserve");
            }
        });
        //DELETE TRIP
        btnDel.setOnAction(e -> {
                try
                {
                    save = false;
                    Trips selectedReservedTrip = (Trips) tableRes.getItems().get(tableRes.getSelectionModel().getSelectedIndex());
                    reservedTrips.remove(selectedReservedTrip);
                    trips.add(0, selectedReservedTrip);

                    resObservable.clear();
                    for (Trips trip : reservedTrips) {
                        resObservable.add(trip);
                    }
                    tableRes.setItems(resObservable);

                    tripsObservableList.clear();
                    for (Trips trip : trips) {
                        tripsObservableList.add(trip);
                    }
                    tableAva.setItems(tripsObservableList);
                }catch (ArrayIndexOutOfBoundsException i){
                    AlertBox.display("ERROR","Please make sure to select the trip to delete");
                }
        });

        btnSave.setOnAction(e-> {
            client.saveChanges(account.getAccountID(),reservedTrips);
            save = true;
        });

    }

    public Scene getScene() {
        return scene;
    }

    public void setHomeScene(Scene homeScene) {
        this.homeScene = homeScene;
    }
}
