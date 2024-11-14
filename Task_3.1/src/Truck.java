public class Truck extends Vehicle implements FuelEfficiency, LoadCapacity {
    private double fuelConsumption;
    private double maxLoadCapacity;
    private double currentLoad;

    public Truck(String brand, String model, int year, double fuelConsumption, double maxLoadCapacity) {
        super(brand, model, year);
        this.fuelConsumption = fuelConsumption;
        this.maxLoadCapacity = maxLoadCapacity;
        this.currentLoad = 0;
    }

    @Override
    public double calculateFuelEfficiency() {
        double efficiency = 100 / fuelConsumption;
        if (efficiency < 5) {
            System.out.println("Warning: Very low fuel efficiency due to heavy load.");
        }
        return efficiency;
    }

    @Override
    public double getMaxLoadCapacity() {
        return maxLoadCapacity;
    }

    public void loadTruck(double load) {
        if ((currentLoad + load) > maxLoadCapacity) {
            System.out.println("Cannot load " + load + " kg. Exceeds maximum capacity!");
        } else {
            currentLoad += load;
            System.out.println("Loaded " + load + " kg. Current load: " + currentLoad + " kg.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Truck: " + brand + " " + model + ", Year: " + year + ", Max Load: " + maxLoadCapacity + " kg");
    }
}