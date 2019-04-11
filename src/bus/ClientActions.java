package bus;

import java.util.ArrayList;

public interface ClientActions {

    ArrayList<Trips> listTrips();
    void saveChanges(String accountId,ArrayList<Trips>tripAddToFile);
    ArrayList<Trips> loadSavedTrips();
}
