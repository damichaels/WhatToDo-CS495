package com.example.WhatToDo;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GroupListAdapterTest {

    @Test
    public void onCreate() {
        GroupName name = new GroupName("Group1");
        GroupName name2 = new GroupName("Group2");

        ArrayList<GroupName> groupList = new ArrayList();
        groupList.add(name);
        groupList.add(name2);

        GroupListAdapter adapter = new GroupListAdapter(groupList);

        assertSame(adapter.getItemCount(),2);
    }
}
