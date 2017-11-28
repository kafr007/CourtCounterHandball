package com.example.android.courtcounterhandball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int teamASevenMeterScore = 0;
    int teamBSevenMeterScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayForTeamASevenMeterScore(teamASevenMeterScore);
        displayForTeamBSevenMeterScore(teamBSevenMeterScore);
    }

    private void displayForTeamB(int scoreTeamB) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(scoreTeamB));
    }

    private void displayForTeamA(int scoreTeamA){
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(scoreTeamA));
    }

    private void displayForTeamBSevenMeterScore(int teamBSevenMeterScore) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_7meter_goal);
        scoreView.setText(String.valueOf(teamBSevenMeterScore));
    }

    private void displayForTeamASevenMeterScore(int teamASevenMeterScore){
        TextView scoreView = (TextView) findViewById(R.id.team_a_7meter_goal);
        scoreView.setText(String.valueOf(teamASevenMeterScore));
    }

    public void addGoalForTeamB(View v){
        scoreTeamB+=1;
        displayForTeamB(scoreTeamB);

    }

    public void addSevenMeterTeamB(View v){
        teamBSevenMeterScore+=1;
        addGoalForTeamB(v);
        displayForTeamBSevenMeterScore(teamBSevenMeterScore);

    }

        public void addGoalForTeamA(View v){
        scoreTeamA+=1;
        displayForTeamA(scoreTeamA);

    }

    public void addSevenMeterTeamA(View v){
        teamASevenMeterScore+=1;
        addGoalForTeamA(v);
        displayForTeamASevenMeterScore(teamASevenMeterScore);

    }


    public void resume(View v){
        scoreTeamA=0;
        scoreTeamB=0;
        teamASevenMeterScore=0;
        teamBSevenMeterScore=0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayForTeamASevenMeterScore(teamASevenMeterScore);
        displayForTeamBSevenMeterScore(teamBSevenMeterScore);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
        // Save the user's current game state
        savedInstanceState.putInt("StateGoalA", scoreTeamA);
        savedInstanceState.putInt("StateGoalB", scoreTeamB);
        savedInstanceState.putInt("StateSevenMA", teamASevenMeterScore);
        savedInstanceState.putInt("StateSevenMB", teamBSevenMeterScore);
    }

    /**
     * Method for restoring and displaying data after switching device orientation.
     */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState != null) {
            scoreTeamA = savedInstanceState.getInt("StateGoalA");
            scoreTeamB = savedInstanceState.getInt("StateGoalB");
            teamASevenMeterScore = savedInstanceState.getInt("StateSevenMA");
            teamBSevenMeterScore = savedInstanceState.getInt("StateSevenMB");
        }
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayForTeamASevenMeterScore(teamASevenMeterScore);
        displayForTeamBSevenMeterScore(teamBSevenMeterScore);
    }
}
