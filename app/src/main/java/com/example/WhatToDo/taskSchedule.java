package com.example.WhatToDo;


import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;


public class taskSchedule extends AppCompatActivity {


    /*-----METHODS FOR TRANSLATING SCHEDULE DATA FROM THE DB-----*/

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
        if(((dbValue>>20) & 1) == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean getMonday(int dbValue)
    {
        if(((dbValue>>19) & 1) == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean getTuesday(int dbValue)
    {
        if(((dbValue>>18) & 1) == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean getWednesday(int dbValue)
    {
        if(((dbValue>>17) & 1) == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean getThursday(int dbValue)
    {
        if(((dbValue>>16) & 1) == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean getFriday(int dbValue)
    {
        if(((dbValue>>15) & 1) == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean getSaturday(int dbValue)
    {
        if(((dbValue>>14) & 1) == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public int getStartMonth(int dbValue)
    {
        return ((dbValue>>10) & 0b1111);
    }

    public int getStartDay(int dbValue)
    {
        return ((dbValue>>5) & 0b11111);
    }

    public int getStartYear(int dbValue)
    {
        return (dbValue & 0b11111)+2020;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        /*---TO DO---*/

        //Connect to DB
        //Select specific Group, Member, Task
        //Get schedule data (int) from the DB
        //Format screen to display current state of schedule data  X
        //Save new schedule data to the DB when "Set" button is clicked

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_schedule);

        final RadioButton btnDays = findViewById(R.id.days_radio_btn);
        final RadioButton btnWeeks = findViewById(R.id.weeks_radio_btn);
        final Spinner spinnerDays = findViewById(R.id.days_spinner);
        final Spinner spinnerWeeks = findViewById(R.id.weeks_spinner);
        final CheckBox checkboxSun = findViewById(R.id.checkBoxSunday);
        final CheckBox checkboxMon = findViewById(R.id.checkBoxMonday);
        final CheckBox checkboxTue = findViewById(R.id.checkBoxTuesday);
        final CheckBox checkboxWed = findViewById(R.id.checkBoxWednesday);
        final CheckBox checkboxThu = findViewById(R.id.checkBoxThursday);
        final CheckBox checkboxFri = findViewById(R.id.checkBoxFriday);
        final CheckBox checkboxSat = findViewById(R.id.checkBoxSaturday);
        final CalendarView calendar = findViewById(R.id.calendarView);
        final Button btnSet = findViewById(R.id.button);

        int dbValue = 0b10000000010010101000111011100000; //Temporary schedule data for testing while DB is being set up
        //weeks, 2, Mon&Wed&Fri, 4/23/2020
        //Note: for months, January would be 0000

        /*-----SET DISPLAY TO REFLECT SCHEDULE DATA FROM THE DB-----*/
        btnDays.setChecked(getDaysOrWeeks(dbValue));
        btnWeeks.setChecked(getDaysOrWeeks(dbValue));

        if(getDaysOrWeeks(dbValue))
            spinnerWeeks.setSelection(getSpan(dbValue) % 10);
        else
            spinnerDays.setSelection(getSpan(dbValue) % 7);

        checkboxSun.setChecked(getSunday(dbValue));
        checkboxMon.setChecked(getMonday(dbValue));
        checkboxTue.setChecked(getTuesday(dbValue));
        checkboxWed.setChecked(getWednesday(dbValue));
        checkboxThu.setChecked(getThursday(dbValue));
        checkboxFri.setChecked(getFriday(dbValue));
        checkboxSat.setChecked(getSaturday(dbValue));

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, getStartMonth(dbValue));
        cal.set(Calendar.DAY_OF_MONTH, getStartDay(dbValue));
        cal.set(Calendar.YEAR, getStartYear(dbValue));
        long milliTime = cal.getTimeInMillis();
        calendar.setDate (milliTime, true, true); //show start date
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.YEAR, 2020);
        milliTime = cal.getTimeInMillis();
        calendar.setMinDate(milliTime);  //set earliest date to 1/1/2020


    }

}
