public class TruckService implements Serviceable<Truck> {
    @Override
    public void service(Truck truck) {
        System.out.println("Servicing truck: " + truck.brand + " " + truck.model);
    }
}