package bus;


// The logic class for manager scene

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin implements AdminActions {
    @Override
    public ArrayList<Account> listDrivers() {
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
                    driverList.add(new Account(accountID, firstName, lastName));
                }
            }
            return driverList;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return null;
    }

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

    @Override
    public void saveTrip(ArrayList<Trips> list) {

    }
}
