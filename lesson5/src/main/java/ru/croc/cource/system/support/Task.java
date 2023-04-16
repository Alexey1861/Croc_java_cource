package ru.croc.cource.system.support;

import java.io.Serializable;

/**
 * Задача
 */
public class Task implements Serializable, Comparable<Task> {
    /** Номер */
    private final int id;
    /** Название */
    private String title;
    /** Описание */
    private String description;
    /** Исполнитель */
    private Member executor;
    /** Статус выполнения */
    private boolean status;

    /**
     * Констуктор класса
     * @param id Номер задачи
     * @param title Название задачи
     * @param description Описание задачт
     * @param executor Исполнитель задачи
     * @param status Статус выполнения задачи
     */
    public Task(int id, String title, String description, Member executor, boolean status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.executor = executor;
        this.status = status;
    }


    /**
     * Метод-сравнения задачи по номеру
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Task o) {
        return this.id - o.id;
    }



    public void setTitle(String title) {
        this.title = title;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public void setExecutor(Member executor) {
        this.executor = executor;
    }


    public void setStatus(boolean status) {
        this.status = status;
    }


    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }


    public String getDescription() {
        return description;
    }


    public Member getExecutor() {
        return executor;
    }


    public boolean getStatus() {
        return status;
    }


    @Override
    public String toString() {
        return String.format("Task(%s, %s, %s, %s, %s)", id, title, description, executor, status);
    }
}
