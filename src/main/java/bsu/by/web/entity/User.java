package bsu.by.web.entity;

import java.io.Serializable;

public class User implements Serializable {
    private String email;
    private String password;
    private Integer isAdmin;

    public User(String email, String password, Integer isAdmin) {
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer isAdmin() {
        return isAdmin;
    }

    public void setAdmin(Integer admin) {
        isAdmin = admin;
    }
}
