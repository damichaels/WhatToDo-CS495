package com.example.WhatToDo;

import java.io.Serializable;

public class User implements Serializable {
    public String uID;
    public String name;
    public String email;

    public User() {

    }

    public User(String uID, String name, String email){
        this.uID = uID;
        this.name = name;
        this.email = email;
    }

    public String getuID() {
        return uID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
