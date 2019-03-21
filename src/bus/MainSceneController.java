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
    String username,password;
    Account account = new Account();

    @FXML RadioButton clientButton;
    @FXML RadioButton driverButton;
    @FXML RadioButton managerButton;
    @FXML TextField usernameField;
    @FXML PasswordField passwordField;
    @FXML Button loginButton;

    public void loginButtonPressed(){
        username=usernameField.getText();
        password=passwordField.getText();
        account = new Account();
        if(clientButton.isSelected()) {
            if(account.checkAccount(username,password,"client")) {
                System.out.println("Welcome Client");
            }
        }
        else if(driverButton.isSelected()) {
            if(account.checkAccount(username,password,"driver")) {
                Parent root = null;


                try {
                    root = FXMLLoader.load(getClass().getResource("DriverScene.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }


                Scene driverScene = new Scene(root, 788, 530);
                stage.setScene(driverScene);
                System.out.println("Welcome Driver");
            }
        }
        else if(managerButton.isSelected()) {
            if(account.checkAccount(username,password,"manager")) {
                System.out.println("Welcome Manager");
            }
        }
    }

}
