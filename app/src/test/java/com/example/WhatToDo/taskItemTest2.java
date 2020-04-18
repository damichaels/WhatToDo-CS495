package com.example.WhatToDo;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class taskItemTest2 {

    private taskItem item;

    @Before
    public void setUp() throws Exception {
        item = new taskItem("Dusting", "10");
    }

    @Test
    public void testLaunch() {
        assertSame(item.getText(),"Dusting");
        assertSame(item.getText2(),"10");
    }

    @After
    public void tearDown() throws Exception {
        item = null;
    }

}