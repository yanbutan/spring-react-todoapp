package com.yanbu.toDoApp.dao;

import com.yanbu.toDoApp.exception.BadRequestException;
import com.yanbu.toDoApp.exception.ResourceNotFoundException;
import com.yanbu.toDoApp.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class LocationDataAccessService implements LocationDao{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LocationDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_FIND_BY_ID = "SELECT id, name, address, postalCode FROM location WHERE taskId = ?";
    private static final String SQL_CREATE = "INSERT INTO location (name, address, postalCode, taskId) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE location SET name = ?, address = ?, postalCode = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM location WHERE id = ?";
    @Override
    public Location findByTaskId(Integer taskId) throws ResourceNotFoundException {
        try {
            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{taskId}, (resultSet, i) -> {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                Integer postalCode = resultSet.getInt("postalCode");

                return new Location(id, name, address, postalCode, taskId);
            });
        } catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException("Location is not found error : " + e);
        }
    }

    @Override
    public Integer create(Location location) throws BadRequestException {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, location.getName());
                ps.setString(2, location.getAddress());
                ps.setInt(3, location.getPostalCode());
                ps.setInt(4, location.getTaskId());
                return ps;
            },keyHolder);
            return (Integer) keyHolder.getKeys().get("id");
        } catch (BadRequestException e){
            throw new BadRequestException("Bad request exception : " + e);
        }

    }

    @Override
    public void update(Integer locationId, Location location) throws BadRequestException {
        try{
            jdbcTemplate.update(SQL_UPDATE, new Object[]{location.getName(),location.getAddress(), location.getPostalCode(), locationId});
        } catch (BadRequestException e){
            throw new BadRequestException("Bad request exception : " + e);
        }
    }

    @Override
    public void remove(Integer locationId) throws ResourceNotFoundException {
        jdbcTemplate.update(SQL_DELETE, new Object[]{locationId});
    }
}
