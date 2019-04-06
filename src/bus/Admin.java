package bus;


// The logic class for manager scene

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

public class Admin implements AdminActions {

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public ArrayList<Trips> listTrips() {
        ArrayList<Trips> tripList = new ArrayList<>();
        //tripID, driverAccountID, driverName, source, destination, departTime, date, numberOfStops, type, vehicle, price;
        try {
            FileReader fileReader = new FileReader("src//trips.txt");
            Scanner actualFileScanner = new Scanner(fileReader);
            String[] scanned = new String[12];
            actualFileScanner.nextLine();
            actualFileScanner.nextLine(); // skip first 2 lines in the file
            while (actualFileScanner.hasNext()){
                scanned = actualFileScanner.nextLine().split(" ");
                tripList.add(new Trips(scanned[0],scanned[1],scanned[2]+" "+scanned[3]
                        ,scanned[4],scanned[5],
                        scanned[6],scanned[7],scanned[8],
                        scanned[9],scanned[10],scanned[11]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tripList;
    }
    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public ArrayList<Account> listDrivers(String vehicle) {
        FileReader fileReader = null;
        try {

            fileReader = new FileReader("src//accounts.txt");
            Scanner actualFileScanner = new Scanner(fileReader);
            String accountID, firstName, lastName, profession, type;
            ArrayList<Account> driverList = new ArrayList<>();
            while (actualFileScanner.hasNext()) {
                accountID = actualFileScanner.next();
                actualFileScanner.next();
                actualFileScanner.next();
                profession = actualFileScanner.next();
                firstName = actualFileScanner.next();
                lastName = actualFileScanner.next();
                type = actualFileScanner.next();
                if (profession.equals("Driver")) {

                    if (type.equals(vehicle) || vehicle.equals("All"))
                        driverList.add(new Account(accountID, firstName, lastName, type));
                }
            }
            return driverList;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return null;
    }
    // -----------------------------------------------------------------------------------------------------------------

    // -----------------------------------------------------------------------------------------------------------------
    // Method returns the vehicles with number of drivers for the vehicle (Used in manager scene)
    @Override
    public ArrayList<String> driversNumbers() {
        int busCount = 0, limoCount = 0;
        String next;
        ArrayList<String> vehicleDriverList = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("src//accounts.txt");
            Scanner actualFileScanner = new Scanner(fileReader);

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
    @Override
    public void saveTrip(Trips trip) {
        try {
            FileWriter fileWriter = new FileWriter("src//trips.txt", true);
            fileWriter.write("\n" + trip.getTripID() + " " + trip.getDriverAccountID() + " " + trip.getDriverName()
                    + " " + trip.getSource() + " " + trip.getDestination() + " " + trip.getDepartTime() + " " +
                    trip.getDate() + " " + trip.getNumberOfStops() + " " + trip.getType() + " " +
                    trip.getVehicle() + " " + trip.getPrice());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // -----------------------------------------------------------------------------------------------------------------


}
