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
                if(profession.equals("driver")){
                    driverList.add(new Account(accountID,firstName,lastName));
                }
            }
            return driverList;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public void saveTrip(ArrayList<Trips> list) {

    }
}
