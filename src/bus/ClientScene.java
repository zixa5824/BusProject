package bus;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import jdk.nashorn.internal.objects.annotations.Property;

import java.util.ArrayList;

public class ClientScene {

    private Scene scene;
    private Scene homeScene;

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
        //ADD ALL BUTTONS >> LABELS >> SCROLL BARS >> LIST VIEWS to THE PANE.
        pane.getChildren().addAll(tableAva,tableRes,label,tripsAva,tripsRes,btnOut,btnRes,btnSave);
        // End of drawing scene ----------------------------------------------------------------------------------------

        // Events Section ----------------------------------------------------------------------------------------------

        // Logout Button Event -----------------------------------------------------------------------------------------
        btnOut.setOnAction(e -> {
            stage.setScene(homeScene);
        });
        // End of logout event------------------------------------------------------------------------------------------

        // End of events -----------------------------------------------------------------------------------------------
        //Show trips for the client in list view ---- IN PROGRESS
        ObservableList<Trips> tripsObservableList = FXCollections.observableArrayList();
        Client client = new Client();
        ArrayList<Trips> trips = client.listTrips();
        for(int i = 0; i <trips.size(); i++)
        {
            tripsObservableList.add(trips.get(i));
        }
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

    }

    public Scene getScene() {
        return scene;
    }

    public void setHomeScene(Scene homeScene) {
        this.homeScene = homeScene;
    }
}
