package com.ismaillagouilly.tennis;

import java.util.Scanner;
import java.lang.Math;
import java.lang.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Hello world!
 */
public class App
{

    public App() {}

    public static void main(String[] args) {

    displayOpeningBanner();

    Scanner scannerInPlayer1 = new Scanner(System.in);
	System.out.print("Enter player1 username: ");
	String player1Username = scannerInPlayer1.nextLine();

	Player player1 = new Player(player1Username);

    Scanner scannerInPlayer2 = new Scanner(System.in);
    System.out.print("Enter player2's username: ");
    String player2Username = scannerInPlayer2.nextLine();


	Player player2 = new Player(player2Username);

	Game game = new Game(player1, player2);

    Set set = new Set(player1, player2);

    while(set.getWinner() == null) {

		while(game.getWinner() == null) {
		        
            game.incrementScorePlayer(randomScore());
			
			game.displayGameScore();

            try { Thread.sleep(200);} catch (Exception e) { System.out.println(e);} // thread to sleep for 0.5 seconds
    	}

        set.incrementSetScorePlayer(game.getWinner());

        set.displaySetScore(); 
        
        game.resetWinner();
    }

    displayClosingBanner(); 

	}

    private static void displayOpeningBanner() {

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



    private static void displayClosingBanner() {

        System.out.print("\n\n\n");
        System.out.println("                              ######## ##    ## ########    ");
        System.out.println("                              ##       ###   ## ##     ##   ");
        System.out.println("                              ##       ####  ## ##     ##   ");
        System.out.println("                              ######   ## ## ## ##     ##   ");
        System.out.println("                              ##       ##  #### ##     ##   ");
        System.out.println("                              ##       ##   ### ##     ##   ");
        System.out.println("                              ######## ##    ## ########    ");
    }

    private static Boolean randomScore(){
    return Math.random() < 0.5;
}

}
