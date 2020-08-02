package com.example.pingpongscorecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int teamAPoints;
    int teamAGames;
    int teamBPoints;
    int teamBGames;
    private int tapCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout fullScreenLongClick = (LinearLayout) findViewById(R.id.fullScreen);
        fullScreenLongClick.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                resetGame();
                return true;
            }
        });

        TextView teamAPointsLongClick = (TextView) findViewById(R.id.teamAPointsCounterTextView);
        teamAPointsLongClick.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                resetGame();
                return true;
            }
        });

        TextView teamAGamesLongClick = (TextView) findViewById(R.id.teamAGamesCounterTextView);
        teamAGamesLongClick.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                resetGame();
                return true;
            }
        });

        TextView teamBPointsLongClick = (TextView) findViewById(R.id.teamBPointsCounterTextView);
        teamBPointsLongClick.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                resetGame();
                return true;
            }
        });

        TextView teamBGamesLongClick = (TextView) findViewById(R.id.teamBGamesCounterTextView);
        teamBGamesLongClick.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                resetGame();
                return true;
            }
        });


    }

    private void resetGame() {
        teamAPoints = 0;
        teamAGames = 0;
        teamBPoints = 0;
        teamBGames = 0;
        displayPoints(teamAPoints, teamBPoints);
        displayGames (teamAGames, teamBGames);
        Toast.makeText(getApplicationContext(),"RESET GAME", Toast.LENGTH_SHORT).show();
    }

//
//
//    public void teamAPointsPlusOne(View view) {
//        teamATapCounter += 1;
//        if (teamATapCounter % 2 == 1){
//            if (teamATapCounter < 4){
//                Toast.makeText(this, getString(R.string.pointsExplanation), Toast.LENGTH_SHORT).show();
//                Toast.makeText(this, getString(R.string.resetGameExplanation), Toast.LENGTH_LONG).show();
//            }
//        } if (teamATapCounter % 2 == 0){
//            teamAPoints += 1;
//        }
//        displayTeamAPoints(teamAPoints);
//    }
//
//    private void displayTeamAPoints(int teamAPoints) {
//        TextView textView = (TextView) findViewById(R.id.teamAPointsCounterTextView);
//        textView.setText(String.valueOf(teamAPoints));
//    }
//
//    public void teamAGamesPlusOne(View view) {
//        teamATapCounter += 1;
//        if (teamATapCounter % 2 == 1){
//            Toast.makeText(this, getString(R.string.gamesExplanation) +
//                    " or " + getString(R.string.resetGameExplanation), Toast.LENGTH_SHORT).show();
//        } if (teamATapCounter % 2 == 0){
//            teamAGames += 1;
//            teamAPoints = 0;
//            teamBPoints = 0;
//            displayTeamAPoints(teamAPoints);
//            displayTeamBPoints(teamBPoints);
//            displayGames(teamAGames, teamBGames);
//        }
//    }


    public void teamGamesPlusOne(View view) {
        tapCounter += 1;
        if (tapCounter % 2 == 1){
            Toast.makeText(this, getString(R.string.gamesExplanation) +
                    " or " + getString(R.string.resetGameExplanation), Toast.LENGTH_SHORT).show();
        } if (tapCounter % 2 == 0){
            teamAPoints = 0;
            teamBPoints = 0;
            String thisTeam = view.getTag().toString();
            if (thisTeam.equals(getString(R.string.teamA))){
                teamAGames += 1;
            } if (thisTeam.equals(getString(R.string.teamB))){
                teamBGames += 1;
            }
            displayPoints(teamAPoints, teamBPoints);
            displayGames(teamAGames,teamBGames);
        }
    }

    public void teamPointsPlusOne(View view) {
        tapCounter += 1;
        if (tapCounter % 2 == 1){
            if (tapCounter < 4){
                Toast.makeText(this, getString(R.string.pointsExplanation), Toast.LENGTH_SHORT).show();
                Toast.makeText(this, getString(R.string.resetGameExplanation), Toast.LENGTH_LONG).show();
            }
        } if (tapCounter % 2 == 0){
            String thisTeam = view.getTag().toString();
            if (thisTeam.equals(getString(R.string.teamA))){
                teamAPoints += 1;
            } if (thisTeam.equals(getString(R.string.teamB))){
                teamBPoints += 1;
            }
            displayPoints(teamAPoints, teamBPoints);
        }
    }

    private void displayPoints(int teamAPoints, int teamBPoints) {
        TextView teamAPointsCounterTextView = (TextView) findViewById(R.id.teamAPointsCounterTextView);
        teamAPointsCounterTextView.setText(String.valueOf(teamAPoints));
        TextView teamBPointsCounterTextView = (TextView) findViewById(R.id.teamBPointsCounterTextView);
        teamBPointsCounterTextView.setText(String.valueOf(teamBPoints));
    }

    private void displayGames(int teamAGames, int teamBGames) {
        TextView teamAGamesCounterTextView = (TextView) findViewById(R.id.teamAGamesCounterTextView);
        teamAGamesCounterTextView.setText(String.valueOf(teamAGames));
        TextView teamBGamesCounterTextView = (TextView) findViewById(R.id.teamBGamesCounterTextView);
        teamBGamesCounterTextView.setText(String.valueOf(teamBGames));
    }


//    public void teamBPointsPlusOne(View view) {
//        teamBTapCounter += 1;
//        if (teamBTapCounter % 2 == 1){
//            if (teamBTapCounter < 4){
//                Toast.makeText(this, getString(R.string.pointsExplanation), Toast.LENGTH_SHORT).show();
//                Toast.makeText(this, getString(R.string.resetGameExplanation), Toast.LENGTH_LONG).show();
//            }
//        } if (teamBTapCounter % 2 == 0){
//            teamBPoints += 1;
//        }
//        displayTeamBPoints(teamBPoints);
//    }
//
//    private void displayTeamBPoints(int teamBPoints) {
//        TextView textView = (TextView) findViewById(R.id.teamBPointsCounterTextView);
//        textView.setText(String.valueOf(teamBPoints));
//    }
//
//    public void teamBGamesPlusOne(View view) {
//        teamBTapCounter += 1;
//        if (teamBTapCounter % 2 == 1){
//            Toast.makeText(this, getString(R.string.gamesExplanation) +
//                    " or " + getString(R.string.resetGameExplanation), Toast.LENGTH_SHORT).show();
//        } if (teamBTapCounter % 2 == 0){
//            teamBGames += 1;
//            teamAPoints = 0;
//            teamBPoints = 0;
//            displayTeamAPoints(teamAPoints);
//            displayTeamBPoints(teamBPoints);
//            displayTeamBGames(teamBGames);
//        }
//    }
//
//    private void displayTeamBGames(int teamBGames) {
//        TextView textView = (TextView) findViewById(R.id.teamBGamesCounterTextView);
//        textView.setText(String.valueOf(teamBGames));
//    }



}
