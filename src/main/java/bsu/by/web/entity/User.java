package bsu.by.web.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;
    private String email;
    private boolean admin;


    public User(Integer id, String email, boolean admin) {
        this.id = id;
        this.email = email;
        this.admin = admin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
