package com.yanbu.toDoApp.dao;

import com.yanbu.toDoApp.model.Person;

import java.util.List;

public interface PersonDao {
    int registerUser(Person person);
    List<Person> selectAllUsers();
}
