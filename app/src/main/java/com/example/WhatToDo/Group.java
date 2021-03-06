package com.example.WhatToDo;

import java.io.Serializable;

public class Group implements Serializable {
    private String gName;
    private String gID;
    private String gCode;
   // private ArrayList<User> memberList;
    private int memberCount;
    private int taskCount;

    public Group() {

    }

    public Group(String name, String ID) {
        gName = name;
        gID = ID;
        memberCount = 1;
        gCode = gID.substring(gID.length() - 5);
        taskCount = 0;
    }
    public void setgName(String name) {
        gName = name;
    }
    public String getgName() {
        return gName;
    }

    public int getTaskCount() {
        return taskCount;
    }
    public void setTaskCount(int i) {
        taskCount++;
    }
    public String getgID() {
        return gID;
    }
    public String getgCode() {
        return gCode;
    }

    public void setMemberCount(int i) {memberCount = i;}
    public int getMemberCount() {return memberCount;}

   // public void addMember(User myUser) {
  //      memberList.add(myUser);
  //  }
}
