package com.ismaillagouilly.tennis;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Ismail Lagouilly.
 */

@Getter
@Setter
public class Game {

    private static final Integer FORTY_SCORE = 3;
    private static final Integer ADVANTAGE_SCORE = 4;

    private Player player1;
    private Player player2;
    private String winner;

    public Game(Player player1, Player player2) {

        this.player1 = player1;
        this.player2 = player2;
        this.winner = null;
    }

    public void displayGameScore() {

        if (winner == null) {

            System.out.println("Current Game Score is: ( " + player1.getScoreDescription() + " - " + player2.getScoreDescription() + " )");
        } else {

            announceWinner();
        }
    }

    public void announceWinner() {

        System.out.println("\n\nThe winner of the game is : " + this.winner + "\n\n");
    }

    private void incrementScorePlayer(Boolean scoringPlayer) {

        if (scoringPlayer) {

            player1.incrementGameScore();
        } else {

            player2.incrementGameScore();
        }
    }

    public void incrementGameScorePlayer(Boolean scoringPlayer) {

        // Game Score is less or equal to ( 30 - 30 ) => always increment scores
        if (player1.getGameScore() < FORTY_SCORE && player2.getGameScore() < FORTY_SCORE) {

            incrementScorePlayer(scoringPlayer);

            // Game Score with {X<40} is ( X - 40 ) or ( 40 - X ) leading to X + 1 point => increment scores
        } else if ((player1.getGameScore() < FORTY_SCORE && player2.getGameScore().equals(FORTY_SCORE) && scoringPlayer)
                || (player2.getGameScore() < FORTY_SCORE && player1.getGameScore().equals(FORTY_SCORE) && !scoringPlayer)) {

            incrementScorePlayer(scoringPlayer);

            // Game Score with {X<40} is ( X - 40 ) or ( 40 - X ) leading to score above 40 => designate a winner
        } else if ((player1.getGameScore().equals(FORTY_SCORE) && player2.getGameScore() < FORTY_SCORE && scoringPlayer)
                || (player2.getGameScore().equals(FORTY_SCORE) && player1.getGameScore() < FORTY_SCORE && !scoringPlayer)) {

            designateWinner(scoringPlayer);

            // Game Score is ( 40 - 40 ) or above => activate deuce rule
        } else {
            activateDeuceRule(scoringPlayer);
        }
    }


    private void activateDeuceRule(Boolean scoringPlayer) {

        // Game Score is ( 40 - 40 ) => increment score to ADV
        if (player1.getGameScore().equals(FORTY_SCORE) && player2.getGameScore().equals(FORTY_SCORE)) {

            incrementScorePlayer(scoringPlayer);

            // Game Score is ( ADV - 40 ) or ( 40 - ADV ) leading to score above ADV => designate a winner
        } else if ((player1.getGameScore().equals(ADVANTAGE_SCORE) && player2.getGameScore().equals(FORTY_SCORE) && scoringPlayer)
                || (player2.getGameScore().equals(ADVANTAGE_SCORE) && player1.getGameScore().equals(FORTY_SCORE) && !scoringPlayer)) {

            designateWinner(scoringPlayer);

            // Game Score is ( ADV - 40 ) or ( 40 - ADV ) leading to score ( ADV - ADV ) => increment scores & activate deuce rule
        } else if ((player1.getGameScore().equals(FORTY_SCORE) && player2.getGameScore().equals(ADVANTAGE_SCORE) && scoringPlayer)
                || (player2.getGameScore().equals(FORTY_SCORE) && player1.getGameScore().equals(ADVANTAGE_SCORE) && !scoringPlayer)) {

            incrementScorePlayer(scoringPlayer);
            resetScoresDeuceRule();
        }
    }

    private void resetScoresDeuceRule() {

        System.out.println("Deuce Rule applied!");

        this.player1.setGameScore(FORTY_SCORE);
        this.player2.setGameScore(FORTY_SCORE);
    }

    private void designateWinner(Boolean scoringPlayer) {

        if (scoringPlayer) {

            System.out.println(player1.getUsername() + " has won 1 point!");
            this.winner = player1.getUsername();
        } else {

            System.out.println(player2.getUsername() + " has won 1 point!");
            this.winner = player2.getUsername();
        }
        resetGameScores();
    }

    public void resetWinner() {
        this.winner = null;
    }

    private void resetGameScores() {

        this.player1.playerGameReset();
        this.player2.playerGameReset();
    }

}
