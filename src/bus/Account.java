package bus;

import javafx.scene.control.Alert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Account {
    private String next;
    private String firstName, lastName;
    private Alert alert;
    private FileReader fileReader;
    private Scanner actualFileScanner = null;

    public boolean checkAccount(String username, String password, String type) {
        alert = new Alert(Alert.AlertType.ERROR);
        try {

            fileReader = new FileReader("src//accounts.txt");

            actualFileScanner = new Scanner(fileReader);

            while (actualFileScanner.hasNext()) {
                next = actualFileScanner.next();
                if (next.equals(username)) {
                    next = actualFileScanner.next();
                    if (next.equals(password)) {
                        next = actualFileScanner.next();
                        if (next.equals(type)) {
                            // Save the user's first name and last name in class variables
                            firstName = actualFileScanner.next();
                            lastName = actualFileScanner.next();
                            fileReader.close();
                            return true;
                        } else {
                            alert.setContentText("Your account is not " + type);
                            alert.show();
                            break;
                        }
                    } else {
                        alert.setContentText("Incorrect password");
                        alert.show();
                        break;
                    }
                } else if (!actualFileScanner.hasNext()) {
                    alert.setContentText("Incorrect username");
                    alert.show();
                    break;
                }
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
