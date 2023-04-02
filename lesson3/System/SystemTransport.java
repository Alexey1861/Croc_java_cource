package System;

import Transports.Transport;

import java.util.GregorianCalendar;

/**
 * Сущность, хранящая мета информацию о транспорте в системе учёта
 */
class SystemTransport {
    /** Статическое поле, генерирующее для каждого нового тс уникальный id */
    private static int number = 0;
    /** Уникальный id тс, хранящийся в системе */
    private final int id;
    /** Сам транспорт */
    private final Transport transport;
    /** Информация об аренде тс */
    private Rent rent;
    /** Флажок исправности тс */
    private boolean isServiceable;
    /** Категория тс */
    private final Category category;

    /**
     * Констурктор класса
     * @param transport Траноспорт
     * @param category Категория
     */
    public SystemTransport(Transport transport, Category category) {
        number++;

        this.id = number;
        this.transport = transport;
        this.isServiceable = true;
        this.category = category;
    }

    /**
     * Геттер id траноспорта в системе
     * @return id транспорта
     */
    public int getId() {
        return this.id;
    }

    /**
     * Геттер самого транспорта
     * @return Транспорт
     */
    public Transport getTransport() {
        return this.transport;
    }

    /**
     * Геттер информации об аренде
     * @return Информация об аренде
     */
    public Rent getRent() {
        return this.rent;
    }

    /**
     * Геттер состояния транспорта
     * @return Состояние транспорта
     */
    public boolean getIsServiceable() {
        return this.isServiceable;
    }

    /**
     * Геттер категории
     * @return Категория
     */
    public Category getCategory() {
        return this.category;
    }

    /**
     * Сеттер инофрмации об аренде
     * @param beginDate Дата начала аренды
     * @param endDate Дата конца аренды
     * @param person Имя арендующего
     */
    public void setRent(GregorianCalendar beginDate, GregorianCalendar endDate, String person) {
        this.rent = new Rent(beginDate, endDate, person);
    }

    /**
     * Сеттер, обнуляюзий инофрмкцию об аренде
     */
    public void setRentByNull() {
        this.rent = null;
    }

    /**
     * Сеттер состояния транспорта
     * @param isServiceable Состояние транспорта
     */
    public void setIsServiceable(boolean isServiceable) {
        this.isServiceable = isServiceable;
    }
}
