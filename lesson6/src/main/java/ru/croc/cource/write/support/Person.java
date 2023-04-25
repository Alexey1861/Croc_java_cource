package ru.croc.cource.write.support;


import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
    @XmlElement
    private String name;
    @XmlElementWrapper(name = "projects")
    @XmlElement(name = "project")
    private List<Project> projectList;

    public Person(String name, List<Project> projectList) {
        this.name = name;
        this.projectList = projectList;
    }

    public Person () {}

    public void setName(String name) {
        this.name = name;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public String getName() {
        return name;
    }

    public List<Project> getProjectList() {
        return projectList;
    }
}
