import java.util.Arrays;

/**
 * Класс выезда из парковки
 */
class Exit {
    /**Номер выезда*/
    private int number;
    /**Описание выезда*/
    private String description;
    /** Массив машин, проехавших через данный выезд */
    private Car[] carsMas = new Car[0];

    /**
     * Конструткор класса
     * @param number Номер выехда
     * @param description Описание выезда
     */
    public Exit(int number, String description) {
        this.number = number;
        this.description = description;
    }

    /**
     * Геттер массива машин, проехавших через данный выезд
     * @return Массив машин, проехавших через данный выезд
     */
    public Car[] getCarsList() {
        return this.carsMas;
    }

    /**
     * Метод "Использование выезда"
     * Используется в делегировании методами других классов для изменения состояния объекта
     * @param car Машина, использующая выезд
     */
    public void useTheExit(Car car) {
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
