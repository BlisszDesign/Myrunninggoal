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
    int progress, todayKm, todayMin;
    int goal = 100;
    TextView progressView, kmView, minView, totalKmView, totalMinView;
    static final String STATE_KM = "totalKm";
    static final String STATE_MIN = "totalMin";
    static final String STATE_PROGRESS = "progress";
    static final String STATE_TODAY_KM = "todayKm";
    static final String STATE_TODAY_MIN = "todayMin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kmView = findViewById(R.id.today_km);
        minView = findViewById(R.id.today_min);
        totalKmView = findViewById(R.id.total_km);
        totalMinView = findViewById(R.id.total_min);
        progressView = findViewById(R.id.goal_progress);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(STATE_TODAY_KM, todayKm);
        savedInstanceState.putInt(STATE_TODAY_MIN, todayMin);
        savedInstanceState.putInt(STATE_KM, totalKm);
        savedInstanceState.putInt(STATE_MIN, totalMin);
        savedInstanceState.putInt(STATE_PROGRESS, progress);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);
        // Restore state from saved instance
        totalKm = savedInstanceState.getInt(STATE_KM);
        totalMin = savedInstanceState.getInt(STATE_MIN);
        progress = savedInstanceState.getInt(STATE_PROGRESS);
        todayKm = savedInstanceState.getInt(STATE_TODAY_KM);
        todayMin = savedInstanceState.getInt(STATE_TODAY_MIN);
        displayTotalKm(totalKm);
        displayTotalMin(totalMin);
        displayTodayKm(todayKm);
        displayTodayMin(todayMin);
        displayProgress(progress);
    }

    //reset summary
    public void resetAll(View view) {
        totalKm = 0;
        totalMin = 0;
        progress = 100;
        todayMin = 0;
        todayKm = 0;
        displayTotalKm(totalKm);
        displayTotalMin(totalMin);
        displayProgress(progress);
        displayTodayKm(todayKm);
        displayTodayMin(todayMin);
        Toast.makeText(this, getString(R.string.toast_run), Toast.LENGTH_SHORT).show();
    }

    //set today km
    public void addFiveKm(View view) {
        todayKm = 5;
        totalKm += todayKm;
        progress = goal - totalKm;
        if (progress < 0) {
            return;
        }
        displayTodayKm(todayKm);
        displayTotalKm(totalKm);
        displayProgress(progress);
    }

    public void addTenKm(View view) {
        todayKm = 10;
        totalKm += todayKm;
        progress = goal - totalKm;
        if (progress < 0) {
            return;
        }
        displayTodayKm(todayKm);
        displayTotalKm(totalKm);
        displayProgress(progress);
    }

    public void addTwentyKm(View view) {
        todayKm = 20;
        totalKm += todayKm;
        progress = goal - totalKm;
        if (progress < 0) {
            return;
        }
        displayTodayKm(todayKm);
        displayTotalKm(totalKm);
        displayProgress(progress);
    }

    //    set today minutes
    public void addFiveMin(View view) {
        todayMin = 5;
        totalMin += todayMin;
        displayTotalMin(totalMin);
        displayTodayMin(todayMin);
    }

    public void addTenMin(View view) {
        todayMin = 10;
        totalMin += todayMin;
        displayTotalMin(totalMin);
        displayTodayMin(todayMin);
    }

    public void addThirtyMin(View view) {
        todayMin = 30;
        totalMin += todayMin;
        displayTotalMin(totalMin);
        displayTodayMin(todayMin);
    }


    //display today running km
    public void displayTodayKm(int km) {
        kmView.setText(String.valueOf(km));
    }

    //    display today running minutes
    public void displayTodayMin(int min) {
        minView.setText(String.valueOf(min));
    }

    //    display total running km
    public void displayTotalKm(int km) {
        totalKmView.setText(String.valueOf(km));
    }

    //    display total running minutes
    public void displayTotalMin(int min) {
        totalMinView.setText(String.valueOf(min));
    }

    public void displayProgress(int goalProgress) {
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
        } else if (totalKm == 100) {
            Toast.makeText(this, getString(R.string.toast), Toast.LENGTH_SHORT).show();
            return;
        } else if (goalProgress < 100 && goalProgress >= 5) {
            Toast.makeText(this, getString(R.string.toast_95), Toast.LENGTH_SHORT).show();
            return;
        } else {
            Toast.makeText(this, getString(R.string.toast_run), Toast.LENGTH_SHORT).show();
            return;
        }
    }

}
