package com.example.WhatToDo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Group implements Serializable {
    private String gName;
    private String gID;
    private ArrayList<User> memberList;

    public Group() {

    }

    public Group(String name, String ID) {
        gName = name;
        gID = ID;
    }
    public void setgName(String name) {
        gName = name;
    }
    public String getgName() {
        return gName;
    }

    public void addMember(User myUser) {
        memberList.add(myUser);
    }
}
