package com.example.WhatToDo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GroupNameTest {

    private GroupName name;

    @Before
    public void setUp() throws Exception {
        name = new GroupName("Baseball Team");
    }

    @Test
    public void onCreate() {
        assertTrue(name.getText()=="Baseball Team");
    }

    @After
    public void tearDown() throws Exception {
        name = null;
    }



    private GroupName name2;

    @Before
    public void setUp2() throws Exception {
        name2 = new GroupName("Baseball Team");
    }

    @Test
    public void onCreate2() {
        name2.changeText("Football Team");
        assertTrue(name2.getText()=="Football Team");
    }

    @After
    public void tearDown2() throws Exception {
        name2 = null;
    }
}