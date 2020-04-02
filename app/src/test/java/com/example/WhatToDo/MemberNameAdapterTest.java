package com.example.WhatToDo;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MemberNameAdapterTest {

    @Test
    public void onCreate() {
        MemberName name = new MemberName("Bobby Joe");
        MemberName name2 = new MemberName("Billy Joe");

        ArrayList<MemberName> memberList = new ArrayList();
        memberList.add(name);
        memberList.add(name2);

        MemberNameAdapter adapter = new MemberNameAdapter(memberList);

        assertSame(adapter.getItemCount(),2);
    }
}