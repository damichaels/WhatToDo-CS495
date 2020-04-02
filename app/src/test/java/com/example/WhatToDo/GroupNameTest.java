package com.example.WhatToDo;

import org.junit.Test;

import static org.junit.Assert.*;

public class GroupNameTest {

    @Test
    public void onCreate() {
        GroupName name = new GroupName("Baseball Team");
        assertTrue(name.getText()=="Baseball Team");
    }

    @Test
    public void onCreate2() {
        GroupName name = new GroupName("Baseball Team");
        name.changeText("Football Team");
        assertTrue(name.getText()=="Football Team");
    }
}