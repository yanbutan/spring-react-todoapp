package com.yanbu.toDoApp.api;

import com.yanbu.toDoApp.Constants;
import com.yanbu.toDoApp.model.Person;
import com.yanbu.toDoApp.service.PersonService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> loginUser(@RequestBody Person person){
        Person fetchedPerson = personService.validateUser(person);
        Map<String, String> jwtTokenRes = generateJWTToken(fetchedPerson);
        return new ResponseEntity<>(jwtTokenRes, HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> registerUser(@RequestBody Person person){
        Person fetchedPerson = personService.registerUser(person);
        return new ResponseEntity<>(generateJWTToken(fetchedPerson), HttpStatus.OK);
    }

    @GetMapping
    public List<Person> getAllUsers(){
        return personService.getAllUsers();
    }

    private Map<String, String> generateJWTToken(Person person){
        long timestamp = System.currentTimeMillis();

        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SECRET_KEY)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp + Constants.TOKEN_VALIDITY))
                .claim("id", person.getId())
                .claim("name", person.getName())
                .claim("username", person.getUsername())
                .claim("email", person.getEmail())
                .compact();
        System.out.println("HELLOO : " + token);
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        return map;
    }
}
