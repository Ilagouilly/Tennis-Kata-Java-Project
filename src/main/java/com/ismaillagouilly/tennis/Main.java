package com.ismaillagouilly.tennis;

import java.util.Scanner;

/**
 * Created by Ismail Lagouilly.
 */

/* ******************************************************************************** */
/*                                                                                  */
/*  Main Class                                                                      */
/*                                                                                  */
/*  Contains the minimum instructions required to start up a Tennis Match.          */
/*                                                                                  */
/*                                                                                  */
/* ******************************************************************************** */

public class Main {

    public Main() {
    }

    public static void main(String[] args) {

        DisplayInformationImpl displayScoresImplSystemOut = new DisplayInformationImpl();

        displayScoresImplSystemOut.displayOpeningBanner();

        Scanner scannerInPlayer1 = new Scanner(System.in);
        System.out.print("Enter player1 username: ");
        String player1Username = scannerInPlayer1.nextLine();

        Player player1 = new Player(player1Username);

        Scanner scannerInPlayer2 = new Scanner(System.in);
        System.out.print("Enter player2's username: ");
        String player2Username = scannerInPlayer2.nextLine();

        Player player2 = new Player(player2Username);

        Match match = new Match(player1, player2);

        match.play(displayScoresImplSystemOut);

        displayScoresImplSystemOut.displayMatchScore(match.getMatchScorePlayer1(), match.getMatchScorePlayer2());

        displayScoresImplSystemOut.displayClosingBanner();

    }

}
