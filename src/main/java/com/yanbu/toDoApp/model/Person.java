package com.yanbu.toDoApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

    private Integer id;
    private String name;
    private String username;
    private String password;
    private String email;
    private String profileImgPath;

    public Person() {
    }

    public Person(Integer id, String name, String username, String password, String email) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Person(String name, String username, String password, String email) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Person(String name,
                  String username,
                  String password,
                  String email,
                  String profileImgPath
                  ) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.profileImgPath = profileImgPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileImgPath() {
        return profileImgPath;
    }

    public void setProfileImgPath(String profileImgPath) {
        this.profileImgPath = profileImgPath;
    }
}
