package com.example.WhatToDo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MemberNameTest {

    private MemberName name;

    @Before
    public void setUp() throws Exception {
        name = new MemberName("Bobby Joe");
    }

    @Test
    public void testLaunch() {
        assertTrue(name.getText()=="Bobby Joe");
    }

    @After
    public void tearDown() throws Exception {
        name = null;
    }


    private MemberName name2;

    @Before
    public void setUp2() throws Exception {
        name2 = new MemberName("Bobby Joe");
    }

    @Test
    public void testLaunch2() {
        name2.changeText("Billy Bob");
        assertTrue(name2.getText()=="Billy Bob");
    }

    @After
    public void tearDown2() throws Exception {
        name2 = null;
    }
}
