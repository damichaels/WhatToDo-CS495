package com.example.WhatToDo;

public class User {
    public String username;
    public String password;
    public String firstName;
    public String lastName;
    public String email;

    public User() {

    }

    public User(String username, String password, String firstName, String lastName, String email){
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
