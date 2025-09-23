import factory.impl.RussianFactory;
import factory.impl.USAFactory;
import factory.interfaces.TransportFactory;
import transport.interfaces.Aircraft;
import transport.interfaces.Car;

public class Start {
    private static TransportFactory factory;

    public static void main(String[] args) {
        boolean useRussian = true;
        if (useRussian) {
            factory = new RussianFactory();
            System.out.println("== Russian Factory Selected ==");
        } else {
            factory = new USAFactory();
            System.out.println("== USA Factory Selected ==");
        }

        Car car = factory.createCar();
        Aircraft aircraft = factory.createAircraft();

        System.out.println("-- Car Actions --");
        car.drive();
        car.stop();

        System.out.println("-- Aircraft Actions --");
        try {
            aircraft.flight();
        } catch (UnsupportedOperationException e) {
            System.out.println("Aircraft flight is not implemented yet.");
        }
    }
}
