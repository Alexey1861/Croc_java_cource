package ru.croc.course.support;

/**
 * Класс описывающий сотрудника
 */
public class Employee {
    /** Уникальный идентификатор сотрудника */
    private Integer id;
    /** Имя сотрудника */
    private String name;
    /** руководитель сотрудника (если null, то данный сотрудник сам является руководителем) */
    private Employee manager;

    /**
     * Конструктор класса
     * @param id Уникальный идентификатор сотрудника
     * @param name Имя сотрудника
     * @param manager Руководитель сотрудника
     */
    public Employee(Integer id, String name, Employee manager) {
        this.id = id;
        this.name = name;
        this.manager = manager;
    }

    /**
     * Геттер уникального идентификатора сотрудника
     * @return Уникальный идентификатор
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Геттер имени сотрудника
     * @return Имя
     */
    public String getName() {
        return this.name;
    }

    /**
     * Геттер руководителя сотрудника
     * @return Руководитель
     */
    public Employee getManager() {
        return this.manager;
    }

    /**
     * Переопределение метода toString для Employee
     * @return Строка с информацией об объекте
     */
    @Override
    public String toString() {
        return String.format("Employee(id: %s, name: %s)", this.id, this.name);
    }
}
