package System;

import java.util.GregorianCalendar;

/**
 * Класс-аренда транспорта
 */
class Rent {
    /** Дата начала аренды */
    private final GregorianCalendar beginDate;
    /** Дата конца аренды */
    private final GregorianCalendar endDate;
    /** Имя человека берущего в аренду */
    private final String person;

    /**
     * Конструктор класса
     * @param beginDate Дата начала аренды
     * @param endDate Дата конца аренды
     * @param person Имя человека берущего в аренду
     */
    public Rent(GregorianCalendar beginDate, GregorianCalendar endDate, String person) {
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.person = person;
    }

    /**
     * Геттер даты начала аренды
     * @return Дата начала аренды
     */
    public GregorianCalendar getBeginDate() {
        return this.beginDate;
    }

    /**
     * Геттер даты конца аренды
     * @return Дата конца аренды
     */
    public GregorianCalendar getEndDate() {
        return this.endDate;
    }

    /**
     * Геттер имени арендующего
     * @return Имя арендующего
     */
    public String getPerson() {
        return this.person;
    }
}
