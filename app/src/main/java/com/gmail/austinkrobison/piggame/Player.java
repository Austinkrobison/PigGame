package com.gmail.austinkrobison.piggame;

import java.util.Random;

public class Player {
    public int score;
    public boolean turn;
    public int roundScore;
    Random rand = new Random();
    public void addRoundScore(int rVal){
        roundScore += rVal;
    }
    public void reset(){
        score = 0;
        roundScore = 0;
    }
    public int roll() {
        int pRoll = rand.nextInt((6-1)+1) +1;
        if (pRoll == 1) {
            roundScore = 0;
            endOfTurn();
            return 1;
        } else {
            roundScore += pRoll;
            roundScore = 0;
            return pRoll;
        }
    }
    public void endOfTurn(){
            score += roundScore;
            roundScore = 0;
            turn = false;
        }


}
