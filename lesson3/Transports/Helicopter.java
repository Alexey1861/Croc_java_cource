package Transports;

/**
 * Реализация вертолёта
 */
public class Helicopter extends Transport{

    /**
     * Конструктор класса
     * @param id Номер вертолёта
     * @param brand Бренд вертолёта
     * @param model Модель вертолёта
     * @param color Цвет вертолёта
     */
    public Helicopter(int id, String brand, String model, String color) {
        super(id, brand, model, color);
    }

    /**
     * Реализация метода лететь для вертолёта
     */
    @Override
    public void ride() {
        System.out.println("Вертолёт летит");
    }

    /**
     * Переопределение метода toString
     * @return Строка с информацией о вертолёте
     */
    @Override
    public String toString() {
        return String.format(
                "Вертолёт (Номер: %s, Бренд: %s, Модель: %s, Цвет: %s)",
                this.id, this.brand, this.model, this.color
        );
    }
}
