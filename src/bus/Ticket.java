package bus;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Ticket {

    private String accountID = new String();

    public void addRoundTicket(Trips roundTrip)
    {
        ArrayList<String> roundTicketsAddToFile = new ArrayList<>();
        ArrayList<String> fileTicket = new ArrayList<>();
        roundTicketsAddToFile.add(roundTrip.getTripID());
        try {
            FileReader fileReader = new FileReader("src//tickets.txt");
            Scanner scan = new Scanner(fileReader);
            String scannedLine = scan.nextLine();
            fileTicket.add(scannedLine); // IGNORE FIRST LINE
            scannedLine = scan.nextLine();
            System.out.println(scannedLine);
            while(scan.hasNext())
            {
                Scanner impScan = new Scanner(scannedLine);
                String fileAccountID = impScan.next();
                if(fileAccountID.equals(accountID))
                {
                    String roundFileTrip = impScan.next();
                    while(impScan.hasNext())
                    {
                        roundTicketsAddToFile.add(roundFileTrip);
                        roundFileTrip = impScan.next();
                    }


                }
                else {
                    scannedLine = scan.nextLine();
                    fileTicket.add(scannedLine);
                }
            }
            String add = new String();
            add += (accountID+" ");
            for (int i = 0; i < roundTicketsAddToFile.size(); i++) {
                add += roundTicketsAddToFile.get(i)+" ";
            }
            System.out.println(add);
            fileTicket.add(add);
        } catch ( FileNotFoundException e ) {
            AlertBox.display("ERROR","File Not Found");
        }
        // DONE GETTING ROUND TRIPS ID FROM FILE AND added them to arrayList called roundTicketsAddToFile.
        try {
            FileWriter fileWriter = new FileWriter("src//tickets.txt",false);
            for (int i = 0; i < fileTicket.size(); i++) {
                fileWriter.write(fileTicket.get(i)+"\r\n");
            }
            fileWriter.close();
        } catch ( IOException e ) {
            AlertBox.display("ERROR","IOEXCEPTION");
        }
    }
    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }
}
