package com.yanbu.toDoApp.service;

import com.yanbu.toDoApp.exception.BadRequestException;
import com.yanbu.toDoApp.exception.ResourceNotFoundException;
import com.yanbu.toDoApp.model.Location;

public interface LocationServiceInt {

    Location findByTaskId(Integer taskId) throws ResourceNotFoundException;

    Integer addLocation(Location location) throws BadRequestException;

    void updateLocation(Integer locationId, Location location) throws BadRequestException;

    void removeLocation(Integer locationId) throws  ResourceNotFoundException;

}
