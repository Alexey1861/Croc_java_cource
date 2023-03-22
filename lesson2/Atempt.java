import java.time.LocalTime;

/**
 * Класс описывающий попытку
 */
class Attempt {
    /** Номер машины, которая совершает данную попытку */
    private int carNumber;
    /**Время совершения попытки*/
    private LocalTime time;

    /**
     * Конструктор класса
     * @param carNumber
     * @param time
     */
    public Attempt(int carNumber, LocalTime time) {
        this.carNumber = carNumber;
        this.time = time;
    }

    /**
     * Геттер номера машины
     * @return Номер машины
     */
    public int getCarNumber() {
        return this.carNumber;
    }

    /**
     * Геттер времени совершения попытки
     * @return Время совершения попытки
     */
    public LocalTime getTime() {
        return this.time;
    }
}
