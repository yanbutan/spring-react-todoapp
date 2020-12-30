package com.yanbu.toDoApp.service;

import com.yanbu.toDoApp.exception.BadRequestException;
import com.yanbu.toDoApp.exception.ResourceNotFoundException;
import com.yanbu.toDoApp.model.Task;

import java.util.List;

public interface TaskServiceInt {
    List<Task> fetchAllTasks(Integer userId);

    Task fetchTaskById(Integer userId, Integer taskId) throws ResourceNotFoundException;

    Integer addTask(Integer userId, String name, String description, String taskType, String dateCreated, String dateToComplete, String dateCompleted, String status) throws BadRequestException;

    void updateTask(Integer userId, String name, String description, String taskType, String dateCreated, String dateToComplete, String dateCompleted, String status) throws  BadRequestException;

    void removeTask(Integer userId, Integer taskId) throws ResourceNotFoundException;
}
