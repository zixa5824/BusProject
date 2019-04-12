package bus;

import java.util.ArrayList;

public interface AdminActions {

    /**
     * @return list of vehicles (3 types at least)
     */
    public ArrayList<Vehicle> listVehicles();

    /**
     * @return list of trips
     */
    public ArrayList<Trips> listTrips();

    /**
     * @return list of drivers
     */
    public ArrayList<Account> listDrivers(String vehicle);


    public ArrayList<String> driversNumbers();

    /**
     * @param trip * save list of trips
     */
    public void saveTrip(Trips trip);

    public void deleteTrip(Trips trip);

    public void saveEditedTrip(Trips oldTrip, Trips editedTrip);

}
