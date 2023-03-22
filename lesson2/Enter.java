import java.util.Arrays;

/**
 * Класс въезда из парковки
 */
class Enter {
    /** Номер въезда */
    private int number;
    /** Описание въезда */
    private String description;
    /** Массив, содержащий машины, проехавшие через данный въезд */
    private Car[] carsMas = new Car[0];

    /**
     * Конструкор класса
     * @param number Номер въезда
     * @param description Описание въезда
     */
    public Enter(int number, String description) {
        this.number = number;
        this.description = description;
    }

    /**
     * Геттер массив машин, проехавших черех въезд
     * @return Массив машин, проехавших черех въезд
     */
    public Car[] getCarsList() {
        return this.carsMas;
    }

    /**
     * Метод "Использование въезда"
     * Используется в делегировании методами других классов для изменения состояния объекта
     * @param car Машина, использующая въезд
     */
    public void useTheEnter(Car car) {
        this.carsMas = append(this.carsMas, car);
    }

    /**
     * Вспомагательный метод, добавляющий новый элемент в массив
     * @param mas Массив
     * @param car Новый элемент
     * @return Новый массив
     */
    private Car[] append(Car[] mas, Car car) {
        Car[] newMas = Arrays.copyOf(mas, mas.length + 1);
        newMas[newMas.length - 1] = car;

        return newMas;
    }

    /**
     * Геттер номера въезда
     * @return Номер въезда
     */
    public int getNumber() {
        return this.number;
    }

}
