package com.example.WhatToDo;

public class taskItem {
    private String mtaskName;
    private String mtaskValue;
    public taskItem(String Name, String Value){
        mtaskName=Name;
        mtaskValue=Value;
    }
    public void changeText(String text){
        mtaskName=text;
    }
    public String getText(){
        return mtaskName;
    }
    public String getText2(){
        return mtaskValue;
    }
}
