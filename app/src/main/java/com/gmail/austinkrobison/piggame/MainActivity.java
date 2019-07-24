package com.gmail.austinkrobison.piggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements OnClickListener{
    private Button resetButton;
    private Button endTurnButton;
    private Button rollButton;
    private EditText p1NameField;
    private EditText p2NameField;
    private TextView turnIndicator;
    private TextView turnPoints;
    private TextView score1;
    private TextView score2;
    private ImageView dieView;
    public Player p1;
    public Player p2;
    public int TBD;
    public int tpts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resetButton = findViewById(R.id.resetButton);
        resetButton.setOnClickListener(this);
        endTurnButton = findViewById(R.id.endTurnButton);
        endTurnButton.setOnClickListener(this);
        rollButton = findViewById(R.id.rollButton);
        rollButton.setOnClickListener(this);
        p1NameField = findViewById(R.id.p1NameField);
        p2NameField = findViewById(R.id.p2NameField);
        turnIndicator = findViewById(R.id.turnIndicator);
        turnPoints = findViewById(R.id.turnPoints);
        score1 = findViewById(R.id.score1);
        score2 = findViewById(R.id.score2);
        dieView = findViewById(R.id.dieImg);
        p1 = new Player();
        p2 = new Player();
        p1.turn = true;
        p2.turn = false;
        TBD = 0;
        p1.roundScore = 0;
        p2.roundScore = 0;
        p1.score = 0;
        p2.score = 0;

        dieView.setImageResource(R.drawable.die1);


    }

    public void onClick(View v){
        Context context = getApplicationContext();
        CharSequence p1Win = p1NameField.getText() +" is the winner!";
        CharSequence p2Win = p2NameField.getText() +" is the winner!";
        int duration = Toast.LENGTH_LONG;
        Toast p1WinMsg = Toast.makeText(context, p1Win, duration);
        Toast p2WinMsg = Toast.makeText(context, p2Win,duration);
        switch (v.getId()){
            case R.id.resetButton:
                score1.setText(""+0);
                score2.setText(""+0);
                turnPoints.setText(""+0);
                p1.reset();
                p2.reset();
                break;
            case R.id.endTurnButton:
                if(p1.turn){
                    p1.endOfTurn();
                    turnPoints.setText(""+0);
                    score1.setText(""+p1.score);
                    turnIndicator.setText(p2NameField.getText());
                    p2.turn = true;
                }else{
                    p2.endOfTurn();
                    turnPoints.setText(""+0);
                    score2.setText(""+p2.score);
                    turnIndicator.setText(p1NameField.getText());
                    p1.turn = true;
                }
                break;
            case R.id.rollButton:
                if(p1.turn){
                    TBD = p1.roll();
                    if(TBD == 1){
                        dieView.setImageResource(R.drawable.die1);
                        p1.roundScore = 0;
                        p2.turn = true;
                        turnPoints.setText(""+p1.roundScore);
                        turnIndicator.setText(p2NameField.getText());
                    }
                    if(TBD == 2) {
                        dieView.setImageResource(R.drawable.die2);
                        p1.addRoundScore(2);
                        turnPoints.setText(""+p1.roundScore);
                    }
                    if(TBD == 3) {
                        dieView.setImageResource(R.drawable.die3);
                        p1.addRoundScore(3);
                        turnPoints.setText(""+p1.roundScore);
                    }
                    if(TBD == 4) {
                        dieView.setImageResource(R.drawable.die4);
                        p1.addRoundScore(4);
                        turnPoints.setText(""+p1.roundScore);
                    }
                    if(TBD == 5) {
                        dieView.setImageResource(R.drawable.die5);
                        p1.addRoundScore(5);
                        turnPoints.setText(""+p1.roundScore);
                    }
                    if(TBD == 6){
                        dieView.setImageResource(R.drawable.die6);
                        p1.addRoundScore(6);
                        turnPoints.setText(""+p1.roundScore);
                    }
                    if(p1.score >= 100 && p1.score > p2.score){
                        p1WinMsg.show();
                        p1.reset();
                        p2.reset();
                        score1.setText(""+0);
                        score2.setText(""+0);
                        turnPoints.setText(""+0);
                    }


                }else{
                    TBD = p1.roll();
                    if(TBD == 1){
                        dieView.setImageResource(R.drawable.die1);
                        p2.roundScore = 0;
                        p1.turn = true;
                        turnPoints.setText(""+p2.roundScore);
                        turnIndicator.setText(p1NameField.getText());
                    }
                    if(TBD == 2) {
                        dieView.setImageResource(R.drawable.die2);
                        p2.addRoundScore(2);
                        turnPoints.setText(""+p2.roundScore);
                    }
                    if(TBD == 3) {
                        dieView.setImageResource(R.drawable.die3);
                        p2.addRoundScore(3);
                        turnPoints.setText(""+p2.roundScore);
                    }
                    if(TBD == 4) {
                        dieView.setImageResource(R.drawable.die4);
                        p2.addRoundScore(4);
                        turnPoints.setText(""+p2.roundScore);
                    }
                    if(TBD == 5) {
                        dieView.setImageResource(R.drawable.die5);
                        p2.addRoundScore(5);
                        turnPoints.setText(""+p2.roundScore);
                    }
                    if(TBD == 6){
                        dieView.setImageResource(R.drawable.die6);
                        p2.addRoundScore(6);
                        turnPoints.setText(""+p2.roundScore);
                    }
                    if(p2.score >= 100 && p2.score > p1.score){
                        p2WinMsg.show();
                        p1.reset();
                        p2.reset();
                        score1.setText(""+0);
                        score2.setText(""+0);
                        turnPoints.setText(""+0);
                    }
                }
                break;
            }

        }
    }

