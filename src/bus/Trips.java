package bus;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Trips {
    private String tripID, driverAccountID, driverName, source, destination, departTime, date, numberOfStops, type, vehicle, price;

    public Trips(String tripID, String driverAccountID, String driverName, String source, String destination, String departTime, String date, String numberOfStops, String type, String vehicle, String price) {
        this.tripID = tripID;
        this.driverAccountID = driverAccountID;
        this.driverName = driverName;
        this.source = source;
        this.destination = destination;
        this.departTime = departTime;
        this.date = date;
        this.numberOfStops = numberOfStops;
        this.type = type;
        this.vehicle = vehicle;
        this.price = price;
    }

    Trips() {

    }

    // -------------------------------------------------------------------------------------------------------------
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
                    tripDetails.add(actualFileScanner.next());
                    actualFileScanner.next(); // to skip reading last name from the file
                    for (int i = 1; i < 8; i++) {
                        tripDetails.add(actualFileScanner.next());
                    }
                }
            }
            actualFileScanner.close();
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


    public void setPrice(String price) {
        this.price = price;
    }

    public String getDriverAccountID() {
        return driverAccountID;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartTime() {
        return departTime;
    }

    public String getDate() {
        return date;
    }

    public String getNumberOfStops() {
        return numberOfStops;
    }

    public String getType() {
        return type;
    }

    public String getVehicle() {
        return vehicle;
    }

    public String getPrice() {
        return price;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getTripID() {
        return tripID;
    }
}
