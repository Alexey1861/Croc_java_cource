package ru.croc.cource.read;

import ru.croc.cource.read.support.Projects;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Класс-синглтон, считывающий xml из файла
 */
public class XmlReader {
    /** Экземпляр класса */
    private static final XmlReader read = new XmlReader();

    /**
     * Приватный контруктор
     */
    private XmlReader() {}

    /**
     * Метод считыание данные из фалйа
     * @param dataFile xml файл
     * @return Объект с дессериализованными данными
     * @throws JAXBException
     */
    public Projects readXmlData(File dataFile) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Projects.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        return (Projects) unmarshaller.unmarshal(dataFile);
    }

    /**
     * Геттер экземпляра класса
     * @return Экземпляр класса
     */
    public static XmlReader useReader() {
        return read;
    }
}
