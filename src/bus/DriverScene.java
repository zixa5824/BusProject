package bus;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DriverScene {

    private Scene scene;
    private Scene homeScene;


    DriverScene(Stage stage, Account account) {
    // Drawing the Scene -----------------------------------------------------------------------------------------------
        Pane pane = new Pane();
        scene = new Scene(pane,788,529);
        Font font = new Font(16);

        Label welcomeLabel = new Label("Welcome Driver");
        welcomeLabel.setPrefWidth(186);
        welcomeLabel.setPrefHeight(46);
        welcomeLabel.setLayoutX(301);
        welcomeLabel.setLayoutY(40);
        welcomeLabel.setAlignment(Pos.CENTER);
        welcomeLabel.setFont(Font.font(18));

        Label namePlaceLabel = new Label("Name:");
        namePlaceLabel.setPrefWidth(69);
        namePlaceLabel.setPrefHeight(23);
        namePlaceLabel.setLayoutX(250);
        namePlaceLabel.setLayoutY(103);
        namePlaceLabel.setFont(font);

        Label actualNameLabel = new Label(account.getFirstName()+" "+account.getLastName());
        actualNameLabel.setPrefWidth(165);
        actualNameLabel.setPrefHeight(30);
        actualNameLabel.setLayoutX(319);
        actualNameLabel.setLayoutY(100);
        actualNameLabel.setFont(font);
        actualNameLabel.setAlignment(Pos.CENTER);

        Label salaryPlaceLabel = new Label("Salary:");
        salaryPlaceLabel.setPrefWidth(69);
        salaryPlaceLabel.setPrefHeight(23);
        salaryPlaceLabel.setLayoutX(250);
        salaryPlaceLabel.setLayoutY(156);
        salaryPlaceLabel.setFont(font);

        Label actualSalaryLabel = new Label();
        actualSalaryLabel.setPrefWidth(165);
        actualSalaryLabel.setPrefHeight(30);
        actualSalaryLabel.setLayoutX(319);
        actualSalaryLabel.setLayoutY(154);
        actualSalaryLabel.setFont(font);
        actualSalaryLabel.setAlignment(Pos.CENTER);

        Label vehiclePlaceLabel = new Label("Vehicle:");
        vehiclePlaceLabel.setPrefWidth(69);
        vehiclePlaceLabel.setPrefHeight(23);
        vehiclePlaceLabel.setLayoutX(250);
        vehiclePlaceLabel.setLayoutY(214);
        vehiclePlaceLabel.setFont(font);

        Label actualVehicleLabel = new Label("Bus");
        actualVehicleLabel.setPrefWidth(165);
        actualVehicleLabel.setPrefHeight(30);
        actualVehicleLabel.setLayoutX(319);
        actualVehicleLabel.setLayoutY(212);
        actualVehicleLabel.setAlignment(Pos.CENTER);
        actualVehicleLabel.setFont(font);

        TableColumn numberColumn = new TableColumn("#");
        TableColumn sourceColumn = new TableColumn("Source");
        TableColumn destinationColumn = new TableColumn("Destination");
        TableColumn departTimeColumn = new TableColumn("Depart Time");
        TableColumn dateColumn = new TableColumn("Date");
        TableColumn stopsColumn = new TableColumn("# of stops");
        TableColumn typeColumn = new TableColumn("Type");
        TableColumn vehicleColumn = new TableColumn("Vehicle");

        TableView tripsTable = new TableView();
        tripsTable.setPrefWidth(640);
        tripsTable.setPrefHeight(153);
        tripsTable.setLayoutX(75);
        tripsTable.setLayoutY(310);
        tripsTable.getColumns().addAll(numberColumn,sourceColumn,destinationColumn,departTimeColumn,dateColumn);
        tripsTable.getColumns().addAll(stopsColumn,typeColumn,vehicleColumn);

        Button logoutButton = new Button("Logout");
        logoutButton.setPrefWidth(82);
        logoutButton.setPrefHeight(38);
        logoutButton.setLayoutX(34);
        logoutButton.setLayoutY(44);

        pane.getChildren().addAll(welcomeLabel,namePlaceLabel,actualNameLabel,salaryPlaceLabel,actualSalaryLabel);
        pane.getChildren().addAll(vehiclePlaceLabel,actualVehicleLabel,tripsTable,logoutButton);
    // End of drawing scene --------------------------------------------------------------------------------------------

    // Events Section --------------------------------------------------------------------------------------------------

    // Logout Button Event ---------------------------------------------------------------------------------------------
        logoutButton.setOnAction (e-> {
        stage.setScene(homeScene);
        });
    // End of logout event----------------------------------------------------------------------------------------------

    // End of events ---------------------------------------------------------------------------------------------------
    }
    public Scene getScene() {
        return scene;
    }

    public void setHomeScene(Scene homeScene) {
        this.homeScene = homeScene;
    }
}
