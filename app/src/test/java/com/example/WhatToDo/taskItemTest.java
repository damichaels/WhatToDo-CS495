package com.example.WhatToDo;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class taskItemTest {

    @Test
    public void getText() {
        String mtaskName;
        String mtaskValue;
        mtaskName= "Tom";
        mtaskValue= "10";
        assertNotNull(mtaskName);
    }

    @Test
    public void getText2() {
        String mtaskName;
        String mtaskValue;
        mtaskName= "Tom";
        mtaskValue= "10";
        assertNotNull(mtaskValue);
    }
}