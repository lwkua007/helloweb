package bsu.by.web.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Integer isAdmin;
    private String email;
    private String password;

    public User(Integer isAdmin, String email, String password) {
        this.isAdmin = isAdmin;
        this.email = email;
        this.password = password;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
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
}
