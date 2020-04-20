package com.example.WhatToDo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Group implements Serializable {
    private String gName;
    private String gID;
    private ArrayList<User> memberList;
    private int memberCount;

    public Group() {

    }

    public Group(String name, String ID) {
        gName = name;
        gID = ID;
        memberCount = 1;
    }
    public void setgName(String name) {
        gName = name;
    }
    public String getgName() {
        return gName;
    }
    public void setMemberCount(int i) {
        memberCount = i;
    }
    public int getMemberCount() {return memberCount;}

    public void addMember(User myUser) {
        memberList.add(myUser);
    }
}
