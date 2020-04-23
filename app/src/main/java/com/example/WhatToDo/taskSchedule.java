package com.example.WhatToDo;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;


public class taskSchedule extends AppCompatActivity {


    public boolean getDaysOrWeeks(int dbValue)
    {
        if (dbValue>>31 == 0) {
            return false; //Days
        }
        else {
            return true; //Weeks
        }
    }

    public int getSpan(int dbValue)
    {
        return ((dbValue<<1)>>23);
    }

    public boolean getSunday(int dbValue)
    {
        if(((dbValue>>21) & 1) == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean getMonday(int dbValue)
    {
        if(((dbValue>>20) & 1) == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean getTuesday(int dbValue)
    {
        if(((dbValue>>19) & 1) == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean getWednesday(int dbValue)
    {
        if(((dbValue>>18) & 1) == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean getThursday(int dbValue)
    {
        if(((dbValue>>17) & 1) == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean getFriday(int dbValue)
    {
        if(((dbValue>>16) & 1) == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean getSaturday(int dbValue)
    {
        if(((dbValue>>15) & 1) == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public int getStartMonth(int dbValue)
    {
        return ((dbValue>>11) & 0b1111);
    }

    public int getStartDay(int dbValue)
    {
        return ((dbValue>>6) & 0b11111);
    }

    public int getStartYear(int dbValue)
    {
        return (dbValue & 0b11111)+2020;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_schedule);

        /*---TO DO---*/

        //Connect to DB
        //Select specific Group, Member, Task
        //Get schedule data (int) from the DB
        //Format screen to display current state of schedule data
        //Save new schedule data to the DB when "Set" button is clicked




    }

}
