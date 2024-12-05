import java.util.ArrayList;
import java.util.List;

public class Garage<T extends Vehicle> {
    private List<T> vehicles = new ArrayList<>();

    public void addVehicle(T vehicle) {
        vehicles.add(vehicle);
        System.out.println(vehicle.getClass().getSimpleName() + " added to the garage.");
    }

    public void displayAllVehicles() {
        for (T vehicle : vehicles) {
            vehicle.displayInfo();
        }
    }
}