package com.yanbu.toDoApp.dao;

import com.yanbu.toDoApp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static List<Person> DB = new ArrayList<>();
    @Override
    public int registerUser(Person person) {
        return jdbcTemplate.update("INSERT INTO person (name,username,email,password) VALUES (?, ?, ?, ?)", person.getName(), person.getUsername(), person.getEmail(), person.getPassword());
    }

    @Override
    public List<Person> selectAllUsers() {
        final String sql = "SELECT id, name, email, username, password FROM person";
        List<Person> users = jdbcTemplate.query(sql, ((resultSet, i) -> {
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            return new Person(id, name, username, password, email);
        }));
        return users;
    }
}
