package Transports;

/**
 * Реализация автомобиля
 */
public class Car extends Transport{
    /**
     * Констурктор класса
     * @param id номер автомбиля
     * @param brand Бренд автомобиля
     * @param model Модель автмобиля
     * @param color Цвет автомобиля
     */
    public Car(int id, String brand, String model, String color) {
        super(id, brand, model, color);
    }

    /**
     * Реализауия метода ехать у автомобиля
     */
    @Override
    public void ride() {
        System.out.println("Машина едет");
    }

    /**
     * Переопределение метода toString
     * @return Строка с информацией об объекте
     */
    @Override
    public String toString() {
        return String.format(
                "Автомобиль (Номер: %s, Бренд: %s, Модель: %s, Цвет: %s)",
                this.id, this.brand, this.model, this.color
        );
    }
}
