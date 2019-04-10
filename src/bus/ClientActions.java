package bus;

import java.util.ArrayList;

public interface ClientActions {

    ArrayList<Trips> listTrips();
    void saveChanges(Trips[] tripAddToFile);


}
