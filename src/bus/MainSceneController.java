package bus;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainSceneController {

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

        try {
            if(type.equals("client")) {
                fileReader = new FileReader("src//clients.txt");
            }
            else if(type.equals("driver")) {
                fileReader = new FileReader("src//drivers.txt");
            }
            else if(type.equals("manager")) {
                fileReader = new FileReader("src//managers.txt");
            }

            actualFileScanner = new Scanner(fileReader);

            while(actualFileScanner.hasNext()){
                next = actualFileScanner.next();

                if (next.equals(username)) {
                    System.out.println("Username found: "+next+"="+username);
                    next = actualFileScanner.next();
                    if(next.equals(password)){
                        System.out.println("Password found: "+next+"="+password);
                        return true;
                    }
                    else
                    {
                        System.out.println("Incorrect password: "+password+" is not "+next);
                        break;
                    }
                }

                else if(!actualFileScanner.hasNext()){
                    System.out.println("Incorrect username");
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
