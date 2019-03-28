package bus;

import javafx.scene.control.Alert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Account {
    private String accountID, firstName, lastName;
    private Alert alert;
    private FileReader fileReader;
    private Scanner actualFileScanner = null;

    // Validate username and password (Used in login scene)
    public boolean checkAccount(String username, String password, String type) {
        alert = new Alert(Alert.AlertType.ERROR);
        String next;
        String previous = null;
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
                            // Save the user's first name and last name and account ID in class variables
                            accountID = previous;
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
                previous = next;
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }
    // -----------------------------------------------------------------------------------------------------------------

    // Method returns a list of drivers
    ArrayList<String> driversList() {
        String next;
        String name;
        ArrayList<String> drivers = new ArrayList<>();

        try {
            fileReader = new FileReader("src//accounts.txt");
            actualFileScanner = new Scanner(fileReader);

            while (actualFileScanner.hasNext()) {
                next = actualFileScanner.next();
                if (next.equals("driver")) {
                    name = (actualFileScanner.next()+" "+actualFileScanner.next());
                    drivers.add(name);
                    drivers.add(actualFileScanner.next());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return drivers;
    }

    // Method returns the vehicles with number of drivers for the vehicle (Used in manager scene)
    ArrayList<String> driversNumbers() {
        int busCount = 0, limoCount = 0;
        String next;
        ArrayList<String> vehicleDriverList = new ArrayList<>();

        try {
            fileReader = new FileReader("src//accounts.txt");
            actualFileScanner = new Scanner(fileReader);

            while (actualFileScanner.hasNext()) {
                next = actualFileScanner.next();
                if (next.equals("Bus")) {
                    busCount++;
                } else if (next.equals("Limousine")) {
                    limoCount++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        vehicleDriverList.add("Bus");
        vehicleDriverList.add(Integer.toString(busCount));
        vehicleDriverList.add("Limousine");
        vehicleDriverList.add(Integer.toString(limoCount));
        return vehicleDriverList;
    }
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
}
