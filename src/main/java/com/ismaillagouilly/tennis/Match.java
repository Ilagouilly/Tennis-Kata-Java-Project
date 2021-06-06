package com.ismaillagouilly.tennis;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Ismail Lagouilly.
 */

/* ********************************************************************************* */
/*                                                                                   */
/*  Match Class                                                                      */
/*                                                                                   */
/*  Manages a tennis Match where the winner of 3 Sets / 5 Sets wins the Match        */
/*                                                                                   */
/*   The class uses Lombok java library to automatically generate                    */
/*   Getters & Setters. More information on the link: https://www.projectlombok.org/ */
/*                                                                                   */
/* ********************************************************************************* */

@Getter
@Setter
class Match {

    private static final Integer TWO = 2;
    private static final Integer THREE = 2;
    private Player player1;
    private Player player2;
    private Set currentSet;
    private Integer matchScorePlayer1;
    private Integer matchScorePlayer2;
    private Player winner;

    Match(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        matchScorePlayer1 = 0;
        matchScorePlayer2 = 0;
        currentSet = null;
    }

    void play(DisplayInformation displayInformation) {
        do {
            currentSet = new Set(this);
            currentSet.play(displayInformation);
            incrementMatchScorePlayer(currentSet.getWinner());
            announceWinner(displayInformation);
        } while (winner == null);

        // Display the Match Score
        displayInformation.displayMatchScore(getMatchScorePlayer1(), getMatchScorePlayer2());
    }

    void incrementMatchScorePlayer(Player player) {
        boolean player1Scoring = player.equals(player1);
        boolean player2Scoring = player.equals(player2);
        incrementMatchScore(player);

        // The first player to win 3 sets wins the Match
        if ((matchScorePlayer1.equals(THREE) && matchScorePlayer2 <= TWO && player1Scoring)
                || (matchScorePlayer2.equals(THREE) && matchScorePlayer1 <= TWO && player2Scoring)) {
            designateWinner(player);
        }
    }

    private void incrementMatchScore(Player player) {
        if (player1.equals(player)) {
            matchScorePlayer1++;
        } else {
            matchScorePlayer2++;
        }
    }

    private void designateWinner(Player player) {
        winner = player1.equals(player) ? player1 : player2;
    }

    private void announceWinner(DisplayInformation displayInformation) {
        if (winner != null) {
            displayInformation.displayMatchWinner(winner);
        }
    }
}
