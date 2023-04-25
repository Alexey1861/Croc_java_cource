package ru.croc.cource.read.support;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Projects {
    @XmlElement(name = "project")
    private List<Project> projectList;

    public Projects(List<Project> projectList) {
        this.projectList = projectList;
    }

    public Projects() {}

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }
}
