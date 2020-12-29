package com.yanbu.toDoApp.dao;

import com.yanbu.toDoApp.exception.AuthException;
import com.yanbu.toDoApp.model.Person;

import java.util.List;

public interface PersonDao {
    Integer registerUser(Person person) throws AuthException;
    List<Person> selectAllUsers();
    Person validateUser(Person person);
    Person findPersonById(Integer personId);
    Integer getCountByUsername(String username);
}
