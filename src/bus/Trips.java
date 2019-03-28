package bus;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Trips {

    // This method finds driver's assigned trips and returns it to his table of trips (Used in driver scene)
    public ArrayList<String> getDriverTrips(Account account) {

        FileReader fileReader = null;
        String next;
        try {
            fileReader = new FileReader("src//trips.txt");
            Scanner actualFileScanner = new Scanner(fileReader);
            ArrayList<String> tripDetails = new ArrayList<>();

            while (actualFileScanner.hasNext()) {
                next = actualFileScanner.next();
                if (next.equals(account.getAccountID())) {
                    tripDetails.add(account.getFirstName());
                    for (int i = 1; i < 8; i++) {
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
    // -----------------------------------------------------------------------------------------------------------------

}
