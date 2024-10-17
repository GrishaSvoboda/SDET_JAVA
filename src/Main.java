// Интерфейс для расчета топливной эффективности
interface FuelEfficiency {
    double calculateFuelEfficiency(); // Метод для расчета расхода топлива
}

// Интерфейс для расчета грузоподъемности
interface LoadCapacity {
    double getMaxLoadCapacity(); // Метод для определения максимальной грузоподъемности
}

// Абстрактный класс "Транспортное средство"
abstract class Vehicle {
    protected String brand;  // Инкапсуляция: поля защищены для наследования
    protected String model;
    protected int year;

    // Статическое поле для подсчета количества транспортных средств
    protected static int totalVehicles = 0;

    // Параметризованный конструктор
    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        totalVehicles++;  // Увеличение количества транспортных средств
    }

    // Статический метод для получения общего количества транспортных средств
    public static int getTotalVehicles() {
        return totalVehicles;
    }

    // Абстрактный метод для отображения информации
    public abstract void displayInfo();
}

// Класс "Легковой автомобиль", наследуется от Vehicle и реализует интерфейс FuelEfficiency
class Car extends Vehicle implements FuelEfficiency {
    private int numberOfDoors;  // Поле для количества дверей
    private double fuelConsumption; // Расход топлива (литры на 100 км)

    public Car(String brand, String model, int year, int numberOfDoors, double fuelConsumption) {
        super(brand, model, year);  // Вызов конструктора родительского класса
        this.numberOfDoors = numberOfDoors;
        this.fuelConsumption = fuelConsumption;
    }

    // Реализация метода из интерфейса FuelEfficiency
    @Override
    public double calculateFuelEfficiency() {
        return 100 / fuelConsumption; // Пример расчета топливной эффективности (км на литр)
    }

    // Метод для отображения информации об автомобиле
    @Override
    public void displayInfo() {
        System.out.println("Car: " + brand + " " + model + ", Year: " + year + ", Doors: " + numberOfDoors);
    }
}

// Класс "Грузовик", наследуется от Vehicle и реализует интерфейсы FuelEfficiency и LoadCapacity
class Truck extends Vehicle implements FuelEfficiency, LoadCapacity {
    private double fuelConsumption; // Расход топлива (литры на 100 км)
    private double maxLoadCapacity; // Максимальная грузоподъемность (в кг)

    public Truck(String brand, String model, int year, double fuelConsumption, double maxLoadCapacity) {
        super(brand, model, year);  // Вызов конструктора родительского класса
        this.fuelConsumption = fuelConsumption;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    // Реализация метода из интерфейса FuelEfficiency
    @Override
    public double calculateFuelEfficiency() {
        return 100 / fuelConsumption; // Пример расчета топливной эффективности (км на литр)
    }

    // Реализация метода из интерфейса LoadCapacity
    @Override
    public double getMaxLoadCapacity() {
        return maxLoadCapacity; // Возвращает максимальную грузоподъемность
    }

    // Метод для отображения информации о грузовике
    @Override
    public void displayInfo() {
        System.out.println("Truck: " + brand + " " + model + ", Year: " + year + ", Max Load: " + maxLoadCapacity + " kg");
    }
}

// Основной класс для тестирования
public class Main {
    public static void main(String[] args) {
        // Создание объектов
        Car car = new Car("Toyota", "Corolla", 2020, 4, 6.5);
        Truck truck = new Truck("Volvo", "FH16", 2018, 20, 18000);

        // Отображение информации и расчетов
        car.displayInfo();
        System.out.println("Fuel Efficiency: " + car.calculateFuelEfficiency() + " km/l");

        truck.displayInfo();
        System.out.println("Fuel Efficiency: " + truck.calculateFuelEfficiency() + " km/l");
        System.out.println("Max Load Capacity: " + truck.getMaxLoadCapacity() + " kg");

        // Вывод количества транспортных средств
        System.out.println("Total Vehicles: " + Vehicle.getTotalVehicles());
    }
}
