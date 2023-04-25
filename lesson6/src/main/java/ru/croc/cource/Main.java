package ru.croc.cource;

import ru.croc.cource.read.XmlReader;
import ru.croc.cource.read.support.Projects;
import ru.croc.cource.write.XmlWriter;

import javax.xml.bind.JAXBException;
import java.io.File;

/**
 * Демонтрация работы программы
 */
public class Main {
    public static void main(String[] args) throws JAXBException {
        programDemonstration();
    }

    /**
     * Метод показывающий работу программы
     * @throws JAXBException
     */
    private static void programDemonstration() throws JAXBException {
        File inputFile = new File("old_data.xml");
        File outputFile = new File("new_data.xml");

        Projects projects = XmlReader.useReader().readXmlData(inputFile);
        XmlWriter.useWriter().writeXmlData(projects, outputFile);
    }
}
