package com.yanbu.toDoApp.service;

import com.yanbu.toDoApp.dao.PersonDao;
import com.yanbu.toDoApp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int registerUser(Person person){
        return personDao.registerUser(person);
    }

    public List<Person> getAllUsers(){
        return personDao.selectAllUsers();
    }
}
