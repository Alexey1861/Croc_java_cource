/**
 * Класс описывающий машину
 */
public class Car {
    /** Номер машины */
    private int number;
    /**Парковка, на которой на данный момент находится машина*/
    private Parking currentParking = null;

    /**
     * Констуктор класса
     * @param number Номер машины
     */
    public Car(int number) {
        this.number = number;
    }

    /**
     * Метод заезда на парковку
     * @param parking Парковка, на которую машина будет заезжать
     * @param enterNumber Номер въезда
     */
    public void goToParking(Parking parking, int enterNumber) {
        if (this.currentParking == null) {
            int testNumber = parking.toAccept(this, enterNumber);
            if (testNumber == 1) {
                this.currentParking = parking;

                String message = String.format("Машина #%s успешно припарковалась", this.number);
                System.out.println(message);
            } else if (testNumber == 2) {
                String message = String.format("Ошибка: Машина #%s не заехала (въезда №%s не существует)", this.number, enterNumber);
                System.out.println(message);
            } else if (testNumber == 3) {
                String message = String.format("Ошибка: Машина #%s не заехала (мест нет)", this.number);
                System.out.println(message);
            }
        } else {
            System.out.println("Ошибка: машина уже припаркована");
        }
    }

    /**
     * Метод выезда из парковки
     * @param exitNumber Номер выезда
     */
    public void leaveFromParking(int exitNumber) {
        if (this.currentParking != null) {
            if (currentParking.toRelease(this, exitNumber)) {
                currentParking = null;

                String message = String.format("Машина №%s покинула парковку", this.number);
                System.out.println(message);
            } else {
                System.out.println("Ошибка: данного выезда не существует");
            }
        } else {
            String message = String.format("Ошибка: Машина №%s уже покинула парковку", this.number);
            System.out.println(message);
        }
    }

    /**
     * Геттер номера машины
     * @return Номер машины
     */
    public int getNumber() {
        return this.number;
    }
}
