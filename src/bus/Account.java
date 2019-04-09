package bus;

import javafx.scene.control.Alert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Account {
    private String accountID, firstName, lastName, type;

    // Constructor used for entering data
    public Account(String accountID, String firstName, String lastName, String type) {
        this.accountID = accountID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
    }

    // Constructor (method overloading) for not entering data
    Account() {

    }

    // -----------------------------------------------------------------------------------------------------------------
    // Validate username and password (Used in login scene)
    public boolean checkAccount(String username, String password, String type) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        String next;
        String previous = null;
        try {

            FileReader fileReader = new FileReader("src//accounts.txt");

            Scanner actualFileScanner = new Scanner(fileReader);

            while (actualFileScanner.hasNext()) {
                next = actualFileScanner.next();
                if (next.equals(username)) {
                    next = actualFileScanner.next();
                    if (next.equals(password)) {
                        next = actualFileScanner.next();
                        if (next.equals(type)) {
                            // Save the user's first name and last name and account ID in class variables
                            accountID = previous;
                            firstName = actualFileScanner.next();
                            lastName = actualFileScanner.next();
                            type = actualFileScanner.next();
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
                previous = next;
            }
            actualFileScanner.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }
    // -----------------------------------------------------------------------------------------------------------------


    // -----------------------------------------------------------------------------------------------------------------

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAccountID() {
        return accountID;
    }

    public String getType() {
        return type;
    }
}
