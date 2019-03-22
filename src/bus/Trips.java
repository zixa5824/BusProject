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
    public ArrayList<String> getDriverTrips(String firstName) {

        FileReader fileReader = null;
        try {
            fileReader = new FileReader("src//trips.txt");
            Scanner actualFileScanner = new Scanner(fileReader);
            ArrayList<String> tripDetails = new ArrayList<>();

            while (actualFileScanner.hasNext()) {
                String next = actualFileScanner.next();
                if (next.equals(firstName)) {
                    tripDetails.add(next);
                    for (int i = 0; i < 6; i++) {
                        tripDetails.add(actualFileScanner.next());
                    }
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
