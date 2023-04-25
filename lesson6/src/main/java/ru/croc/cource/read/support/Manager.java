package ru.croc.cource.read.support;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Manager {
    @XmlAttribute
    private String name;
    @XmlElementWrapper(name = "specialists")
    @XmlElement(name = "specialist")
    private List<Specialist> specialistList;

    public Manager(String name, List<Specialist> specialistList) {
        this.name = name;
        this.specialistList = specialistList;
    }

    public Manager() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialistList(List<Specialist> specialistList) {
        this.specialistList = specialistList;
    }

    public String getName() {
        return name;
    }

    public List<Specialist> getSpecialistList() {
        return specialistList;
    }
}
