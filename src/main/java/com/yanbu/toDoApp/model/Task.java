package com.yanbu.toDoApp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yanbu.toDoApp.enums.Status;
import com.yanbu.toDoApp.enums.TaskType;

import java.sql.Timestamp;

public class Task {
    private Integer id;
    private String name;
    private String description;
    private TaskType taskType;
    private Status status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp dateCreated;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp dateToComplete;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp dateCompleted;
    private Integer user_id;

    public Task(String name, Integer user_id) {
        this.name = name;
        this.user_id = user_id;
    }

    public Task(Integer id, String name, String description, Status status, Timestamp dateCreated, Timestamp dateToComplete, Timestamp dateCompleted, Integer user_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.dateCreated = dateCreated;
        this.dateToComplete = dateToComplete;
        this.dateCompleted = dateCompleted;
        this.user_id = user_id;
    }

    public Task(String name, String description, TaskType taskType, Status status, Timestamp dateCreated, Timestamp dateToComplete, Integer user_id) {
        this.name = name;
        this.description = description;
        this.taskType = taskType;
        this.status = status;
        this.dateCreated = dateCreated;
        this.dateToComplete = dateToComplete;
        this.user_id = user_id;
    }

    public Task(Integer id, String name, String description, Integer user_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.user_id = user_id;
    }

    public Task(Integer id, String name, String description, TaskType taskType, Status status, Timestamp dateCreated, Timestamp dateToComplete, Timestamp dateCompleted, Integer user_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.taskType = taskType;
        this.status = status;
        this.dateCreated = dateCreated;
        this.dateToComplete = dateToComplete;
        this.dateCompleted = dateCompleted;
        this.user_id = user_id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Timestamp getDateToComplete() {
        return dateToComplete;
    }

    public void setDateToComplete(Timestamp dateToComplete) {
        this.dateToComplete = dateToComplete;
    }

    public Timestamp getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(Timestamp dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }


}
