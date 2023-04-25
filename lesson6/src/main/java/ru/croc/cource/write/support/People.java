package ru.croc.cource.write.support;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class People {
    @XmlElement(name = "person")
    private List<Person> personList;

    public People(List<Person> personList) {
        this.personList = personList;
    }

    public People() {}

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public List<Person> getPersonList() {
        return personList;
    }
}
