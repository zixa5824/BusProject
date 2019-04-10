package bus;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static javafx.scene.paint.Color.WHITE;

public class LoginScene {

    private String username, password;
    private Scene scene;

    LoginScene(Stage stage, Account account) {

        // Drawing the Scene -----------------------------------------------------------------------------------------------
        Pane pane = new Pane();
        scene = new Scene(pane, 788, 529);

        // Font for the labels
        Font font = new Font(14);

        // Adding background image
        ImageView backgroundView = new ImageView();
        Image backgroundImage = new Image("bus.jpg");
        backgroundView.setFitWidth(800);
        backgroundView.setFitHeight(540);
        backgroundView.setImage(backgroundImage);

        // Making an ellipse
        Ellipse ellipse = new Ellipse();
        ellipse.setFill(WHITE);
        ellipse.setOpacity(0.79);
        ellipse.setRadiusX(183);
        ellipse.setRadiusY(101);
        ellipse.setLayoutX(402);
        ellipse.setLayoutY(270);

        // Making toggle group for the radio buttons so you can only choose one at a time
        ToggleGroup radioGroup = new ToggleGroup();

        Label usernameLabel = new Label("Username:");
        usernameLabel.setLayoutX(244);
        usernameLabel.setLayoutY(228);
        usernameLabel.setFont(font);

        Label passwordLabel = new Label("Password:");
        passwordLabel.setLayoutX(246);
        passwordLabel.setLayoutY(261);
        passwordLabel.setFont(font);

        TextField usernameField = new TextField();
        usernameField.setLayoutX(319);
        usernameField.setLayoutY(225);

        PasswordField passwordField = new PasswordField();
        passwordField.setLayoutX(319);
        passwordField.setLayoutY(258);

        Button loginButton = new Button("Login");
        loginButton.setLayoutX(472);
        loginButton.setLayoutY(259);
        loginButton.setPrefWidth(66);
        loginButton.setPrefHeight(25);

        RadioButton clientButton = new RadioButton("Client");
        clientButton.setLayoutX(276);
        clientButton.setLayoutY(296);
        clientButton.setToggleGroup(radioGroup);
        clientButton.setFont(font);

        RadioButton driverButton = new RadioButton("Driver");
        driverButton.setLayoutX(349);
        driverButton.setLayoutY(296);
        driverButton.setToggleGroup(radioGroup);
        driverButton.setFont(font);

        RadioButton managerButton = new RadioButton("Manager");
        managerButton.setLayoutX(423);
        managerButton.setLayoutY(296);
        managerButton.setToggleGroup(radioGroup);
        managerButton.setFont(font);

        pane.getChildren().addAll(backgroundView, ellipse, usernameLabel, passwordLabel, usernameField, passwordField);
        pane.getChildren().addAll(loginButton, clientButton, driverButton, managerButton);

        // -------------------------------------------------------------------------------------------------------------

        // Events Section ----------------------------------------------------------------------------------------------
        // Login Button Event ------------------------------------------------------------------------------------------
        loginButton.setOnAction(e -> {

            username = usernameField.getText().toLowerCase();
            password = passwordField.getText().toLowerCase();
            if (clientButton.isSelected()) {
                if (account.checkAccount(username, password, "Client")) {
                    // Account is correct then make client scene class and give it the stage and logic account
                    ClientScene clientScene = new ClientScene(stage, account);
                    clientScene.setHomeScene(this.scene);
                    stage.setScene(clientScene.getScene());
                    System.out.println("Welcome Client");
                    // Clear the text fields after the user has logged in
                    usernameField.setText("");
                    passwordField.setText("");
                    // ------------------------------------------------------------------------------
                }
            } else if (driverButton.isSelected()) {
                if (account.checkAccount(username, password, "Driver")) {
                    // Account is correct then make driver scene class and give it the stage and logic account
                    DriverScene driverScene = new DriverScene(stage, account);
                    driverScene.setHomeScene(this.scene);
                    stage.setScene(driverScene.getScene());
                    System.out.println("Welcome Driver");
                    // Clear the text fields after the user has logged in
                    usernameField.setText("");
                    passwordField.setText("");
                    // ------------------------------------------------------------------------------
                }
            } else if (managerButton.isSelected()) {
                if (account.checkAccount(username, password, "Manager")) {
                    // Account is correct then make manager scene class and give it the stage and logic account
                    ManagerScene managerScene= new ManagerScene(stage, account);
                    managerScene.setHomeScene(this.scene);
                    stage.setScene(managerScene.getScene());
                    System.out.println("Welcome Manager");
                    // Clear the text fields after the user has logged in
                    usernameField.setText("");
                    passwordField.setText("");
                    // ------------------------------------------------------------------------------
                }
            }
        });
        // End of Login Button Event -----------------------------------------------------------------------------------

        // End of events -----------------------------------------------------------------------------------------------
    }

    public Scene getScene() {
        return scene;
    }
