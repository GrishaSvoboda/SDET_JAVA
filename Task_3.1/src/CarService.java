public class CarService implements Serviceable<Car> {
    @Override
    public void service(Car car) {
        System.out.println("Servicing car: " + car.brand + " " + car.model);
    }
}