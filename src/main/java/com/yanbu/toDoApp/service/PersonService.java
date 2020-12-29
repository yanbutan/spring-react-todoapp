package com.yanbu.toDoApp.service;

import com.yanbu.toDoApp.dao.PersonDao;
import com.yanbu.toDoApp.exception.AuthException;
import com.yanbu.toDoApp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class PersonService {
    private PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }

    public Person registerUser(Person person){
        Integer count = personDao.getCountByUsername(person.getUsername());
        if(count > 0) throw new AuthException("Username is already used.");

        Integer personId = personDao.registerUser(person);
        return personDao.findPersonById(personId);
    }

    public Person validateUser(Person person) { return personDao.validateUser(person); }

    public List<Person> getAllUsers(){
        return personDao.selectAllUsers();
    }
}
