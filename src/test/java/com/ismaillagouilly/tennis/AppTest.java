package com.ismaillagouilly.tennis;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;
import java.util.Scanner;
import java.lang.Math;
import java.lang.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    List<Integer> liste;
    String PLAYER_1 = "player1Username";
    String PLAYER_2 = "player2Username";


    @Test
    public void testSimpleGameWin() 
    {

    liste = new ArrayList<Integer>();

    liste.add(1); // ( 0 - 15 )
    liste.add(0); // ( 15 - 15 )
    liste.add(0); // ( 30 - 15 )
    liste.add(0); // ( 40 - 15 )
    liste.add(1); // ( 40 - 30 )
    liste.add(0); // ( AVT - 30 ) => Win

    Player player1 = new Player(PLAYER_1);

    Player player2 = new Player(PLAYER_2);

    Game game = new Game(player1, player2);

    int i = 0;

    while(game.getWinner() == null) {
        
        liste.get(i);
        game.incrementScorePlayer(liste.get(i)==0);
        i++;
    }
    assertEquals(PLAYER_1, game.getWinner());
    }

    @Test
    public void testDeuceRule() 
    {

    liste = new ArrayList<Integer>();
    
    liste.add(1); //1 point for player2
    // ( 0 - 15 )  
    liste.add(0); //1 point for player1
    // ( 15 - 15 ) 
    liste.add(1); //1 point for player2
    // ( 15 - 30 ) 
    liste.add(0); //1 point for player1
    // ( 30 - 30 )
    liste.add(1); //1 point for player2
    // ( 30 - 40 ) 
    liste.add(0); //1 point for player1 => Test Deuce Rule 
    // ( 40 - 40 )
    liste.add(1); //1 point for player2 
    //( 40 - ADV )
    liste.add(0); //1 point for player1
    // ( 40 - 40 )  
    liste.add(1); //1 point for player2
    // ( 40 - ADV ) 
    liste.add(1); //1 point for player2
    //  WIN for Player 2

    Player player1 = new Player(PLAYER_1);

    Player player2 = new Player(PLAYER_2);

    Game game = new Game(player1, player2);

    int i = 0;

    while(game.getWinner() == null) {
        
        liste.get(i);
        game.incrementScorePlayer(liste.get(i)==0);
        i++;
    }
    assertEquals(PLAYER_2, game.getWinner());
    }

    @Test
    public void testSet() 
    {

    List<Integer> liste1 = new ArrayList<Integer>();
    liste1.add(1); //1 point for player2
    // ( 0 - 15 )  
    liste1.add(0); //1 point for player1
    // ( 15 - 15 ) 
    liste1.add(1); //1 point for player2
    // ( 15 - 30 ) 
    liste1.add(0); // 1 point for player1
    // ( 30 - 30 )
    liste1.add(1); // 1 point for player2
    // ( 30 - 40 ) 
    liste1.add(1); // 1 point for player2 
    //  WIN for Player 2


    List<Integer> liste2 = new ArrayList<Integer>();
    liste2.add(1); // ( 0 - 15 )
    liste2.add(0); // ( 15 - 15 )
    liste2.add(1); // ( 15 - 30 )
    liste2.add(0); // ( 30 - 30 )
    liste2.add(1); // ( 30 - 40 )
    liste2.add(1); 


    Player player1 = new Player(PLAYER_1);

    Player player2 = new Player(PLAYER_2);

    Game game = new Game(player1, player2);

    int i = 0;

    while(game.getWinner() == null) {
        
        liste1.get(i);
        game.incrementScorePlayer(liste1.get(i)==0);
        i++;
    }

    while(game.getWinner() == null) {
        
        liste2.get(i);
        game.incrementScorePlayer(liste2.get(i)==0);
        i++;
    }
    System.out.println("\nThe winner of the Set is : " + player1.getSetScore() +" "+ player2.getSetScore() ); 
    //assertEquals(PLAYER_2, game.getWinner());
    }

}
