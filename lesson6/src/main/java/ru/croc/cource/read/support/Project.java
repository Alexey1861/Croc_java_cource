package ru.croc.cource.read.support;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Project {
    @XmlElement
    private String title;
    @XmlElement
    private String description;
    @XmlElementWrapper(name = "managers")
    @XmlElement(name = "manager")
    private List<Manager> managerList;

    public Project(String title, String description, List<Manager> managerList) {
        this.title = title;
        this.description = description;
        this.managerList = managerList;
    }

    public Project() {}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setManagerList(List<Manager> managerList) {
        this.managerList = managerList;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Manager> getManagerList() {
        return managerList;
    }
}
