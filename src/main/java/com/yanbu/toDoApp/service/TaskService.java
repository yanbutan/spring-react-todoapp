package com.yanbu.toDoApp.service;

import com.yanbu.toDoApp.dao.TaskDao;
import com.yanbu.toDoApp.exception.BadRequestException;
import com.yanbu.toDoApp.exception.ResourceNotFoundException;
import com.yanbu.toDoApp.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

@Service
@Transactional
public class TaskService implements TaskServiceInt {

    @Autowired
    private TaskDao taskDao;

    @Override
    public List<Task> fetchAllTasks(Integer userId) {
        return taskDao.findAll(userId);
    }

    @Override
    public Task fetchTaskById(Integer userId, Integer taskId) throws ResourceNotFoundException {
        return taskDao.findById(userId, taskId);
    }

    @Override
    public Integer addTask(Integer userId, String name, String description, String taskType, String dateCreated, String dateToComplete, String dateCompleted, String status) throws BadRequestException, ParseException {
        return taskDao.create(userId, name, description, taskType, dateCreated, dateToComplete, dateCompleted, status);
    }

    @Override
    public void updateTask(Integer userId, Integer taskId, Task task) throws BadRequestException {
        taskDao.update(userId, taskId, task);
    }

    @Override
    public void removeTask(Integer userId, Integer taskId) throws ResourceNotFoundException {
        taskDao.remove(userId, taskId);
    }
}
