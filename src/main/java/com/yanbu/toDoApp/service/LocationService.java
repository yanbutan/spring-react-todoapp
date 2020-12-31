package com.yanbu.toDoApp.service;

import com.yanbu.toDoApp.dao.LocationDao;
import com.yanbu.toDoApp.exception.BadRequestException;
import com.yanbu.toDoApp.exception.ResourceNotFoundException;
import com.yanbu.toDoApp.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LocationService implements  LocationServiceInt{

    @Autowired
    private LocationDao locationDao;

    @Override
    public Location findByTaskId(Integer taskId) throws ResourceNotFoundException {
        return locationDao.findByTaskId(taskId);
    }

    @Override
    public Integer addLocation(Location location) throws BadRequestException {
        return locationDao.create(location);
    }

    @Override
    public void updateLocation(Integer locationId, Location location) throws BadRequestException {
        locationDao.update(locationId, location);
    }

    @Override
    public void removeLocation(Integer locationId) throws ResourceNotFoundException {
        locationDao.remove(locationId);
    }
}
