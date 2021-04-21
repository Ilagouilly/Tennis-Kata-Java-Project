package com.ismaillagouilly.tennis;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Ismail Lagouilly.
 */
@Getter
@Setter
public class Set {

    private Player player1;
    private Player player2;
    private String winner;
    private static final Integer FOUR = 4;
    private static final Integer FIVE = 5;
    private static final Integer SIX = 6;

    public Set(Player player1, Player player2) {

        this.player1 = player1;
        this.player2 = player2;
        this.winner = null;
    }

    public void displaySetScore() {

        System.out.println("Current Set Score is: ( " + player1.getSetScore() + " - " + player2.getSetScore() + " )\n");

        if (player1.getTieBreakScore() != 0 || player2.getTieBreakScore() != 0) {
            System.out.print("Tie Break Score is: ( " + player1.getTieBreakScore() + " - " + player2.getTieBreakScore() + " )\n");
        }

        if (winner != null) {
            announceWinner();
        }
    }

    public void announceWinner() {

        System.out.println("\nThe winner of the Set is : " + this.winner);
    }

    public void incrementSetScorePlayer(String gameWinner) {

        if (player1.getSetScore() <= FOUR && player2.getSetScore() <= FOUR) {

            incrementSetScore(gameWinner);
        } else if ((player1.getUsername().equals(gameWinner) && player1.getSetScore() <= FOUR && player2.getSetScore() == FIVE)
                || (player2.getUsername().equals(gameWinner) && player2.getSetScore() <= FOUR && player1.getSetScore() == FIVE)) {
            incrementSetScore(gameWinner);
        } else if ((player1.getUsername().equals(gameWinner) && player1.getSetScore() == FIVE && player2.getSetScore() <= FOUR)
                || (player2.getUsername().equals(gameWinner) && player2.getSetScore() == FIVE && player1.getSetScore() <= FOUR)) {
            incrementSetScore(gameWinner);
            designateWinner(gameWinner);
        } else if ((player2.getSetScore() == FIVE && player1.getSetScore() == FIVE)) {
            incrementSetScore(gameWinner);
        } else if ((player1.getUsername().equals(gameWinner) && player1.getSetScore() == SIX && player2.getSetScore() <= FIVE)
                || (player2.getUsername().equals(gameWinner) && player2.getSetScore() == SIX && player1.getSetScore() <= FIVE)) {
            incrementSetScore(gameWinner);
            designateWinner(gameWinner);
        } else if ((player2.getSetScore() == SIX && player1.getSetScore() == SIX)) {
            activateTieBreak(gameWinner);
        } else if ((player1.getUsername().equals(gameWinner) && player1.getSetScore() == FIVE && player2.getSetScore() == SIX)
                || (player2.getUsername().equals(gameWinner) && player2.getSetScore() == FIVE && player1.getSetScore() == SIX)) {
            incrementSetScore(gameWinner);
            activateTieBreak(gameWinner);
        }

    }

    private void activateTieBreak(String gameWinner) {
        incrementTieBreakScore(gameWinner);

        if ((player1.getUsername().equals(gameWinner) && player1.getTieBreakScore() >= 7 && (player1.getTieBreakScore() >= (player2.getTieBreakScore() + 2)))
                || (player2.getUsername().equals(gameWinner) && player2.getTieBreakScore() >= 7 && (player2.getTieBreakScore() >= (player1.getTieBreakScore() + 2)))) {
            incrementSetScore(gameWinner);
            designateWinner(gameWinner);
        }

    }

    private void incrementSetScore(String gameWinner) {

        if (player1.getUsername().equals(gameWinner)) {

            player1.incrementSetScore();
        } else {

            player2.incrementSetScore();
        }
    }

    private void incrementTieBreakScore(String gameWinner) {

        if (player1.getUsername().equals(gameWinner)) {

            player1.incrementTieBreakScore();
        } else {

            player2.incrementTieBreakScore();
        }
    }


    private void designateWinner(String winner) {

        if (player1.getUsername().equals(winner)) {
            this.winner = player1.getUsername();
        } else {
            this.winner = player2.getUsername();
        }
    }

}
