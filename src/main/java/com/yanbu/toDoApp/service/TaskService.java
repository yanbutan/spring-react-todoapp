package com.yanbu.toDoApp.service;

import com.yanbu.toDoApp.dao.TaskDao;
import com.yanbu.toDoApp.exception.BadRequestException;
import com.yanbu.toDoApp.exception.ResourceNotFoundException;
import com.yanbu.toDoApp.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskService implements TaskServiceInt {

    @Autowired
    private TaskDao taskDao;

    @Override
    public List<Task> fetchAllTasks(Integer userId) {
        return null;
    }

    @Override
    public Task fetchTaskById(Integer userId, Integer taskId) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public Task addTask(Integer userId, String name, String description, String taskType, String dateCreated, String dateToComplete, String dateCompleted, String status) throws BadRequestException {
        int taskId = taskDao.create(userId, name, description, taskType, dateCreated, dateToComplete, dateCompleted, status);
        return taskDao.findById(userId, taskId);
    }

    @Override
    public void updateTask(Integer userId, String name, String description, String taskType, String dateCreated, String dateToComplete, String dateCompleted, String status) throws BadRequestException {

    }

    @Override
    public void removeTask(Integer userId, Integer taskId) throws ResourceNotFoundException {

    }
}
