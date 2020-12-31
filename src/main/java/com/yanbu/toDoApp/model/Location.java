package com.yanbu.toDoApp.model;

public class Location {
    private Integer id;
    private String name;
    private String address;
    private Integer postalCode;

    private Integer taskId;

    public Location() {
    }

    public Location(String name, String address, Integer postalCode, Integer taskId) {
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.taskId = taskId;
    }

    public Location(Integer id, String name, String address, Integer postalCode, Integer taskId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.taskId = taskId;
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

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }
}
