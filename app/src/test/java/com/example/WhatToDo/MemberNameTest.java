package com.example.WhatToDo;

import org.junit.Test;

import static org.junit.Assert.*;

public class MemberNameTest {

    @Test
    public void onCreate() {
        MemberName name = new MemberName("Bobby Joe");
        assertTrue(name.getText()=="Bobby Joe");
    }
}
