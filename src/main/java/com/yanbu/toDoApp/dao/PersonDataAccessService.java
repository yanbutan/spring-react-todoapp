package com.yanbu.toDoApp.dao;

import com.yanbu.toDoApp.exception.AuthException;
import com.yanbu.toDoApp.model.Person;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer registerUser(Person person) throws AuthException{
        String hashedPassword = BCrypt.hashpw(person.getPassword(), BCrypt.gensalt(10));
        final String sql = "INSERT INTO person (name,username,email,password) VALUES (?, ?, ?, ?)";
        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, person.getName());
                ps.setString(2, person.getUsername());
                ps.setString(3, person.getEmail());
                ps.setString(4, hashedPassword);
                return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("id");
        } catch (Exception e){
            throw new AuthException("Invalid details. Failed to create account");
        }

    }

    @Override
    public Person validateUser(Person person) throws AuthException {
        String username = person.getUsername();
        String password = person.getPassword();
        if(username != null) username = username.toLowerCase();
        final String sql = "SELECT id, name, username, email, password FROM person WHERE username = ?";

        try {
            Person fetchedPerson = jdbcTemplate.queryForObject(sql, new Object[]{username}, (resultSet, i) -> {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String fetched_username = resultSet.getString("username");
                String fetched_password = resultSet.getString("password");
                return new Person(id, name, fetched_username, fetched_password, email);
            });

            if(!BCrypt.checkpw(password, fetchedPerson.getPassword())){
                throw new AuthException("Password does not match!");
            }

            return fetchedPerson;
        } catch (EmptyResultDataAccessException e){
            throw new AuthException("Invalid email/password");
        }


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

    @Override
    public Person findPersonById(Integer personId) {
        final String sql = "SELECT id, name, username, email, password FROM person WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{personId}, (resultSet, i) -> {
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            return new Person(id, name, username, password, email);
        });
    }

    @Override
    public Integer getCountByUsername(String username) {
        final String sql = "SELECT COUNT(*) FROM person WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{username}, Integer.class);
    }
}
