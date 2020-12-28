package com.yanbu.toDoApp.model;

public class Location {
    private Integer id;
    private String name;
    private String address;
    private Integer postalCode;
    private Integer task_id;

    public Location(String name, String address, Integer postalCode, Integer task_id) {
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.task_id = task_id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getTask_id() {
        return task_id;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }
}
