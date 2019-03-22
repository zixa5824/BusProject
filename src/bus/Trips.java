package bus;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Trips {

    // This method finds driver's assigned trips and returns it to his table of trips
    public ObservableList<String> getDriverTrips(String firstName) {

        FileReader fileReader = null;
        try {
            fileReader = new FileReader("src//trips.txt");
            Scanner actualFileScanner = new Scanner(fileReader);
            String driver, source, destination, departTime, date, numberOfStops, type, vehicle;
            ObservableList<String> tripDetails = FXCollections.observableArrayList();

            while (actualFileScanner.hasNext()) {
                String next = actualFileScanner.next();
                if (next.equals(firstName)) {

                    driver = next;
                    source = actualFileScanner.next();
                    destination = actualFileScanner.next();
                    departTime = actualFileScanner.next();
                    date = actualFileScanner.next();
                    numberOfStops = actualFileScanner.next();
                    type = actualFileScanner.next();
                    vehicle = actualFileScanner.next();

                    tripDetails.add(driver);
                }
            }
            fileReader.close();
            return tripDetails;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
