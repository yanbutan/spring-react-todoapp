package com.yanbu.toDoApp.dao;

import com.yanbu.toDoApp.exception.BadRequestException;
import com.yanbu.toDoApp.exception.ResourceNotFoundException;
import com.yanbu.toDoApp.model.Location;
import com.yanbu.toDoApp.model.Task;

import java.text.ParseException;

public interface LocationDao {

    Location findByTaskId(Integer taskId) throws ResourceNotFoundException;

    Integer create(Location location) throws BadRequestException;

    void update(Integer locationId, Location location) throws BadRequestException;

    void remove(Integer locationId) throws  ResourceNotFoundException;
}
