/**
 * Основной класс для тестирования.
 * <p>
 * В проект были добавлены следующие файлы:
 * - FuelEfficiency.java
 * - LoadCapacity.java
 * - Vehicle.java
 * - Car.java
 * - Truck.java
 * - Main.java
 */
public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla", 2020, 4, 6.5);
        Truck truck = new Truck("Volvo", "FH16", 2018, 20, 18000);

        car.displayInfo();
        System.out.println("Fuel Efficiency: " + car.calculateFuelEfficiency() + " km/l");

        truck.displayInfo();
        System.out.println("Fuel Efficiency: " + truck.calculateFuelEfficiency() + " km/l");
        truck.loadTruck(5000); // Пример загрузки
        truck.loadTruck(14000); // Проверка превышения грузоподъемности
        System.out.println("Total Vehicles: " + Vehicle.getTotalVehicles());
    }
}
