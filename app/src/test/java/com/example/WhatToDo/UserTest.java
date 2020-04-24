package com.example.WhatToDo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    private User plankton;

    @Before
    public void setUp() throws Exception {
        plankton = new User("123", "Sheldon Plankton", "Plankton@gmail.com");
    }


    @Test
    public void getuID() {
        assertEquals("123", plankton.getuID());
    }

    @Test
    public void getName() {
        assertEquals("Sheldon Plankton", plankton.getName());
    }

    @Test
    public void getEmail() {
        assertEquals("Plankton@gmail.com", plankton.getEmail());
    }

    @After
    public void tearDown() throws Exception {
        plankton = null;
    }
}