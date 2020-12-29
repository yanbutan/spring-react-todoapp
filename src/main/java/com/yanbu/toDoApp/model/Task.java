package com.yanbu.toDoApp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yanbu.toDoApp.enums.Status;
import com.yanbu.toDoApp.enums.TaskType;

import java.time.LocalDateTime;

public class Task {
    private Integer id;
    private String name;
    private String description;
    private TaskType taskType;
    private Status status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateCreated;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateToComplete;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateCompleted;
    private Integer user_id;

    public Task(String name, Integer user_id) {
        this.name = name;
        this.user_id = user_id;
    }

    public Task(String name, String description, TaskType taskType, Status status, LocalDateTime dateCreated, LocalDateTime dateToComplete, Integer user_id) {
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

    public Task(Integer id, String name, String description, TaskType taskType, Status status, LocalDateTime dateCreated, LocalDateTime dateToComplete, LocalDateTime dateCompleted, Integer user_id) {
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

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateToComplete() {
        return dateToComplete;
    }

    public void setDateToComplete(LocalDateTime dateToComplete) {
        this.dateToComplete = dateToComplete;
    }

    public LocalDateTime getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(LocalDateTime dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }


}
