package com.ismaillagouilly.tennis;

/**
* Created by Ismail Lagouilly.
*/
/* ********************************************************************************* */
/*                                                                                   */
/*  DisplayInformation Interface                                                     */
/*                                                                                   */
/*  Describes the methods required to display information about a Tennis Game        */
/*                                                                                   */
/* ********************************************************************************* */

public interface DisplayInformation {

    void displayGamePoint(Player player);

    void displayGameScore(String gameScorePlayer1, String gameScorePlayer2);

    void announceDeuceRule();

    void displayGameWinner(Player player);

    void displaySetScore(Integer setScorePlayer1, Integer setScorePlayer2);

    void displayTieBreakScore(Integer setScorePlayer1, Integer setScorePlayer2);

    void displaySetWinner(Player player);

    void displayMatchScore(Integer matchScorePlayer1, Integer matchScorePlayer2);

    void displayMatchWinner(Player player);

    void displayOpeningBanner();

    void displayClosingBanner();
}
