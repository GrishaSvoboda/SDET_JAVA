public abstract class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected static int totalVehicles = 0;

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        totalVehicles++;
    }

    public static int getTotalVehicles() {
        return totalVehicles;
    }

    public abstract void displayInfo();
}
