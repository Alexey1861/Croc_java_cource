package ru.croc.cource.system;

import ru.croc.cource.system.support.Member;
import ru.croc.cource.system.support.Task;
import ru.croc.cource.system.support.exceptions.TaskIsAlreadyExistsException;
import ru.croc.cource.system.support.exceptions.TaskIsNotFoundException;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;


/**
 * Система управления задачами
 */
public class ManagementSystem {
    /** Объект файла с данными */
    private final File datasetFile;


    /**
     * Конструктор класса, создающий файл если его нет
     * @param filepath Путь к файлу
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public ManagementSystem(String filepath) throws IOException, ClassNotFoundException {
        this.datasetFile = new File(filepath);
        if (!this.datasetFile.exists()) {
            this.datasetFile.createNewFile();

            Map<Integer, Task> dataDict = new TreeMap<>();
            writeTasksMapToFile(dataDict);
        }
    }


    /**
     * Добавления новой задачи
     * @param newTask Новая задача
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws TaskIsAlreadyExistsException Выбрасывается исключение если задача уже существует
     */
    public void addTask(Task newTask) throws IOException, ClassNotFoundException, TaskIsAlreadyExistsException {
        Map<Integer, Task> dataMap = readTasksMapFromFile();
        int id = newTask.getId();
        if (dataMap.getOrDefault(id, null) == null) {
            dataMap.put(id, newTask);
            writeTasksMapToFile(dataMap);
        } else {
            throw new TaskIsAlreadyExistsException(String.format("Задача № %s уже существует", id));
        }
    }


    /**
     * Показать все задачи
     * @return Возвращается map с задачами
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Map<Integer, Task> getTasksMap() throws IOException, ClassNotFoundException {
        return readTasksMapFromFile();
    }


    /**
     * Редактирование названия задачи по id
     * @param id Номер задачи
     * @param newTitle Новое название
     * @throws IOException
     * @throws ClassNotFoundException Выбрасывается если задача не найдена
     * @throws TaskIsNotFoundException
     */
    public void editTheTasksTitle(int id, String newTitle) throws IOException, ClassNotFoundException, TaskIsNotFoundException {
        Map<Integer, Task> dataMap = readTasksMapFromFile();
        Task editedtask = dataMap.getOrDefault(id, null);
        if (editedtask != null) {
            editedtask.setTitle(newTitle);
            writeTasksMapToFile(dataMap);
        } else {
            throw new TaskIsNotFoundException(String.format("Задание № %s не найдено", id));
        }
    }


    /**
     * Редактирование описания задачи по id
     * @param id Номер задачи
     * @param newDescription Новое описание
     * @throws IOException
     * @throws ClassNotFoundException Выбрасывается если задача не найдена
     * @throws TaskIsNotFoundException
     */
    public void editTheTasksDescription(int id, String newDescription) throws IOException, ClassNotFoundException, TaskIsNotFoundException {
        Map<Integer, Task> dataMap = readTasksMapFromFile();
        Task editedtask = dataMap.getOrDefault(id, null);
        if (editedtask != null) {
            editedtask.setDescription(newDescription);
            writeTasksMapToFile(dataMap);
        } else {
            throw new TaskIsNotFoundException(String.format("Задание № %s не найдено", id));
        }
    }


    /**
     * Редактирование исполнителя задачи по id
     * @param id Номер задачи
     * @param newExecutor Новый исполнитель
     * @throws IOException
     * @throws ClassNotFoundException Выбрасывается если задача не найдена
     * @throws TaskIsNotFoundException
     */
    public void editTheTasksExecutor(int id, Member newExecutor) throws IOException, ClassNotFoundException, TaskIsNotFoundException {
        Map<Integer, Task> dataMap = readTasksMapFromFile();
        Task editedtask = dataMap.getOrDefault(id, null);
        if (editedtask != null) {
            editedtask.setExecutor(newExecutor);
            writeTasksMapToFile(dataMap);
        } else {
            throw new TaskIsNotFoundException(String.format("Задание № %s не найдено", id));
        }
    }


    /**
     * Редактирование статуса задачи по id
     * @param id Номер задачи
     * @param newStatus Новый статус
     * @throws IOException
     * @throws ClassNotFoundException Выбрасывается если задача не найдена
     * @throws TaskIsNotFoundException
     */
    public void editTheTasksStatus(int id, boolean newStatus) throws IOException, ClassNotFoundException, TaskIsNotFoundException {
        Map<Integer, Task> dataMap = readTasksMapFromFile();
        Task editedtask = dataMap.getOrDefault(id, null);
        if (editedtask != null) {
            editedtask.setStatus(newStatus);
            writeTasksMapToFile(dataMap);
        } else {
            throw new TaskIsNotFoundException(String.format("Задание № %s не найдено", id));
        }
    }


    /**
     * Удаление задачи по id
     * @param id Номер задачи
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws TaskIsNotFoundException Выбрасывается если задача не найдена
     */
    public void deleteTheTask(int id) throws IOException, ClassNotFoundException, TaskIsNotFoundException {
        Map<Integer, Task> dataMap = readTasksMapFromFile();
        Task deletedTask = dataMap.getOrDefault(id, null);
        if (deletedTask != null) {
            dataMap.remove(id);
            writeTasksMapToFile(dataMap);
        } else {
            throw new TaskIsNotFoundException(String.format("Задание № %s не найдено", id));
        }
    }


    /**
     * Вспомогательный метод, читающий колекцию с задачами из файла
     * @return Мап с задачами
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private Map<Integer, Task> readTasksMapFromFile() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.datasetFile))) {
            Map<Integer, Task> dataMap = (TreeMap<Integer, Task>) in.readObject();
            return dataMap;
        }
    }


    /**
     * Вспомогательный метод, записывающий колекцию с задачами в файл
     * @param dataMap Мап с задачами
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void writeTasksMapToFile(Map<Integer, Task> dataMap) throws IOException, ClassNotFoundException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.datasetFile))) {
            out.writeObject(dataMap);
        }
    }
}
