package bus;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;


public class MainSceneController {

    static Stage stage;
    private String username,password;
    private Account account;
    private Scene scene;

    @FXML RadioButton clientButton;
    @FXML RadioButton driverButton;
    @FXML RadioButton managerButton;
    @FXML TextField usernameField;
    @FXML PasswordField passwordField;
    @FXML Button loginButton;

    public void prepare() {
        // Loading the FXML file and creating its scene
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        scene = new Scene(root);
    }

    public void loginButtonPressed(){

        username = usernameField.getText().toLowerCase();
        password = passwordField.getText().toLowerCase();
        account = new Account();

        if(clientButton.isSelected()) {
            if(account.checkAccount(username,password,"client")) {
                System.out.println("Welcome Client");
            }
        }
        else if(driverButton.isSelected()) {
            if(account.checkAccount(username,password,"driver")) {
                // Account is correct then make driver scene class and give it the logic account and set stage scene
                DriverSceneController driverSceneController = new DriverSceneController();
                driverSceneController.prepare(); // To load FXML file and create the scene
                driverSceneController.setAccount(account);
                stage.setScene(driverSceneController.getScene());
                System.out.println("Welcome Driver");
                // ------------------------------------------------------------------------------
            }
        }
        else if(managerButton.isSelected()) {
            if(account.checkAccount(username,password,"manager")) {
                System.out.println("Welcome Manager");
            }
        }
    }

    public Scene getScene() {
        return scene;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
