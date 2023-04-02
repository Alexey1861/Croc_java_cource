package Transports;

/**
 * Реализация грузовика
 */
public class Truck extends Transport {
    /**
     * Конструктор класса
     * @param id Номер Грузовика
     * @param brand Бренд грузовика
     * @param model Иодель грузовика
     * @param color Цвет грузовика
     */
    public Truck(int id, String brand, String model, String color) {
        super(id, brand, model, color);
    }

    /**
     * реализация класса ехать для грузовика
     */
    @Override
    public void ride() {
        System.out.println("Грузовик едет");
    }

    /**
     * Переопределение метода toString
     * @return Строка с информацией о грузовике
     */
    @Override
    public String toString() {
        return String.format(
                "Грузовик (Номер: %s, Бренд: %s, Модель: %s, Цвет: %s)",
                this.id, this.brand, this.model, this.color
        );
    }
}
