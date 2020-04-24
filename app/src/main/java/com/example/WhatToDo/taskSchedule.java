package com.example.WhatToDo;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;


public class taskSchedule extends AppCompatActivity {


    /*-----Task Schedule Protocol-----*/
    //requires a 32-bit integer
    //Bit 31 -> Days(0) or Weeks(1)
    //Bits 30-21 -> Number of days/weeks in between (Span) (Span saves index in list of span options)
    //Bits 20-14 -> SMTWTFS days of the week scheduled (Only for "Weeks" option) (1 = scheduled)
    //Bits 13-10 -> Start Month
    //Bits 9-5 -> Start day of month
    //Bits 4-0 -> Start Year

    /*-----METHODS FOR TRANSLATING SCHEDULE DATA FROM THE DB-----*/

    public boolean getDaysOrWeeks(int dbValue)
    {
        if (((dbValue>>31) & 0b1) == 0) {
            return false; //Days
        }
        else {
            return true; //Weeks
        }
    }

    public int getSpan(int dbValue)
    {
        return ((dbValue>>21) & 0b1111111111);
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


    /*-----METHODS FOR CONVERTING USER-ENTERED SCHEDULE DATA INTO DB FORMAT-----*/

    public int formatDataForDB(boolean dow, int span, int smtwtfs, int startMonth, int startDay, int startYear)
    {
        int dowINT;
        if (dow)
            dowINT=1;
        else
            dowINT=0;

        return (dowINT<<31) + (span<<21) + (smtwtfs<<14) + (startMonth<<10) + (startDay<<5) + (startYear-2020);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        /*---TO DO---*/

        //Connect to DB
        //Select specific Group, Member, Task
        //Get schedule data (int) from the DB
        //Format screen to display current state of schedule data  X
        //Convert schedule settings displayed/changed on the screen into DB format X
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
        final TextView txtTest = findViewById(R.id.testText);

        int dbValue = 0b10000000010010101000111100000000; //Temporary schedule data for testing while DB is being set up
        //weeks, 3, Mon&Wed&Fri, 4/24/2020
        //Note: for months, January would be 0b0000
        //Note: for span, a 2-day span would be saved as 0b0000000001 (Span saves index in list)


        /*-----SET DISPLAY TO REFLECT SCHEDULE DATA FROM THE DB-----*/
        btnDays.setChecked(!getDaysOrWeeks(dbValue));
        btnWeeks.setChecked(getDaysOrWeeks(dbValue));

        if(getDaysOrWeeks(dbValue))
            spinnerWeeks.setSelection(getSpan(dbValue) % 9);
        else
            spinnerDays.setSelection(getSpan(dbValue) % 6);

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
        calendar.setMinDate(milliTime);  //set earliest possible date to 1/1/2020


        /*-----SEND UPDATED SCHEDULE TO THE DB-----*/

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //set up smtwtfs
                int smtwtfs = 0;
                if (checkboxSun.isChecked())
                    smtwtfs += (1<<6);
                if (checkboxMon.isChecked())
                    smtwtfs += (1<<5);
                if (checkboxTue.isChecked())
                    smtwtfs += (1<<4);
                if (checkboxWed.isChecked())
                    smtwtfs += (1<<3);
                if (checkboxThu.isChecked())
                    smtwtfs += (1<<2);
                if (checkboxFri.isChecked())
                    smtwtfs += (1<<1);
                if (checkboxSat.isChecked())
                    smtwtfs += 1;

                int testInt = 0;
                Calendar calendar1 = Calendar.getInstance();
                calendar1.setTimeInMillis(calendar.getDate());
                if (btnWeeks.isChecked()) //save weeks spinner
                    testInt = formatDataForDB(btnWeeks.isChecked(),spinnerWeeks.getSelectedItemPosition(),smtwtfs,calendar1.get(Calendar.MONTH),calendar1.get(Calendar.DAY_OF_MONTH),calendar1.get(Calendar.YEAR));
                else //save days spinner
                    testInt = formatDataForDB(btnWeeks.isChecked(),spinnerDays.getSelectedItemPosition(),smtwtfs,calendar1.get(Calendar.MONTH),calendar1.get(Calendar.DAY_OF_MONTH),calendar1.get(Calendar.YEAR));

                txtTest.setText(String.valueOf(testInt));


            }

        });


    }

}
