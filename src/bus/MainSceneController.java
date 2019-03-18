package bus;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class MainSceneController {
    @FXML RadioButton clientButton;
    @FXML RadioButton driverButton;
    @FXML RadioButton managerButton;
    @FXML TextField usernameField;
    @FXML PasswordField passwordField;
    @FXML Button loginButton;

    public void loginButtonPressed(){
        if(clientButton.isSelected()) {
            //TODO: Check client's username and password
        }
        else if(driverButton.isSelected()) {
            //TODO: Check driver's username and password
        }
        else if(managerButton.isSelected()) {
            //TODO: Check manager's username and password
        }
    }


}
