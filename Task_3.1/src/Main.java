public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla", 2020, 4, 6.5);
        Truck truck = new Truck("Volvo", "FH16", 2018, 20, 18000);

        Garage<Vehicle> garage = new Garage<>();
        garage.addVehicle(car);
        garage.addVehicle(truck);
        System.out.println("Vehicles in the garage:");
        garage.displayAllVehicles();

        CarService carService = new CarService();
        TruckService truckService = new TruckService();
        carService.service(car);
        truckService.service(truck);
    }
}