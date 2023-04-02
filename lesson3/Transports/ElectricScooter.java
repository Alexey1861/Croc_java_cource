package Transports;

/**
 * Реализация электросамоката
 */
public class ElectricScooter extends Transport {
    /**
     * Констуктор класса
     * @param id Номер электросамоката
     * @param brand Бренд самоката
     * @param model Модель самоката
     * @param color Цвет самоката
     */
    public ElectricScooter(int id, String brand, String model, String color) {
        super(id, brand, model, color);
    }

    /**
     * Реализация метода ехать у электросамоката
     */
    @Override
    public void ride() {
        System.out.println("Электросамокат едет");
    }

    /**
     * Переопределения метода toString
     * @return Строка с информацией об электросамокате
     */
    @Override
    public String toString() {
        return String.format(
                "Электросамокат (Номер: %s, Бренд: %s, Модель: %s, Цвет: %s)",
                this.id, this.brand, this.model, this.color
        );
    }
}
