package com.chenzheng.event.bean;

import java.util.ArrayList;

/**
 * @author cz
 * @date 2021/4/17
 */
public class User {


    private int id;
    private String username;
    private String password;
    private Integer idealMoney;
    private int power;
    private String userClass;
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public void setUserClass(String userClass) { this.userClass = userClass; }
    public String getUserClass() { return userClass; }

    public String getUsername() { return username; }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdealMoney() {
        return idealMoney;
    }
    public void setIdealMoney(Integer idealMoney) {
        this.idealMoney = idealMoney;
    }

    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }


}
