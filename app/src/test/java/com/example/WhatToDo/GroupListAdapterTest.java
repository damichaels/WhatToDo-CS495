package com.example.WhatToDo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GroupListAdapterTest {

    private GroupName name;
    private GroupName name2;
    private GroupListAdapter adapter;

    @Before
    public void setUp() throws Exception {
        name = new GroupName("Group1");
        name2 = new GroupName("Group2");

        ArrayList<GroupName> groupList = new ArrayList();
        groupList.add(name);
        groupList.add(name2);

        adapter = new GroupListAdapter(groupList);
    }

    @Test
    public void onCreate() {
        assertSame(adapter.getItemCount(),2);
    }

    @After
    public void tearDown() throws Exception {
        name = null;
        name2 = null;
        adapter = null;
    }
}
