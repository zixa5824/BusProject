package bus;

import java.io.*;
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

    public void removeRoundTrip(String accountID, String tripID)
    {
        File ticketFile = new File("src//tickets.txt");
        try {

            ArrayList<String> ticketList = new ArrayList<>();
            Scanner actualFileScanner = new Scanner(ticketFile);
            String currentLine;

            while (actualFileScanner.hasNext()){
                currentLine = actualFileScanner.nextLine();

                if(currentLine.contains(tripID)) {
                    String[] splitter = new String[currentLine.length()];
                    splitter = currentLine.split(" ");
                    currentLine = splitter[0];

                    for (int i = 1; i < splitter.length; i++) {
                        if(!splitter[i].equals(tripID))
                            currentLine += (" "+splitter[i]);
                    }

                    if(currentLine.length() == 8)
                        currentLine += " -";

                    ticketList.add(currentLine);
                    continue;
                }
                ticketList.add(currentLine);
            }
            actualFileScanner.close();

            FileWriter fileWriter = new FileWriter(ticketFile, false);
            for (int i = 0; i < ticketList.size(); i++) {

                fileWriter.write(ticketList.get(i)+"\r\n");
            }
            fileWriter.close();
        } catch ( FileNotFoundException e ) {
            AlertBox.display("ERROR","FILE NOT FOUND");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
