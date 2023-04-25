package ru.croc.cource.write;

import ru.croc.cource.read.support.Projects;
import ru.croc.cource.write.support.People;
import ru.croc.cource.write.support.Person;
import ru.croc.cource.write.support.Project;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Класс синглтон записывающий xml данные в файл
 */
public class XmlWriter {
    /** Экземпляр класса */
    private static final XmlWriter write = new XmlWriter();

    /**
     * Приватный конструктор
     */
    private XmlWriter() {}

    /**
     * Метод записывающий данные в файл
     * @param projects Объект с данными
     * @param file xml файл
     * @throws JAXBException
     */
    public void writeXmlData(Projects projects, File file) throws JAXBException {
        Map<String, Person> personMap = new TreeMap<>();
        getManagersIntoPersons(projects, personMap);
        getSpecialistsIntoPersons(projects, personMap);

        List<Person> personList = new ArrayList<>();
        convertMapsValuesToList(personMap, personList);

        People people = new People(personList);
        writeDataToFile(people, file);
    }

    /**
     * Метод находит данные о менеджерах и преоьразует из в Person и сохраняет в словарб
     * @param projects Объект с данными
     * @param personMap Словарь сохраняющий данные
     */
    private void getManagersIntoPersons(Projects projects, Map<String, Person> personMap) {
        var projectList = projects.getProjectList();

        for (var project : projectList) {
            String projectTitle = project.getTitle();
            var managerList = project.getManagerList();

            for (var manager : managerList) {
                String name = manager.getName();

                Person person = personMap.get(name);
                if (person == null) {
                    Person newPerson = new Person(name, new ArrayList<>());
                    newPerson.getProjectList().add(new Project(projectTitle, "Менеджер" , ""));
                    personMap.put(name, newPerson);
                } else {
                    person.getProjectList().add(new Project(projectTitle, "Менеджер", ""));
                }
            }
        }
    }

    /**
     * Метод находит данные о специалистах и преоьразует из в Person и сохраняет в словарб
     * @param projects Объект с данными
     * @param personMap Словарь сохраняющий данные
     */
    private void getSpecialistsIntoPersons(Projects projects, Map<String, Person> personMap) {
        var projectList = projects.getProjectList();

        for (var project : projectList) {
            String projectTitle = project.getTitle();
            for (var manager : project.getManagerList()) {
                String managerName = manager.getName();
                for (var specialist : manager.getSpecialistList()) {
                    String name = specialist.getName();

                    Person person = personMap.get(name);
                    if (person == null) {
                        Person newPerson = new Person(name, new ArrayList<>());
                        newPerson.getProjectList().add(new Project(projectTitle, "Специалист", managerName));
                        personMap.put(name, newPerson);
                    } else {
                        person.getProjectList().add(new Project(projectTitle, "Специалист", managerName));
                    }
                }
            }
        }
    }

    /**
     * Метод преобразует значения из словаря в список
     * @param personMap Словарь с данными
     * @param personList Список в котрый он будет преобразован
     */
    private void convertMapsValuesToList(Map<String, Person> personMap, List<Person> personList) {
        for (var element : personMap.entrySet()) {
            var val = element.getValue();
            personList.add(val);
        }
    }

    /**
     * Непосредственная запись в файл
     * @param people ОбЪект с данными
     * @param file xml-файл
     * @throws JAXBException
     */
    private void writeDataToFile(People people, File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(People.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(people, file);
    }

    /**
     * Геттер экземпляра класса
     * @return Экземпляр класса
     */
    public static XmlWriter useWriter() {
        return write;
    }
}
