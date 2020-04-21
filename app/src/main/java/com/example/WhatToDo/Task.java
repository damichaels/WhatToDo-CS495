package com.example.WhatToDo;
import java.io.Serializable;
import java.util.ArrayList;
public class Task implements Serializable{
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
