package com.example.WhatToDo;
import java.io.Serializable;

public class Task implements Serializable{
    private String tName;
    private String tPoints;
    private boolean done;

    public Task() {

    }

    public Task(String name, String points) {
        tName = name;
        tPoints = points;
        done = false;
    }
    public String gettName() {
        return tName;
    }

    public String gettPoints() {
        return tPoints;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone (boolean a) {
        done = a;
    }
}
