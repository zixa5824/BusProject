package bus;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainSceneController {

    Alert alert;
    String username,password,next;
    FileReader fileReader;
    Scanner actualFileScanner = null;

    @FXML RadioButton clientButton;
    @FXML RadioButton driverButton;
    @FXML RadioButton managerButton;
    @FXML TextField usernameField;
    @FXML PasswordField passwordField;
    @FXML Button loginButton;

    public void loginButtonPressed(){
        username=usernameField.getText();
        password=passwordField.getText();
        if(clientButton.isSelected()) {
            if(checkAccount("client")) {
                System.out.println("Welcome Client");
            }
        }
        else if(driverButton.isSelected()) {
            if(checkAccount("driver")) {
                System.out.println("Welcome Driver");
            }
        }
        else if(managerButton.isSelected()) {
            if(checkAccount("manager")) {
                System.out.println("Welcome Manager");
            }
        }
    }
    public boolean checkAccount(String type){
        alert = new Alert(Alert.AlertType.ERROR);
        try {

            fileReader = new FileReader("src//accounts.txt");

            actualFileScanner = new Scanner(fileReader);

            while(actualFileScanner.hasNext()){
                next = actualFileScanner.next();

                if (next.equals(username)) {
                    System.out.println("Username found: "+next+"="+username);
                    next = actualFileScanner.next();
                    if(next.equals(password)){
                        System.out.println("Password found: "+next+"="+password);
                        next = actualFileScanner.next();
                        if(next.equals(type)) {
                            System.out.println("Type chosen "+type+" = "+next);
                            return true;
                        }
                        else {
                            alert.setContentText("Your account is not "+type);
                            alert.show();
                            break;
                        }
                    }
                    else
                    {
                        alert.setContentText("Incorrect password");
                        alert.show();
                        break;
                    }
                }

                else if(!actualFileScanner.hasNext()){
                    alert.setContentText("Incorrect username");
                    alert.show();
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


}
