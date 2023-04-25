package ru.croc.cource.write.support;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Project {
    @XmlAttribute
    private String title;
    @XmlElement
    private String role;
    @XmlElement
    private String manager;

    public Project(String title, String role, String manager) {
        this.title = title;
        this.role = role;
        this.manager = manager;
    }

    public Project() {}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getTitle() {
        return title;
    }

    public String getRole() {
        return role;
    }

    public String getManager() {
        return manager;
    }
}
