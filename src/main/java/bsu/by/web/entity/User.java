package bsu.by.web.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Integer userId;
    private Integer isAdmin;
    private String email;
    private String password;
    private Integer state;
    private Double balance;
    private Integer image_count;



    public User(Integer userId, Integer isAdmin, String email, String password, Integer state, Double balance, Integer image_count) {
        this.userId = userId;
        this.isAdmin = isAdmin;
        this.email = email;
        this.password = password;
        this.state = state;
        this.balance = balance;
        this.image_count = image_count;
    }

    public User(Integer isAdmin, String email, String password, Integer state, Double balance) {
        this.isAdmin = isAdmin;
        this.email = email;
        this.password = password;
        this.state = state;
        this.balance = balance;
    }

    public User(Integer userId, Integer isAdmin, String email, String password, Integer state, Double balance) {
        this.userId = userId;
        this.isAdmin = isAdmin;
        this.email = email;
        this.password = password;
        this.state = state;
        this.balance = balance;
    }


    public User(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getImage_count() {
        return image_count;
    }

    public void setImage_count(Integer image_count) {
        this.image_count = image_count;
    }
}
