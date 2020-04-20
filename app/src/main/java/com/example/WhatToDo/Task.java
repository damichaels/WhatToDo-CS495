package com.example.WhatToDo;

public class Task implements serializable{
    private String tName;
    private String tPoints;

    public Task() {

    }

    public Task(String name, String points) {
        tName = name;
        tPoints = points;
    }
    public String gettName() {
        return tName;
    }

    public String gettPoints() {
        return tPoints;
    }
}
