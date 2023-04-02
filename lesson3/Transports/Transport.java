package Transports;

/**
 * Класс-шаблон, описывающий транспорт
 */
public abstract class Transport {
    /** Номер транспорта */
    protected int id;
    /** Бренд транспорта */
    protected String brand;
    /** Модель транспорта */
    protected String model;
    /** Цвет транспорта */
    protected String color;

    /**
     * Конструктор класса
     * @param id Номер транспорта
     * @param brand Бренд транспорта
     * @param model Модель транспорта
     * @param color Цвет транспорта
     */
    public Transport(int id, String brand, String model, String color) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    /**
     * Геттер номера транспорта
     * @return Номер транспорта
     */
    public int getId() {
        return this.id;
    }

    /**
     * Геттер бренда транспорта
     * @return Бренд транспорта
     */
    public String getBrand() {
        return this.brand;
    }

    /**
     * Геттер модели транспорта
     * @return Модель транспорта
     */
    public String getModel() {
        return this.model;
    }

    /**
     * Геттер цвета транспорта
     * @return Цвет транспорта
     */
    public String getColor() {
        return this.color;
    }

    /**
     * абстратный метод ехать
     */
    public abstract void ride();
}
