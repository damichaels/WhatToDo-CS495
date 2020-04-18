package com.example.WhatToDo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Member;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MemberNameAdapterTest {


    private MemberName name;
    private MemberName name2;
    private MemberNameAdapter adapter;

    @Before
    public void setUp() throws Exception {
        name = new MemberName("Bobby Joe");
        name2 = new MemberName("Billy Joe");

        ArrayList<MemberName> memberList = new ArrayList();
        memberList.add(name);
        memberList.add(name2);

        adapter = new MemberNameAdapter(memberList);
    }

    @Test
    public void testLaunch() {
        assertSame(adapter.getItemCount(),2);
    }

    @After
    public void tearDown() throws Exception {
        name = null;
        name2 = null;
        adapter = null;
    }

}