package com.li.serveapplication.model;

public class Project {
    private Integer id;

    private Integer type;

    private Integer idcustomer;

    private String introduction;

    private Integer taskcondition;

    private Integer idserver;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(Integer idcustomer) {
        this.idcustomer = idcustomer;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Integer getTaskcondition() {
        return taskcondition;
    }

    public void setTaskcondition(Integer taskcondition) {
        this.taskcondition = taskcondition;
    }

    public Integer getIdserver() {
        return idserver;
    }

    public void setIdserver(Integer idserver) {
        this.idserver = idserver;
    }
}
