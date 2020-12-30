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

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
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

    private static final String SQL_CREATE = "INSERT INTO task (name, description, userId, dateToComplete)" +
            " VALUES (?,?,?,?)";
    private static final String SQL_FIND_BY_ID = "SELECT id, name, description FROM task WHERE id = ?";

    @Override
    public List<Task> findAll(Integer userId) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public Task findById(Integer userId, Integer taskId) throws ResourceNotFoundException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try{
            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{taskId}, (resultSet, i) -> {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                TaskType taskType = TaskType.valueOf(resultSet.getString("taskType"));
//                LocalDateTime dateCreated = LocalDateTime.parse(resultSet.getString("dateCreated"), formatter);
//                LocalDateTime dateToComplete = LocalDateTime.parse(resultSet.getString("dateToComplete"), formatter);
//                LocalDateTime dateCompleted = LocalDateTime.parse(resultSet.getString("dateCompleted"), formatter);
                Status status = Status.valueOf(resultSet.getString("status"));
                return new Task(id, name, description, userId);
            });
        } catch (Exception e){
            throw new ResourceNotFoundException("Task not found");
        }
    }


    @Override
    public Integer create(Integer userId, String name, String description, String taskType, String dateCreated, String dateToComplete, String dateCompleted, String status) throws BadRequestException {
        System.out.println("DATA PASSED " + userId + " " + name + " " + description);
        Date parsedDate;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            parsedDate = formatter.parse(dateToComplete);
        } catch (ParseException e){
            System.out.println(("Exception " + e ));
            return null;
        }
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                Timestamp tempDateToComplete = new Timestamp((parsedDate.getTime()));
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, name);
                ps.setString(2, description);
                ps.setInt(3, userId);
//                ps.setString(4, taskType);
//                ps.setString(5, status);
//                ps.setString(6, dateCreated);
                ps.setTimestamp(4, tempDateToComplete);
//                ps.setString(8, dateCompleted);
                return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("id");
        } catch (Exception e){
            throw new BadRequestException("Invalid Request");
        }
    }

    @Override
    public void update(Integer userId, String name, String description, String taskType, String dateCreated, String dateToComplete, String dateCompleted, String status) throws BadRequestException {

    }

    @Override
    public void remove(Integer userId, Integer taskId) throws ResourceNotFoundException {

    }
}
