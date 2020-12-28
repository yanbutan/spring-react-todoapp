package com.yanbu.toDoApp.api;

import com.yanbu.toDoApp.model.Person;
import com.yanbu.toDoApp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void registerUser(@RequestBody Person person){
        personService.registerUser(person);
    }

    @GetMapping
    public List<Person> getAllUsers(){
        return personService.getAllUsers();
    }
}
