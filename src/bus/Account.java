package bus;

import javafx.scene.control.Alert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Account {
    String next;
    Alert alert;
    FileReader fileReader;
    Scanner actualFileScanner = null;

    public boolean checkAccount(String username,String password,String type){
        alert = new Alert(Alert.AlertType.ERROR);
        try {

            fileReader = new FileReader("src//accounts.txt");

            actualFileScanner = new Scanner(fileReader);

            while(actualFileScanner.hasNext()){
                next = actualFileScanner.next();
                if (next.equals(username)) {
                    next = actualFileScanner.next();
                    if(next.equals(password)){
                        next = actualFileScanner.next();
                        if(next.equals(type)) {
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
        }
        return false;
    }
}