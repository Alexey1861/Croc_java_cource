package Transports;

/**
 * Реализация моноколеса
 */
public class Monowheel extends Transport {
    /**
     * Конструктор класса
     * @param id Номер моноколеса
     * @param brand Бренд моноколеса
     * @param model Модель моноколеса
     * @param color Цыет моноколеса
     */
    public Monowheel(int id, String brand, String model, String color) {
        super(id, brand, model, color);
    }

    /**
     * Реализация метода ехать для моноколеса
     */
    @Override
    public void ride() {
        System.out.println("Моноколесо едет");
    }

    /**
     * Переопределение метода toString
     * @return Строка с информацией о моноколесе
     */
    @Override
    public String toString() {
        return String.format(
                "Моноколесо (Номер: %s, Бренд: %s, Модель: %s, Цвет: %s)",
                this.id, this.brand, this.model, this.color
        );
    }
}
