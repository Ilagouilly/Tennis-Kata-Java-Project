package com.ismaillagouilly.tennis;

import lombok.Getter;
import lombok.Setter;
/**
 * Hello world!
 */
@Getter @Setter
public class Game
{

    private Player player1;
    private Player player2;
    private String winner;

    private static final Integer FORTY_SCORE = 3;
    private static final Integer ADVANTAGE_SCORE = 4;

    public Game(Player player1, Player player2) {

        this.player1 = player1;
        this.player2 = player2;
        this.winner = null;
    }

    public void displayGameScore() {

        if(winner == null) {
            System.out.println("Current Game Score is: ( "+ player1.getScoreDescription()+" - "+ player2.getScoreDescription()+ " )");
        } else {
            announceWinner();
        }
    }

    public void announceWinner() {

        System.out.println("\n\nThe winner of the game is : " + this.winner+"\n\n"); 
    }

    private void incrementGameScorePlayer(Boolean scoringPlayer) {

        if(scoringPlayer){
            player1.incrementGameScore();
        } else {
            player2.incrementGameScore();
        }
    }

    public void incrementScorePlayer(Boolean scoringPlayer) {

        if(player1.getGameScore() < FORTY_SCORE && player2.getGameScore() < FORTY_SCORE) {

            incrementGameScorePlayer(scoringPlayer);

        } else if((player1.getGameScore() < FORTY_SCORE && player2.getGameScore() == FORTY_SCORE && scoringPlayer)
            || (player2.getGameScore() < FORTY_SCORE && player1.getGameScore() == FORTY_SCORE && !scoringPlayer)){

            incrementGameScorePlayer(scoringPlayer);

        } else if((player1.getGameScore() == FORTY_SCORE && player2.getGameScore() < FORTY_SCORE && scoringPlayer)
            || (player2.getGameScore() == FORTY_SCORE && player1.getGameScore() < FORTY_SCORE && !scoringPlayer)) {

            designateWinner(scoringPlayer);
        
        } else {
            activateDeuceRule(scoringPlayer);
        }
    }


    private void activateDeuceRule(Boolean scoringPlayer) {

        if(player1.getGameScore() == FORTY_SCORE && player2.getGameScore() == FORTY_SCORE) {

            incrementGameScorePlayer(scoringPlayer);

        } else if((player1.getGameScore() == ADVANTAGE_SCORE && player2.getGameScore() == FORTY_SCORE && scoringPlayer)
            || (player2.getGameScore() == ADVANTAGE_SCORE && player1.getGameScore() == FORTY_SCORE && !scoringPlayer)) {

            designateWinner(scoringPlayer);

        } else if((player1.getGameScore() == FORTY_SCORE && player2.getGameScore() == ADVANTAGE_SCORE && scoringPlayer)
            || (player2.getGameScore() == FORTY_SCORE && player1.getGameScore() == ADVANTAGE_SCORE && !scoringPlayer)) {

            incrementGameScorePlayer(scoringPlayer);
            resetScoresDeuceRule();
        }
    }

    private void resetScoresDeuceRule() {

        System.out.println("Deuce Rule applied!");

        this.player1.setGameScore(FORTY_SCORE);
        this.player2.setGameScore(FORTY_SCORE);
    }

    private void designateWinner(Boolean scoringPlayer) {

        if(scoringPlayer){
            System.out.println(player1.getUsername()+" has won 1 point!");
            this.winner = player1.getUsername();
        } else {
            System.out.println(player2.getUsername()+" has won 1 point!");
            this.winner = player2.getUsername();
        }
        resetGameScores();
    }

    public void resetWinner(){
        this.winner = null;
    }

    private void resetGameScores(){
        this.player1.playerGameReset();
        this.player2.playerGameReset();
    }

}
