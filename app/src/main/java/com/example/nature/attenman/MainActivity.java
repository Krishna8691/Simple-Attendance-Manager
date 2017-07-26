package com.example.nature.attenman;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Intent todayintent;
    Button monday,tuesday,wednesday,thursday,friday,saturday,today;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.rgb(40,40,40));
        }


        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.back)));

        monday = (Button) findViewById(R.id.monday);
        monday.setOnClickListener(this);
        tuesday = (Button) findViewById(R.id.tuesday);
        tuesday.setOnClickListener(this);
        wednesday = (Button) findViewById(R.id.wednesday);
        wednesday.setOnClickListener(this);
        thursday = (Button) findViewById(R.id.thursday);
        thursday.setOnClickListener(this);
        friday = (Button) findViewById(R.id.friday);
        friday.setOnClickListener(this);
        saturday = (Button) findViewById(R.id.saturday);
        saturday.setOnClickListener(this);
        today = (Button) findViewById(R.id.today);
        today.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.monday:
                Intent mondayintent = new Intent(this,mondayactivity.class);
                mondayintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                mondayintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(mondayintent);
                break;
            case R.id.tuesday:
                Intent tuesdayintent = new Intent(this,tuesdayactivity.class);
                tuesdayintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                tuesdayintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(tuesdayintent);
                break;
            case R.id.wednesday:
                Intent wednesdayintent = new Intent(this,wednesdayactivity.class);
                wednesdayintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                wednesdayintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(wednesdayintent);
                break;
            case R.id.thursday:
                Intent thursdayintent = new Intent(this,thursdayactivity.class);
                thursdayintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                thursdayintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(thursdayintent);
                break;
            case R.id.friday:
                Intent fridayintent = new Intent(this,fridayactivity.class);
                fridayintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                fridayintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(fridayintent);
                break;
            case R.id.saturday:
                Intent saturdayintent = new Intent(this,saturdayactivity.class);
                saturdayintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                saturdayintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(saturdayintent);
                break;
            case R.id.today:
                Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_WEEK);

                switch (day) {
                    case Calendar.SUNDAY:
                        // Current day is Sunday
                        todayintent = new Intent(this,TodayMondayActivity.class);
                        startActivity(todayintent);
                        break;
                    case Calendar.MONDAY:
                        // Current day is Monday
                        todayintent = new Intent(this,TodayMondayActivity.class);
                        startActivity(todayintent);
                        break;
                    case Calendar.TUESDAY:
                        todayintent = new Intent(this,TodayTuesdayActivity.class);
                        startActivity(todayintent);
                        break;
                    case Calendar.WEDNESDAY:
                        todayintent = new Intent(this,TodayWednesdayActivity.class);
                        startActivity(todayintent);
                        break;
                    case Calendar.THURSDAY:
                        todayintent = new Intent(this,TodayThursdayActivity.class);
                        startActivity(todayintent);
                        break;
                    case Calendar.FRIDAY:
                        todayintent = new Intent(this,TodayFridayActivity.class);
                        startActivity(todayintent);
                        break;
                    case Calendar.SATURDAY:
                        todayintent = new Intent(this,TodaySaturdayActivity.class);
                        startActivity(todayintent);
                        break;

                }
                break;
        }
    }
}
