package com.ismaillagouilly.tennis;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ismail Lagouilly.
 */

/* ********************************************************************************* */
/*                                                                                   */
/*  Game Class                                                                       */
/*                                                                                   */
/*  Manages a Game by playing points until one player wins a Game.                   */
/*                                                                                   */
/*   The class uses Lombok java library to automatically generate                    */
/*   Getters & Setters. More information on the link: https://www.projectlombok.org/ */
/*                                                                                   */
/* ********************************************************************************* */

@Getter
@Setter
class Game {

    private static final Integer THIRTY_SCORE = 2;
    private static final Integer FORTY_SCORE = 3;
    private static final Integer ADVANTAGE_SCORE = 4;
    private static final List<String> pointsList = Arrays.asList("0", "15", "30", "40", "ADV");
    private static final Long SCORE_DELAY = 500L;

    private Player player1;
    private Player player2;

    private Integer gameScorePlayer1;
    private Integer gameScorePlayer2;

    private String gameScoreTextPlayer1;
    private String gameScoreTextPlayer2;

    private Player winner;

    Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        gameScorePlayer1 = 0;
        gameScorePlayer2 = 0;
        gameScoreTextPlayer1 = "";
        gameScoreTextPlayer2 = "";
        winner = null;
    }

    Game(Set set) {
        player1 = set.getPlayer1();
        player2 = set.getPlayer2();
        gameScorePlayer1 = 0;
        gameScorePlayer2 = 0;
        gameScoreTextPlayer1 = "";
        gameScoreTextPlayer2 = "";
        winner = null;
    }

    void play(DisplayInformation displayInformation) {
        do {
            // Randomly select the next Player who will score a point
            Player player = retrievePlayer(this);
            incrementGameScorePlayer(player, displayInformation);
            displayGameScore(displayInformation);

            try {
                // thread to sleep for 0.5 seconds
                Thread.sleep(SCORE_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (winner == null);
    }

    void displayGameScore(DisplayInformation displayInformation) {
        if (winner == null) {
            displayInformation.displayGameScore(getScoreDescription(gameScorePlayer1), getScoreDescription(gameScorePlayer2));
        } else {
            announceWinner(displayInformation);
        }
    }

    private void announceWinner(DisplayInformation displayInformation) {
        displayInformation.displayGameWinner(winner);
    }

    private Integer incrementGameScore(Player player, DisplayInformation displayInformation) {
        displayInformation.displayGamePoint(player);

        if (player1.equals(player)) {
            return gameScorePlayer1++;
        } else {
            return gameScorePlayer2++;
        }
    }

    void incrementGameScorePlayer(Player player, DisplayInformation displayInformation) {
        boolean player1Scoring = player.equals(player1);
        boolean player2Scoring = player.equals(player2);

        // Game Score with {X<40} is ( X - 40 ) or ( 40 - X ) leading to score above 40 => designate a winner
        if ((gameScorePlayer1.equals(FORTY_SCORE) && gameScorePlayer2 < FORTY_SCORE && player1Scoring)
                || (gameScorePlayer2.equals(FORTY_SCORE) && gameScorePlayer1 < FORTY_SCORE && player2Scoring)) {

            designateWinner(player, displayInformation);
            // Game Score is ( 40 - 40 ) or above => activate deuce rule
        } else if (gameScorePlayer1 >= FORTY_SCORE && gameScorePlayer2 >= FORTY_SCORE) {

            activateDeuceRule(player, displayInformation);
            // All other cases => increment scores
        } else {
            incrementGameScore(player, displayInformation);
        }
    }

    private void activateDeuceRule(Player player, DisplayInformation displayInformation) {
        boolean player1Scoring = player.equals(player1);
        boolean player2Scoring = player.equals(player2);

        // Game Score is ( 40 - 40 ) => increment score to ADV
        if (gameScorePlayer1.equals(FORTY_SCORE) && gameScorePlayer2.equals(FORTY_SCORE)) {

            incrementGameScore(player, displayInformation);

            // Game Score is ( ADV - 40 ) or ( 40 - ADV ) leading to score above ADV => designate a winner
        } else if ((gameScorePlayer1.equals(ADVANTAGE_SCORE) && gameScorePlayer2.equals(FORTY_SCORE) && player1Scoring)
                || (gameScorePlayer2.equals(ADVANTAGE_SCORE) && gameScorePlayer1.equals(FORTY_SCORE) && player2Scoring)) {

            designateWinner(player, displayInformation);

            // Game Score is ( ADV - 40 ) or ( 40 - ADV ) leading to score ( ADV - ADV ) => increment scores & activate deuce rule
        } else if ((gameScorePlayer1.equals(FORTY_SCORE) && gameScorePlayer2.equals(ADVANTAGE_SCORE) && player1Scoring)
                || (gameScorePlayer2.equals(FORTY_SCORE) && gameScorePlayer1.equals(ADVANTAGE_SCORE) && player2Scoring)) {

            incrementGameScore(player, displayInformation);
            resetScoresDeuceRule(displayInformation);
        }
    }

    private void resetScoresDeuceRule(DisplayInformation displayInformation) {
        displayInformation.announceDeuceRule();
        setGameScorePlayer1(FORTY_SCORE);
        setGameScorePlayer2(FORTY_SCORE);
    }

    private void designateWinner(Player player, DisplayInformation displayInformation) {
        if (player1.equals(player)) {
            displayInformation.displayGamePoint(player1);
            winner = player1;
        } else {
            displayInformation.displayGamePoint(player2);
            winner = player2;
        }
        resetGameScores();
    }

    private void resetGameScores() {
        setGameScorePlayer1(0);
        setGameScorePlayer2(0);
    }

    private String getScoreDescription(Integer gameScore) {
        return pointsList.get(gameScore);
    }

    private Player retrievePlayer(Game game) {
        return (Math.random() < 0.5) ? game.getPlayer1() : game.getPlayer2();
    }

}
