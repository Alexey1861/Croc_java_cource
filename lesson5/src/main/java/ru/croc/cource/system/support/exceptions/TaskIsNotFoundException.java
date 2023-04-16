package ru.croc.cource.system.support.exceptions;

/**
 * Проверяемое исключение если задачи в системе не существует
 */
public class TaskIsNotFoundException extends Exception {
    public TaskIsNotFoundException(String title) {
        super(title);
    }
}
