package com.ismaillagouilly.tennis;

/**
 * Created by Ismail Lagouilly.
 */
/* ********************************************************************************* */
/*                                                                                   */
/*  DisplayInformationImpl Class                                                     */
/*                                                                                   */
/*  Defines the methods required to display information about a Tennis Game          */
/*                                                                                   */
/* ********************************************************************************* */
public class DisplayInformationImpl implements DisplayInformation {

    @Override
    public void displayGamePoint(Player player) {
        System.out.println(player.getUsername() + " has won 1 point!");
    }

    @Override
    public void displayGameScore(String gameScorePlayer1, String gameScorePlayer2) {
        System.out.println("Current Game Score is: ( " + gameScorePlayer1 + " - " + gameScorePlayer2 + " )");
    }

    @Override
    public void announceDeuceRule() {
        System.out.println("Deuce Rule applied!");
    }

    @Override
    public void displayGameWinner(Player player) {
        System.out.println("\n\nThe winner of the game is : " + player.getUsername());
    }

    @Override
    public void displayTieBreakScore(Integer tieBreakScorePlayer1, Integer tieBreakScorePlayer2) {
        System.out.println("Current Tie Break Score is: ( " + tieBreakScorePlayer1 + " - " + tieBreakScorePlayer2 + " )\n\n");
    }

    @Override
    public void displaySetScore(Integer setScorePlayer1, Integer setScorePlayer2) {
        System.out.println("\n\nCurrent Set Score is: ( " + setScorePlayer1 + " - " + setScorePlayer2 + " )\n\n");
    }

    @Override
    public void displaySetWinner(Player player) {
        System.out.println("The winner of the Set is : " + player.getUsername() + "\n\n");
    }

    @Override
    public void displayMatchScore(Integer matchScorePlayer1, Integer matchScorePlayer2) {
        System.out.println("\n\nMatch Score is: ( " + matchScorePlayer1 + " - " + matchScorePlayer2 + " )\n\n");

    }

    @Override
    public void displayMatchWinner(Player player) {
        System.out.println("The winner of the Match is : " + player.getUsername());
    }

    @Override
    public void displayOpeningBanner() {

        System.out.println("               ######## ######## ##    ## ##    ## ####  ######  ");
        System.out.println("                  ##    ##       ###   ## ###   ##  ##  ##    ## ");
        System.out.println("                  ##    ##       ####  ## ####  ##  ##  ##       ");
        System.out.println("                  ##    ######   ## ## ## ## ## ##  ##   ######  ");
        System.out.println("                  ##    ##       ##  #### ##  ####  ##        ## ");
        System.out.println("                  ##    ##       ##   ### ##   ###  ##  ##    ## ");
        System.out.println("                  ##    ######## ##    ## ##    ## ####  ######  ");
        System.out.println("                     ##    ##    ###    ########    ###    ");
        System.out.println("                     ##   ##    ## ##      ##      ## ##   ");
        System.out.println("                     ##  ##    ##   ##     ##     ##   ##  ");
        System.out.println("                     #####    ##     ##    ##    ##     ## ");
        System.out.println("                     ##  ##   #########    ##    ######### ");
        System.out.println("                     ##   ##  ##     ##    ##    ##     ## ");
        System.out.println("                     ##    ## ##     ##    ##    ##     ## \n\n\n");

    }

    @Override
    public void displayClosingBanner() {

        System.out.print("\n\n\n");
        System.out.println("                              ######## ##    ## ########    ");
        System.out.println("                              ##       ###   ## ##     ##   ");
        System.out.println("                              ##       ####  ## ##     ##   ");
        System.out.println("                              ######   ## ## ## ##     ##   ");
        System.out.println("                              ##       ##  #### ##     ##   ");
        System.out.println("                              ##       ##   ### ##     ##   ");
        System.out.println("                              ######## ##    ## ########    ");
    }
}
