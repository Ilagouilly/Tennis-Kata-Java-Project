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
    public void testQuickestGameWinP1() {  // Sought game result ( 40 - 0 )

        List<Integer> testQuickestGameWinP1 = new ArrayList<Integer>();

        testQuickestGameWinP1.add(0); // ( 15 - 0 )
        testQuickestGameWinP1.add(0); // ( 30 - 0 )
        testQuickestGameWinP1.add(0); // ( 40 - 0 )
        testQuickestGameWinP1.add(0); // => Win

        Player player1 = new Player(PLAYER_1);

        Player player2 = new Player(PLAYER_2);

        Game game = new Game(player1, player2);

        int i = 0;

        while (game.getWinner() == null) {

            testQuickestGameWinP1.get(i);
            game.incrementScorePlayer(testQuickestGameWinP1.get(i) == 0);
            i++;
        }
        assertEquals(PLAYER_1, game.getWinner());
    }

    @Test
    public void testQuickestGameWinP2() {  // Sought game result ( 0 - 40 )

        List<Integer> testQuickestGameWinP2 = new ArrayList<Integer>();

        testQuickestGameWinP2.add(1); // ( 0 - 15 )
        testQuickestGameWinP2.add(1); // ( 0 - 30 )
        testQuickestGameWinP2.add(1); // ( 0 - 40 )
        testQuickestGameWinP2.add(1); // => Win

        Player player1 = new Player(PLAYER_1);

        Player player2 = new Player(PLAYER_2);

        Game game = new Game(player1, player2);

        int i = 0;

        while (game.getWinner() == null) {

            testQuickestGameWinP2.get(i);
            game.incrementScorePlayer(testQuickestGameWinP2.get(i) == 0);
            i++;
        }
        assertEquals(PLAYER_2, game.getWinner()); // Assure that Player2 wins
    }

    @Test
    public void testSimpleGameWinP1() { // Sought game result ( AVT - 30 )

        List<Integer> testSimpleGameWinP1 = new ArrayList<Integer>();

        testSimpleGameWinP1.add(1); // ( 0 - 15 )
        testSimpleGameWinP1.add(0); // ( 15 - 15 )
        testSimpleGameWinP1.add(0); // ( 30 - 15 )
        testSimpleGameWinP1.add(0); // ( 40 - 15 )
        testSimpleGameWinP1.add(1); // ( 40 - 30 )
        testSimpleGameWinP1.add(0); // ( AVT - 30 ) => Win

        Player player1 = new Player(PLAYER_1);

        Player player2 = new Player(PLAYER_2);

        Game game = new Game(player1, player2);

        int i = 0;

        while (game.getWinner() == null) {

            testSimpleGameWinP1.get(i);
            game.incrementScorePlayer(testSimpleGameWinP1.get(i) == 0);
            i++;
        }
        assertEquals(PLAYER_1, game.getWinner()); // Assure that Player1 wins
    }

    @Test
    public void testSimpleGameWinP2() { // Sought game result ( 30 - AVT )

        List<Integer> testSimpleGameWinP1 = new ArrayList<Integer>();

        testSimpleGameWinP1.add(0); // ( 15 - 0 )
        testSimpleGameWinP1.add(1); // ( 15 - 15 )
        testSimpleGameWinP1.add(1); // ( 15 - 30 )
        testSimpleGameWinP1.add(1); // ( 15 - 40 )
        testSimpleGameWinP1.add(0); // ( 30 - 40 )
        testSimpleGameWinP1.add(1); // ( 30 - AVT ) => Win

        Player player1 = new Player(PLAYER_1);

        Player player2 = new Player(PLAYER_2);

        Game game = new Game(player1, player2);

        int i = 0;

        while (game.getWinner() == null) {

            testSimpleGameWinP1.get(i);
            game.incrementScorePlayer(testSimpleGameWinP1.get(i) == 0);
            i++;
        }
        assertEquals(PLAYER_2, game.getWinner()); // Assure that Player2 wins
    }

    @Test
    public void testDeuceRuleP1() { // Sought game result ( ADV - 40 )

        List<Integer> testDeuceRuleP1 = new ArrayList<Integer>();

        testDeuceRuleP1.add(0); //1 point for player1
        // ( 15 - 0 )
        testDeuceRuleP1.add(1); //1 point for player2
        // ( 15 - 15 )
        testDeuceRuleP1.add(0); //1 point for player1
        // ( 30 - 15 )
        testDeuceRuleP1.add(1); //1 point for player2
        // ( 30 - 30 )
        testDeuceRuleP1.add(0); //1 point for player1
        // ( 40 - 30 )
        testDeuceRuleP1.add(1); //1 point for player2 => Test Deuce Rule
        // ( 40 - 40 )
        testDeuceRuleP1.add(0); //1 point for player1
        // ( ADV - 40 )
        testDeuceRuleP1.add(1); //1 point for player2
        // ( 40 - 40 )
        testDeuceRuleP1.add(0); //1 point for player1
        // ( ADV - 40 )
        testDeuceRuleP1.add(0); //1 point for player1
        //  WIN for Player 1

        Player player1 = new Player(PLAYER_1);

        Player player2 = new Player(PLAYER_2);

        Game game = new Game(player1, player2);

        int i = 0;

        while (game.getWinner() == null) {

            testDeuceRuleP1.get(i);
            game.incrementScorePlayer(testDeuceRuleP1.get(i) == 0);
            i++;
        }
        assertEquals(PLAYER_1, game.getWinner()); // Assure that Player1 wins
    }

    @Test
    public void testDeuceRuleP2() { // Sought game result ( 40 - ADV )

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
        assertEquals(PLAYER_2, game.getWinner()); // Assure that Player2 wins
    }

    @Test
    public void testQuickestMatchWinP1() { // Sought Set result  ( 6 - 0 )

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
        assertEquals(PLAYER_1, set.getWinner()); // Assure that Player1 wins the set
    }

    @Test
    public void testQuickestMatchWinP2() { // Sought Set result  ( 0 - 6 )

        List<Integer> quickestSetWinDataSetP2 = new ArrayList<Integer>();

        quickestSetWinDataSetP2.add(0); //1 point for player1
        // ( 0 - 15 )
        quickestSetWinDataSetP2.add(1); //1 point for player2
        // ( 15 - 15 )
        quickestSetWinDataSetP2.add(0); //1 point for player1
        // ( 15 - 30 )
        quickestSetWinDataSetP2.add(1); // 1 point for player2
        // ( 30 - 30 )
        quickestSetWinDataSetP2.add(1); // 1 point for player2
        // ( 40 - 30 )
        quickestSetWinDataSetP2.add(1); // 1 point for player2
        //  Player2 wins the game

        Player player1 = new Player(PLAYER_1);

        Player player2 = new Player(PLAYER_2);

        Game game = new Game(player1, player2);

        Set set = new Set(player1, player2);

        int i = 0;
        for (int index = 0; index < 6; index++) {
            while (game.getWinner() == null) {
                quickestSetWinDataSetP2.get(i);
                game.incrementScorePlayer(quickestSetWinDataSetP2.get(i) == 0);
                i++;
            }
            i = 0;
            set.incrementSetScorePlayer(game.getWinner());
            set.displaySetScore();
            game.resetWinner();
        }
        assertEquals(PLAYER_2, set.getWinner()); // Assure that Player2 wins the set
    }

    @Test
    public void testTieBreakWinP1() { // Score ( 7 - 6 ) (10 - 8)

        List<Integer> testTieBreakWinP1 = new ArrayList<Integer>();

        testTieBreakWinP1.add(1); //1 point for player2
        // ( 0 - 15 )
        testTieBreakWinP1.add(0); //1 point for player1
        // ( 15 - 15 )
        testTieBreakWinP1.add(1); //1 point for player2
        // ( 15 - 30 )
        testTieBreakWinP1.add(0); // 1 point for player1
        // ( 30 - 30 )
        testTieBreakWinP1.add(0); // 1 point for player1
        // ( 40 - 30 )
        testTieBreakWinP1.add(0); // 1 point for player1
        //  Player1 wins

        List<Integer> testTieBreakWinP2 = new ArrayList<Integer>();

        testTieBreakWinP2.add(1); //1 point for player2
        // ( 0 - 15 )
        testTieBreakWinP2.add(0); //1 point for player1
        // ( 15 - 15 )
        testTieBreakWinP2.add(1); //1 point for player2
        // ( 15 - 30 )
        testTieBreakWinP2.add(1); // 1 point for player2
        // ( 15 - 40 )
        testTieBreakWinP2.add(1); // 1 point for player2
        //  Player2 wins

        Player player1 = new Player(PLAYER_1);

        Player player2 = new Player(PLAYER_2);

        Game game = new Game(player1, player2);
        Set set = new Set(player1, player2);

        int i = 0;

        for (int index = 0; index < 14; index++) {
            while (game.getWinner() == null) {
                testTieBreakWinP2.get(i);
                game.incrementScorePlayer(testTieBreakWinP2.get(i) == 0);
                i++;
            }
            i = 0;
            set.incrementSetScorePlayer(game.getWinner());
            set.displaySetScore();

            game.resetWinner();

            while (game.getWinner() == null) {
                testTieBreakWinP1.get(i);
                game.incrementScorePlayer(testTieBreakWinP1.get(i) == 0);
                i++;
            }
            i = 0;
            set.incrementSetScorePlayer(game.getWinner());
            set.displaySetScore();
            game.resetWinner();
        }
        //Current Set Score is: ( 6 - 6 )
        //
        //Tie Break Score is: ( 8 - 9 )

        while (game.getWinner() == null) {
            testTieBreakWinP1.get(i);
            game.incrementScorePlayer(testTieBreakWinP1.get(i) == 0);
            i++;
        }
        i = 0;
        set.incrementSetScorePlayer(game.getWinner());
        set.displaySetScore();
        game.resetWinner();

        //Current Set Score is: ( 6 - 6 )
        //
        //Tie Break Score is: ( 10 - 8 )
        assertEquals(PLAYER_1, set.getWinner()); // Assure that Player1 wins the set
    }

    @Test
    public void testTieBreakWinP2() { // Score ( 6 - 7 ) (8 - 10)

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
            game.resetWinner();
            while (game.getWinner() == null) {
                quickestSetWinDataSetP2.get(i);
                game.incrementScorePlayer(quickestSetWinDataSetP2.get(i) == 0);
                i++;
            }
            i = 0;
            set.incrementSetScorePlayer(game.getWinner());
            set.displaySetScore();

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
        game.resetWinner();

        //Current Set Score is: ( 6 - 7 )
        //
        //Tie Break Score is: ( 8 - 10 )
        assertEquals(PLAYER_2, set.getWinner()); // Assure that Player2 wins the set
    }

}
