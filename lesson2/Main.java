public class Main {
    public static void main(String[] args) {
        // Создаётся порковка на 2 места с двумя въездами и даумя выездами
        Parking parking = new Parking(
                2,
                new Enter[]{new Enter(1, "first"), new Enter(2, "second")},
                new Exit[]{new Exit(1, "first"), new Exit(2, "second")}
        );

        // создаются три машины
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        Car car3 = new Car(3);

        System.out.println("Всего мест: " + parking.getFreePlaces());

        // первая машина заезжает на парковку
        car1.goToParking(parking, 1);
        System.out.println("Свободные места: " + parking.getFreePlaces());

        // вторая машина заезжает на пароквку
        car2.goToParking(parking, 2);
        System.out.println("Свободные места: " + parking.getFreePlaces());

        // третья машина пытается заехать, но мест нет
        car3.goToParking(parking, 1);
        System.out.println("Свободные места: " + parking.getFreePlaces());

        // вторая машина выезжает с парковки
        car2.leaveFromParking(2);
        System.out.println("Свободные места: " + parking.getFreePlaces());

        // третья машина заехала на парковку
        car3.goToParking(parking, 2);
        System.out.println("Свободные места: " + parking.getFreePlaces());
    }
}
