package ru.croc.cource.system.support.exceptions;

/**
 * Проверяемое исключение выбрасывемое если задача в системе уже существует
 */
public class TaskIsAlreadyExistsException extends Exception {
    public TaskIsAlreadyExistsException(String title) {
        super(title);
    }
}
