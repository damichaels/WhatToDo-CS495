package com.example.WhatToDo;

import org.junit.Test;

import static org.junit.Assert.*;

public class CreateGroupTest {

    @Test
    public void onCreate() {
        Group testGroup = new Group();
        assertNotNull(testGroup);
    }
}