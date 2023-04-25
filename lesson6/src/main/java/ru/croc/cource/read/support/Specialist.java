package ru.croc.cource.read.support;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Specialist {
    @XmlAttribute
    private String name;

    public Specialist(String name) {
        this.name = name;
    }

    public Specialist() {}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
