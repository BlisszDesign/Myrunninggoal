package com.example.android.myrunninggoal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private int totalKm = 0;
    private int totalMin = 0;
    private int progress;
    private int todayKm;
    private int todayMin;
    private int goal = 100;
    private TextView progressView;
    private TextView kmView;
    private TextView minView;
    private TextView totalKmView;
    private TextView totalMinView;
    public static final String STATE_KM = "totalKm";
    public static final String STATE_MIN = "totalMin";
    public static final String STATE_PROGRESS = "progress";
    public static final String STATE_TODAY_KM = "todayKm";
    public static final String STATE_TODAY_MIN = "todayMin";

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
        updateCounter(kmView, todayKm); // display
        updateCounter(totalKmView, totalKm);
        updateCounter(progressView, progress);
        updateCounter(minView, todayMin); // display
        updateCounter(totalMinView, totalMin);
    }

    public static void updateCounter(TextView textView, int score) {
        textView.setText(String.valueOf(score));
    }

    public void updateProgress(int goalProgress) {
        progressView.setText("" + goalProgress);
        switch (goalProgress) {
            case 25:
                Toast.makeText(this, getString(R.string.toast_75), Toast.LENGTH_SHORT).show();
                break;
            case 50:
                Toast.makeText(this, getString(R.string.toast_50), Toast.LENGTH_SHORT).show();
                break;
            case 75:
                Toast.makeText(this, getString(R.string.toast_25), Toast.LENGTH_SHORT).show();
                break;
            case 0:
                Toast.makeText(this, getString(R.string.toast), Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, getString(R.string.toast_95), Toast.LENGTH_SHORT).show();
        }
    }

    public void onSubmit(View view) {
        switch (view.getId()) {
            case R.id.five_km:
                todayKm = 5;
                totalKm += todayKm;
                progress = goal - totalKm;
                if (progress < 0) {
                    return;
                }
                updateCounter(kmView, todayKm); // display
                updateCounter(totalKmView, totalKm);
                updateProgress(progress);
                break;
            case R.id.ten_km:
                todayKm = 10;
                totalKm += todayKm;
                progress = goal - totalKm;
                updateCounter(kmView, todayKm); // display
                updateCounter(totalKmView, totalKm);
                updateProgress(progress);
                break;
            case R.id.twenty_km:
                todayKm = 20;
                totalKm += todayKm;
                progress = goal - totalKm;
                updateCounter(kmView, todayKm); // display
                updateCounter(totalKmView, totalKm);
                updateProgress(progress);
                break;
            case R.id.five_min:
                todayMin = 5;
                totalMin += todayMin;
                updateCounter(minView, todayMin); // display
                updateCounter(totalMinView, totalMin);
                break;
            case R.id.ten_min:
                todayMin = 10;
                totalMin += todayMin;
                updateCounter(minView, todayMin); // display
                updateCounter(totalMinView, totalMin);
                break;
            case R.id.thirty_min:
                todayMin = 30;
                totalMin += todayMin;
                updateCounter(minView, todayMin); // display
                updateCounter(totalMinView, totalMin);
                break;
            case R.id.reset_all:
                totalKm = 0;
                totalMin = 0;
                progress = 100;
                todayMin = 0;
                todayKm = 0;
                updateCounter(kmView, todayKm); // display
                updateCounter(totalKmView, totalKm);
                updateCounter(progressView, progress);
                updateCounter(minView, todayMin); // display
                updateCounter(totalMinView, totalMin);
                Toast.makeText(this, getString(R.string.toast_run), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
