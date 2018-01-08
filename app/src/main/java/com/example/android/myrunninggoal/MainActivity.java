package com.example.android.myrunninggoal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int totalKm = 0;
    int totalMin = 0;
    int progress;
    int goal = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //reset summary
    public void resetAll(View view) {
        totalKm = 0;
        totalMin = 0;
        progress = 0;
        displayTotalKm(totalKm);
        displayTotalMin(totalMin);
        displayProgress(progress);
        Toast.makeText(this, getString(R.string.toast_run), Toast.LENGTH_SHORT).show();
    }

    //set today km
    public void addFiveKm(View view) {
        int todayKm = 5;
        totalKm += todayKm;
        progress = goal - totalKm;
        if (progress < 0) {
            return;
        }
        displayTodayKm(todayKm);
        displayTotalKm(totalKm);
        displayProgress(progress);
        todayKm = 0;
    }

    public void addTenKm(View view) {
        int todayKm = 10;
        totalKm += todayKm;
        progress = goal - totalKm;
        if (progress < 0) {
            return;
        }
        displayTodayKm(todayKm);
        displayTotalKm(totalKm);
        displayProgress(progress);
        todayKm = 0;
    }

    public void addTwentyKm(View view) {
        int todayKm = 20;
        totalKm += todayKm;
        progress = goal - totalKm;
        if (progress < 0) {
            return;
        }
        displayTodayKm(todayKm);
        displayTotalKm(totalKm);
        displayProgress(progress);
        todayKm = 0;
    }

    //    set today minutes
    public void addFiveMin(View view) {
        int todayMin = 5;
        totalMin += todayMin;
        displayTotalMin(totalMin);
        displayTodayMin(todayMin);
        todayMin = 0;
    }

    public void addTenMin(View view) {
        int todayMin = 10;
        totalMin += todayMin;
        displayTotalMin(totalMin);
        displayTodayMin(todayMin);
        todayMin = 0;
    }

    public void addThirtyMin(View view) {
        int todayMin = 30;
        totalMin += todayMin;
        displayTotalMin(totalMin);
        displayTodayMin(todayMin);
        todayMin = 0;
    }


    //display today running km
    public void displayTodayKm(int km) {
        TextView kmView = (TextView) findViewById(R.id.today_km);
        kmView.setText(String.valueOf(km));
    }

    //    display today running minutes
    public void displayTodayMin(int min) {
        TextView minView = (TextView) findViewById(R.id.today_min);
        minView.setText(String.valueOf(min));
    }

    //    display total running km
    public void displayTotalKm(int km) {
        TextView kmView = (TextView) findViewById(R.id.total_km);
        kmView.setText(String.valueOf(km));
    }

    //    display total running minutes
    public void displayTotalMin(int min) {
        TextView minView = (TextView) findViewById(R.id.total_min);
        minView.setText(String.valueOf(min));
    }

    public void displayProgress (int goalProgress) {
        TextView progressView = (TextView) findViewById(R.id.goal_progress);
        progressView.setText("" + goalProgress);
        if (goalProgress <= 25 && goalProgress > 0) {
            Toast.makeText(this, getString(R.string.toast_75), Toast.LENGTH_SHORT).show();
            return;
        } else if (goalProgress == 50) {
            Toast.makeText(this, getString(R.string.toast_50), Toast.LENGTH_SHORT).show();
            return;
        } else if (goalProgress <= 75 && goalProgress > 50) {
            Toast.makeText(this, getString(R.string.toast_25), Toast.LENGTH_SHORT).show();
            return;
        }else if (totalKm == 100) {
            Toast.makeText(this, getString(R.string.toast), Toast.LENGTH_SHORT).show();
            return;
        }else if (goalProgress < 100 && goalProgress >= 5){
            Toast.makeText(this, getString(R.string.toast_95), Toast.LENGTH_SHORT).show();
            return;
        }else {
            Toast.makeText(this, getString(R.string.toast_run), Toast.LENGTH_SHORT).show();
            return;
        }
    }

}
