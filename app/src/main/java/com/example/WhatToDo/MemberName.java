package com.example.WhatToDo;

public class MemberName {
    private String mMemberName;

    public MemberName(String Name){
        mMemberName=Name;

    }
    public void changeText(String text){
        mMemberName=text;
    }
    public String getText(){
        return mMemberName;
    }
}
