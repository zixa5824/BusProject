package bus;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Client implements ClientActions{

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
            while (actualFileScanner.hasNext()) {
                scanned = actualFileScanner.nextLine().split(" ");
                tripList.add(new Trips(scanned[0], scanned[1], scanned[2] + " " + scanned[3]
                        , scanned[4], scanned[5],
                        scanned[6], scanned[7], scanned[8],
                        scanned[9], scanned[10], scanned[11]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tripList;
    }
}
