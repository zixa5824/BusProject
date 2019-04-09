package bus;

import java.util.ArrayList;

public interface AdminActions {
    /**
     * @return list of vehicles (3 types at least)
     */
//    public ArrayList<Vehicle> listVehicles();

    /**
     * @return list of trips
     */
    public ArrayList<Trips> listTrips();

    /**
     * @return list of drivers
     */
    public ArrayList<Account> listDrivers(String vehicle);

    /**
     * @return list of drivers
     */
    public ArrayList<String> driversNumbers();

    /**
     * @param list * save list of vehicles
     */
//    public void saveVehicles(ArrayList<Vehicle> list);

    /**
     * @param trip * save list of trips
     */
    public void saveTrip(Trips trip);

    public void deleteTrip(Trips trip);

    public void saveEditedTrip(Trips oldTrip, Trips editedTrip);

    /**
     * @param list * save list of drivers
     */
//    public void savePersons(ArrayList<Person> list);
}
