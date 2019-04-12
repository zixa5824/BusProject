package bus;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class Ticket {


    public void addRoundTicket(String accountID, String roundTrip) {
        ArrayList<String> fileTicket = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src//tickets.txt");
            Scanner scan = new Scanner(fileReader);
            String scannedLine;
            while (scan.hasNext()) {
                scannedLine = scan.nextLine();
                if (scannedLine.contains(accountID)) {

                    if (scannedLine.contains("-"))
                        scannedLine = accountID+" "+roundTrip;

                    else
                        scannedLine += (" " + roundTrip);
                }
                fileTicket.add(scannedLine);
            }

        } catch (FileNotFoundException e) {
            AlertBox.display("ERROR", "File Not Found");
        }
        // DONE GETTING ROUND TRIPS
        try {
            FileWriter fileWriter = new FileWriter("src//tickets.txt", false);
            for (int i = 0; i < fileTicket.size(); i++) {
                fileWriter.write(fileTicket.get(i) + "\r\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            AlertBox.display("ERROR", "IOEXCEPTION");
        }
    }

    public ArrayList<String> loadRoundTickets(String accountID)
    {
        ArrayList<String> roundTrips = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src//tickets.txt");
            Scanner scan = new Scanner(fileReader);
            scan.nextLine();//IGNORE FIRST LINE
            String scannedLine = scan.nextLine();
            while (scan.hasNext())
            {
                if (scannedLine.contains(accountID)) {
                    Scanner impScan = new Scanner(scannedLine);
                    impScan.next();//IGNORE ACCOUNT ID
                    String trip = impScan.next();
                    if(trip.equals("-")) break;
                    while(impScan.hasNext())
                    {
                        roundTrips.add(trip);
                        impScan.next();
                    }
                    break;
                }
                else
                {
                    scannedLine = scan.nextLine();
                }
            }
                } catch ( FileNotFoundException e ) {
            AlertBox.display("ERROR","NO FILE FOUND");
        }
        return roundTrips;
    }

}
