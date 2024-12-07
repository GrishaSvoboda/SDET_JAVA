/** Класс "Легковой автомобиль", наследуется от Vehicle и реализует интерфейс FuelEfficiency */
public class Car extends Vehicle implements FuelEfficiency {
    private int numberOfDoors;
    private double fuelConsumption;

    public Car(String brand, String model, int year, int numberOfDoors, double fuelConsumption) {
        super(brand, model, year);
        this.numberOfDoors = numberOfDoors;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public double calculateFuelEfficiency() {
        double efficiency = 100 / fuelConsumption;
        if (efficiency < 10) {
            System.out.println("Warning: Low fuel efficiency!");
        }
        return efficiency;
    }

    @Override
    public void displayInfo() {
        System.out.println("Car: " + brand + " " + model + ", Year: " + year + ", Doors: " + numberOfDoors);
    }
}
