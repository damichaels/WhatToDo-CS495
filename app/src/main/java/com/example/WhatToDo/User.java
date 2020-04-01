package com.example.WhatToDo;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String uID;
    private String name;
    private String email;
    private ArrayList<Group> groupList;
    private int groupCount;

    public User() {

    }

    public User(String uID, String name, String email){
        this.uID = uID;
        this.name = name;
        this.email = email;
        groupCount = 0;
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

    public void addGroup(Group myGroup) {
        groupList.add(myGroup);
        groupCount++;
    }

    public int getGroupCount() {
        return groupCount;
    }
}
