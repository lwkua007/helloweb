package bsu.by.web.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;
    private String name;
    private boolean admin;


    public User(Integer id, String name, boolean admin) {
        this.id = id;
        this.name = name;
        this.admin = admin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
