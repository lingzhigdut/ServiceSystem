package com.li.serveapplication.model;

public class User {

    private int id;
    private String name;
    private String phone;
    private String wechat;
    private int type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public User() {
    }

    public User(int id, String name, String phone, String wechat) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.wechat = wechat;
    }
}
