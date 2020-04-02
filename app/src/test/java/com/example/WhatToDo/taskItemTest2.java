package com.example.WhatToDo;

import org.junit.Test;

import static org.junit.Assert.*;

public class taskItemTest2 {

    @Test
    public void onCreate() {
        taskItem item = new taskItem("Dusting", "10");
        assertSame(item.getText(),"Dusting");
        assertSame(item.getText2(),"10");
    }
}