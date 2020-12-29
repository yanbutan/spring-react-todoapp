package com.yanbu.toDoApp.dao;

import com.yanbu.toDoApp.exception.BadRequestException;
import com.yanbu.toDoApp.exception.ResourceNotFoundException;
import com.yanbu.toDoApp.model.Task;

import java.util.List;

public interface TaskDao {

    List<Task> findAll(Integer userId) throws ResourceNotFoundException;

    Task findById(Integer userId, Integer taskId) throws ResourceNotFoundException;

    Integer create(Integer userId, String name, String description, String taskType, String dateCreated, String dateToComplete, String dateCompleted, String status) throws BadRequestException;

    void update(Integer userId, String name, String description, String taskType, String dateCreated, String dateToComplete, String dateCompleted, String status) throws  BadRequestException;

    void remove(Integer userId, Integer taskId) throws ResourceNotFoundException;
}
