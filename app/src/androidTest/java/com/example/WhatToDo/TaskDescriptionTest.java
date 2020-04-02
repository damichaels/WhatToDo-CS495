package com.example.WhatToDo;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TaskDescriptionTest {

    @Rule
    public ActivityTestRule<TaskDescription> taskDescriptionActivityTestRule = new ActivityTestRule<>(TaskDescription.class);

    private TaskDescription mActivity = null;
    @Before
    public void setUp() {
        mActivity = taskDescriptionActivityTestRule.getActivity();

    }

    @Test
    public void testLaunch() {
        View view = mActivity.findViewById(R.id.changeBtn);
        assertNotNull(view);
    }

    @After
    public void tearDown() {
        mActivity = null;
    }
}