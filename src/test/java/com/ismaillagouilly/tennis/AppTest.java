package com.ismaillagouilly.tennis;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ismail Lagouilly.
 */

public class AppTest {

    String PLAYER_1 = "player1Username";
    String PLAYER_2 = "player2Username";

    @Test
    public void testSimpleGameWin() {

        List<Integer> testSimpleDataSet = new ArrayList<Integer>();

        testSimpleDataSet.add(1); // ( 0 - 15 )
        testSimpleDataSet.add(0); // ( 15 - 15 )
        testSimpleDataSet.add(0); // ( 30 - 15 )
        testSimpleDataSet.add(0); // ( 40 - 15 )
        testSimpleDataSet.add(1); // ( 40 - 30 )
        testSimpleDataSet.add(0); // ( AVT - 30 ) => Win

        Player player1 = new Player(PLAYER_1);

        Player player2 = new Player(PLAYER_2);

        Game game = new Game(player1, player2);

        int i = 0;

        while (game.getWinner() == null) {

            testSimpleDataSet.get(i);
            game.incrementScorePlayer(testSimpleDataSet.get(i) == 0);
            i++;
        }
        assertEquals(PLAYER_1, game.getWinner());
    }

    @Test
    public void testDeuceRule() { //( 40 - 40 )

        List<Integer> testDeuceRuleDataSet = new ArrayList<Integer>();

        testDeuceRuleDataSet.add(1); //1 point for player2
        // ( 0 - 15 )
        testDeuceRuleDataSet.add(0); //1 point for player1
        // ( 15 - 15 )
        testDeuceRuleDataSet.add(1); //1 point for player2
        // ( 15 - 30 )
        testDeuceRuleDataSet.add(0); //1 point for player1
        // ( 30 - 30 )
        testDeuceRuleDataSet.add(1); //1 point for player2
        // ( 30 - 40 )
        testDeuceRuleDataSet.add(0); //1 point for player1 => Test Deuce Rule
        // ( 40 - 40 )
        testDeuceRuleDataSet.add(1); //1 point for player2
        //( 40 - ADV )
        testDeuceRuleDataSet.add(0); //1 point for player1
        // ( 40 - 40 )
        testDeuceRuleDataSet.add(1); //1 point for player2
        // ( 40 - ADV )
        testDeuceRuleDataSet.add(1); //1 point for player2
        //  WIN for Player 2

        Player player1 = new Player(PLAYER_1);

        Player player2 = new Player(PLAYER_2);

        Game game = new Game(player1, player2);

        int i = 0;

        while (game.getWinner() == null) {

            testDeuceRuleDataSet.get(i);
            game.incrementScorePlayer(testDeuceRuleDataSet.get(i) == 0);
            i++;
        }
        assertEquals(PLAYER_2, game.getWinner());
    }

    @Test
    public void testQuickestMatchWin() { // Score ( 6 - 0 )

        List<Integer> quickestSetWinDataSetP1 = new ArrayList<Integer>();

        quickestSetWinDataSetP1.add(1); //1 point for player2
        // ( 0 - 15 )
        quickestSetWinDataSetP1.add(0); //1 point for player1
        // ( 15 - 15 )
        quickestSetWinDataSetP1.add(1); //1 point for player2
        // ( 15 - 30 )
        quickestSetWinDataSetP1.add(0); // 1 point for player1
        // ( 30 - 30 )
        quickestSetWinDataSetP1.add(0); // 1 point for player1
        // ( 40 - 30 )
        quickestSetWinDataSetP1.add(0); // 1 point for player1
        //  Player1 wins

        Player player1 = new Player(PLAYER_1);

        Player player2 = new Player(PLAYER_2);

        Game game = new Game(player1, player2);

        Set set = new Set(player1, player2);

        int i = 0;
        for (int index = 0; index < 6; index++) {
            while (game.getWinner() == null) {
                quickestSetWinDataSetP1.get(i);
                game.incrementScorePlayer(quickestSetWinDataSetP1.get(i) == 0);
                i++;
            }
            i = 0;
            set.incrementSetScorePlayer(game.getWinner());
            set.displaySetScore();
            game.resetWinner();
        }
        assertEquals(PLAYER_1, set.getWinner());
    }

    @Test
    public void testTieBreakWin() { // Score ( 6 - 6 ) (8 - 10)

        List<Integer> quickestSetWinDataSetP1 = new ArrayList<Integer>();

        quickestSetWinDataSetP1.add(1); //1 point for player2
        // ( 0 - 15 )
        quickestSetWinDataSetP1.add(0); //1 point for player1
        // ( 15 - 15 )
        quickestSetWinDataSetP1.add(1); //1 point for player2
        // ( 15 - 30 )
        quickestSetWinDataSetP1.add(0); // 1 point for player1
        // ( 30 - 30 )
        quickestSetWinDataSetP1.add(0); // 1 point for player1
        // ( 40 - 30 )
        quickestSetWinDataSetP1.add(0); // 1 point for player1
        //  Player1 wins

        List<Integer> quickestSetWinDataSetP2 = new ArrayList<Integer>();

        quickestSetWinDataSetP2.add(1); //1 point for player2
        // ( 0 - 15 )
        quickestSetWinDataSetP2.add(0); //1 point for player1
        // ( 15 - 15 )
        quickestSetWinDataSetP2.add(1); //1 point for player2
        // ( 15 - 30 )
        quickestSetWinDataSetP2.add(1); // 1 point for player2
        // ( 15 - 40 )
        quickestSetWinDataSetP2.add(1); // 1 point for player2
        //  Player2 wins

        Player player1 = new Player(PLAYER_1);

        Player player2 = new Player(PLAYER_2);

        Game game = new Game(player1, player2);
        Set set = new Set(player1, player2);

        int i = 0;

        for (int index = 0; index < 14; index++) {
            while (game.getWinner() == null) {
                quickestSetWinDataSetP1.get(i);
                game.incrementScorePlayer(quickestSetWinDataSetP1.get(i) == 0);
                i++;
            }
            i = 0;
            set.incrementSetScorePlayer(game.getWinner());
            set.displaySetScore();
            System.out.println("###### GAME1 " + game.getWinner());
            game.resetWinner();
            System.out.println("###### SET1 " + set.getWinner());
            while (game.getWinner() == null) {
                quickestSetWinDataSetP2.get(i);
                game.incrementScorePlayer(quickestSetWinDataSetP2.get(i) == 0);
                i++;
            }
            i = 0;
            set.incrementSetScorePlayer(game.getWinner());
            set.displaySetScore();
            System.out.println("###### SET1 " + set.getWinner());
            System.out.println("###### GAME2 " + game.getWinner());

            game.resetWinner();
        }
        //Current Set Score is: ( 6 - 6 )
        //
        //Tie Break Score is: ( 8 - 9 )

        while (game.getWinner() == null) {
            quickestSetWinDataSetP2.get(i);
            game.incrementScorePlayer(quickestSetWinDataSetP2.get(i) == 0);
            i++;
        }
        i = 0;
        set.incrementSetScorePlayer(game.getWinner());
        set.displaySetScore();
        System.out.println("###### GAME1 " + game.getWinner());
        game.resetWinner();
        System.out.println("###### SET1 " + set.getWinner());

        //Current Set Score is: ( 6 - 6 )
        //
        //Tie Break Score is: ( 8 - 10 )
        assertEquals(PLAYER_2, set.getWinner());
    }

}
