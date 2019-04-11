package bus;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client implements ClientActions{

    private int flag = 0;
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

    @Override
    public void saveChanges(String accountId,ArrayList<Trips> tripAddToFile) {
        try
        {
            FileReader fileReader = new FileReader("src//clients.txt");
            Scanner scan = new Scanner(fileReader);
            ArrayList<String> clientFile = new ArrayList<>();
            String scannedLine, editLine;
            while(scan.hasNext())
            {
                scannedLine = scan.nextLine();
                if (scannedLine.contains(accountId)) {
                    if(scannedLine.contains("-")){
                        editLine = accountId;
                        if(tripAddToFile.isEmpty()) editLine += " -";
                        else
                        for (Trips trip:tripAddToFile){
                            editLine += (" " + trip.getTripID());
                        }
                        clientFile.add(editLine);
                    }

                    else
                    {
                        editLine = accountId;
                        if(tripAddToFile.isEmpty()) {editLine += " -";}
                        else
                            for (Trips trip : tripAddToFile ) {
                                editLine += (" " + trip.getTripID());
                            }
                        clientFile.add(editLine);
                    }
                    continue;
                }
                else
                    clientFile.add(scannedLine);
            }
            fileReader.close();
            FileWriter fileWriter = new FileWriter("src//clients.txt",false);
            for (int i = 0; i < clientFile.size(); i++) {
                fileWriter.write(clientFile.get(i)+"\r\n");
            }
            fileWriter.close();
        }catch(FileNotFoundException e){
            AlertBox.display("Error","File Not Found");
        } catch (IOException e) {
            AlertBox.display("Error","IO Exception");
        }

    }

    public ArrayList<Trips> loadSavedTrips()
    {
        ArrayList<Trips> tripsID = new ArrayList<>();

        return tripsID;
    }
}
