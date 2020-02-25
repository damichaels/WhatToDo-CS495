package com.example.WhatToDo;

public class GroupName {
    private String mgroupName;

    public GroupName(String Name){
        mgroupName=Name;

    }
    public void changeText(String text){
        mgroupName=text;
    }
    public String getText(){
        return mgroupName;
    }
}
