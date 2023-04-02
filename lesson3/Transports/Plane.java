package Transports;

/**
 * Реализация самолёта
 */
public class Plane extends Transport {
    /**
     * Конструктор класса
     * @param id Номер самолёта
     * @param brand Бренд самолёта
     * @param model Модель самолёта
     * @param color Цвет самолёта
     */
    public Plane(int id, String brand, String model, String color) {
        super(id, brand, model, color);
    }

    /**
     * Реализация метода ехать лететь для самолёта
     */
    @Override
    public void ride() {
        System.out.println("Самолёт летит");
    }

    /**
     * Переопределение метода toString
     * @return Строка с информацией о самолёте
     */
    @Override
    public String toString() {
        return String.format(
                "Самолёт (Номер: %s, Бренд: %s, Модель: %s, Цвет: %s)",
                this.id, this.brand, this.model, this.color
        );
    }
}
