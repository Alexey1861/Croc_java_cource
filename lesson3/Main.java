import Transports.*;
import System.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Класс демонстрации работы программы
 */
public class Main {
    /**
     * Главный метод
     * @param args Системная информация
     */
    public static void main(String[] args) {
        demonstration();
    }

    /**
     * Демонстрация работы программы
     */
    private static void demonstration() {
        Car car1 = new Car(1, "BMW", "GLS", "black");
        Car car2 = new Car(2, "Kia", "Sportage", "white");

        AccountSystem system = new AccountSystem();

        system.registerNewTransport(car1, Category.AUTO);
        system.registerNewTransport(car2, Category.AUTO);

        system.getStatistics(
                new GregorianCalendar(2023, Calendar.APRIL, 15),
                new GregorianCalendar(2023, Calendar.APRIL, 17)
        );

        Transport rentedCar = system.toRent(
                1,
                new GregorianCalendar(2023, Calendar.APRIL, 18),
                new GregorianCalendar(2023, Calendar.APRIL, 20),
                "Aleksey"
        );

        system.getStatistics(
                new GregorianCalendar(2023, Calendar.APRIL, 15),
                new GregorianCalendar(2023, Calendar.APRIL, 19)
        );

        system.toAcceptRentedTransport(rentedCar);

        system.getStatistics(
                new GregorianCalendar(2023, Calendar.APRIL, 15),
                new GregorianCalendar(2023, Calendar.APRIL, 19)
        );
    }
}
