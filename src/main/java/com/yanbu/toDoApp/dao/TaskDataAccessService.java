package com.yanbu.toDoApp.dao;

import com.yanbu.toDoApp.enums.Status;
import com.yanbu.toDoApp.enums.TaskType;
import com.yanbu.toDoApp.exception.BadRequestException;
import com.yanbu.toDoApp.exception.ResourceNotFoundException;
import com.yanbu.toDoApp.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Repository
public class TaskDataAccessService implements TaskDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TaskDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_CREATE = "INSERT INTO task (name, description, taskType, status, dateToComplete, userId)" +
            " VALUES (?,?,?::taskType,?::status,?,?)";
    private static final String SQL_FIND_BY_ID = "SELECT id, name, description, taskType, status, dateCreated, dateToComplete, dateCompleted FROM task WHERE id = ?";
    private static final String SQL_GET_ALL_BY_USERID = "SELECT * FROM task WHERE userId = ?";
    private static final String SQL_REMOVE = "DELETE FROM task WHERE id = ? and userId = ?";
    private static final String SQL_UPDATE = "UPDATE task SET name = ?, description = ?, taskType = ?::taskType, status = ?::status, dateCreated = ?, dateToComplete = ?, dateCompleted = ?" +
            " WHERE id = ? AND userId = ?";

    @Override
    public List<Task> findAll(Integer userId) throws ResourceNotFoundException {
        try {
            return jdbcTemplate.query(SQL_GET_ALL_BY_USERID, new Object[]{userId}, (resultSet, i) -> {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                TaskType taskType = TaskType.valueOf(resultSet.getString("taskType"));
                Timestamp dateCreated =resultSet.getTimestamp("dateCreated");
                Timestamp dateToComplete = resultSet.getTimestamp("dateToComplete");
                Timestamp dateCompleted = resultSet.getTimestamp("dateCompleted");
                Status status = Status.valueOf(resultSet.getString("status"));
                return new Task(id, name, description, taskType, status, dateCreated, dateToComplete, dateCompleted, userId);
            });
        } catch (Exception e){
            throw new ResourceNotFoundException("Resource not found " + e);
        }
    }

    @Override
    public Task findById(Integer userId, Integer taskId) throws ResourceNotFoundException, IllegalArgumentException {
        try{
            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{taskId}, (resultSet, i) -> {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                TaskType taskType = TaskType.valueOf(resultSet.getString("taskType"));
                Timestamp dateCreated =resultSet.getTimestamp("dateCreated");
                Timestamp dateToComplete = resultSet.getTimestamp("dateToComplete");
                Timestamp dateCompleted = resultSet.getTimestamp("dateCompleted");
                Status status = Status.valueOf(resultSet.getString("status"));
                return new Task(id, name, description, taskType, status, dateCreated, dateToComplete, dateCompleted, userId);
            });
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Illegal Arugment Exception");
        } catch (Exception e){
            throw new ResourceNotFoundException("Task not found : " + e);
        }
    }


    @Override
    public Integer create(Integer userId, String name, String description, String taskType, String dateCreated, String dateToComplete, String dateCompleted, String status) throws BadRequestException, ParseException {
        System.out.println("DATA PASSED " + userId + " " + name + " " + description);
        Date parsedDate;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            parsedDate = formatter.parse(dateToComplete);
        } catch (ParseException e){
            throw new ParseException("Invalid date time parse format", 1);
        }
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                Timestamp tempDateToComplete = new Timestamp((parsedDate.getTime()));
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, name);
                ps.setString(2, description);
                ps.setString(3, taskType == null ? "GENERIC": taskType);
                ps.setString(4, status == null ? "ONGOING": status);
                ps.setTimestamp(5, tempDateToComplete);
                ps.setInt(6, userId);
                return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("id");
        } catch (Exception e){
            throw new BadRequestException("Invalid Request : " + e );
        }
    }

    @Override
    public void update(Integer userId, Integer taskId, Task task) throws BadRequestException {
        try {
            jdbcTemplate.update(SQL_UPDATE, new Object[]{task.getName(), task.getDescription(), task.getTaskType().toString(), task.getStatus().toString(), task.getDateCreated(), task.getDateToComplete(), task.getDateCompleted(), taskId, userId});
        } catch (BadRequestException e){
            throw new BadRequestException("Bad request when updating " + e);
        }
    }

    @Override
    public void remove(Integer userId, Integer taskId) throws ResourceNotFoundException {
        jdbcTemplate.update(SQL_REMOVE, new Object[]{taskId, userId});
    }
}
