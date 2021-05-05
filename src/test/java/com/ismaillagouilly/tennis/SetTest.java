package com.ismaillagouilly.tennis;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ismail Lagouilly.
 */

public class SetTest {

    private String PLAYER_1 = "player1";
    private String PLAYER_2 = "player2";

    @Test
    public void testQuickestSetWinP1_6_0() {  // Sought Set result ( 6 - 0 )

        DisplayInformationImpl displayScoresImplSystemOut = new DisplayInformationImpl();
        Player player1 = new Player(PLAYER_1);
        Player player2 = new Player(PLAYER_2);
        Set set = new Set(player1, player2);

        List<Player> testQuickestGameWinP1 = new ArrayList<>();
        testQuickestGameWinP1.add(player1); // ( 15 - 0 )
        testQuickestGameWinP1.add(player1); // ( 30 - 0 )
        testQuickestGameWinP1.add(player1); // ( 40 - 0 )
        testQuickestGameWinP1.add(player1); // => Win

        while (set.getWinner() == null) {
            set.setCurrentGame(new Game(player1, player2));
            for (Player player : testQuickestGameWinP1) {
                set.getCurrentGame().incrementGameScorePlayer(player, displayScoresImplSystemOut);
                set.getCurrentGame().displayGameScore(displayScoresImplSystemOut);
            }
            set.incrementSetScorePlayer(set.getCurrentGame().getWinner());
        }

        // Ensure Player1 wins the set
        assertEquals(player1, set.getWinner());
    }

    @Test
    public void testQuickestSetWinP2_0_6() {  // Sought Set result ( 0 - 6 )

        DisplayInformationImpl displayScoresImplSystemOut = new DisplayInformationImpl();
        Player player1 = new Player(PLAYER_1);
        Player player2 = new Player(PLAYER_2);
        Set set = new Set(player1, player2);

        List<Player> testQuickestGameWinP2 = new ArrayList<>();
        testQuickestGameWinP2.add(player2); // ( 0 - 15 )
        testQuickestGameWinP2.add(player2); // ( 0 - 30 )
        testQuickestGameWinP2.add(player2); // ( 0 - 40 )
        testQuickestGameWinP2.add(player2); // => Win

        while (set.getWinner() == null) {
            set.setCurrentGame(new Game(player1, player2));
            for (Player player : testQuickestGameWinP2) {
                set.getCurrentGame().incrementGameScorePlayer(player, displayScoresImplSystemOut);
                set.getCurrentGame().displayGameScore(displayScoresImplSystemOut);
            }
            set.incrementSetScorePlayer(set.getCurrentGame().getWinner());
        }

        // Ensure Player2 wins the set
        assertEquals(player2, set.getWinner());
    }

    @Test
    public void testSetWinP1_7_5() {  // Sought Set result ( 7 - 5 )

        DisplayInformationImpl displayScoresImplSystemOut = new DisplayInformationImpl();
        Player player1 = new Player(PLAYER_1);
        Player player2 = new Player(PLAYER_2);
        Set set = new Set(player1, player2);

        List<Player> testQuickestGameWinP1 = new ArrayList<>();
        testQuickestGameWinP1.add(player1); // ( 15 - 0 )
        testQuickestGameWinP1.add(player1); // ( 30 - 0 )
        testQuickestGameWinP1.add(player1); // ( 40 - 0 )
        testQuickestGameWinP1.add(player1); // => Win

        List<Player> testQuickestGameWinP2 = new ArrayList<>();
        testQuickestGameWinP2.add(player2); // ( 0 - 15 )
        testQuickestGameWinP2.add(player2); // ( 0 - 30 )
        testQuickestGameWinP2.add(player2); // ( 0 - 40 )
        testQuickestGameWinP2.add(player2); // => Win

        Integer setIndex = 0;
        while (set.getWinner() == null) {
            set.setCurrentGame(new Game(player1, player2));
            for (Player player : testQuickestGameWinP1) {
                set.getCurrentGame().incrementGameScorePlayer(player, displayScoresImplSystemOut);
                set.getCurrentGame().displayGameScore(displayScoresImplSystemOut);
            }
            set.incrementSetScorePlayer(set.getCurrentGame().getWinner());
            // We stop incrementing set scores when player2 reaches score 5
            if (setIndex < 5) {
                set.setCurrentGame(new Game(player1, player2));
                for (Player player : testQuickestGameWinP2) {
                    set.getCurrentGame().incrementGameScorePlayer(player, displayScoresImplSystemOut);
                    set.getCurrentGame().displayGameScore(displayScoresImplSystemOut);
                }
                set.incrementSetScorePlayer(set.getCurrentGame().getWinner());
            }
            setIndex++;
            set.displaySetScore(displayScoresImplSystemOut);
        }

        // Ensure Player1 wins the set
        assertEquals(player1, set.getWinner());
    }

    @Test
    public void testSetWinP2_5_7() {  // Sought Set result ( 5 - 7 )

        DisplayInformationImpl displayScoresImplSystemOut = new DisplayInformationImpl();
        Player player1 = new Player(PLAYER_1);
        Player player2 = new Player(PLAYER_2);
        Set set = new Set(player1, player2);

        List<Player> testQuickestGameWinP1 = new ArrayList<>();
        testQuickestGameWinP1.add(player1); // ( 15 - 0 )
        testQuickestGameWinP1.add(player1); // ( 30 - 0 )
        testQuickestGameWinP1.add(player1); // ( 40 - 0 )
        testQuickestGameWinP1.add(player1); // => Win

        List<Player> testQuickestGameWinP2 = new ArrayList<>();
        testQuickestGameWinP2.add(player2); // ( 0 - 15 )
        testQuickestGameWinP2.add(player2); // ( 0 - 30 )
        testQuickestGameWinP2.add(player2); // ( 0 - 40 )
        testQuickestGameWinP2.add(player2); // => Win

        Integer setIndex = 0;
        while (set.getWinner() == null) {
            // We stop incrementing set scores when player1 reaches score 5
            if (setIndex < 5) {
                set.setCurrentGame(new Game(player1, player2));
                for (Player player : testQuickestGameWinP1) {
                    set.getCurrentGame().incrementGameScorePlayer(player, displayScoresImplSystemOut);
                    set.getCurrentGame().displayGameScore(displayScoresImplSystemOut);
                }
                set.incrementSetScorePlayer(set.getCurrentGame().getWinner());
            }
            set.setCurrentGame(new Game(player1, player2));
            for (Player player : testQuickestGameWinP2) {
                set.getCurrentGame().incrementGameScorePlayer(player, displayScoresImplSystemOut);
                set.getCurrentGame().displayGameScore(displayScoresImplSystemOut);
            }
            set.incrementSetScorePlayer(set.getCurrentGame().getWinner());
            setIndex++;
            set.displaySetScore(displayScoresImplSystemOut);
        }
        // Ensure Player2 wins the set
        assertEquals(player2, set.getWinner());
    }

    @Test
    public void testSetWinP1_6_6_tieBreak() {  // Sought Set result ( 6 - 6 ) Tie Break (7 - 0)

        DisplayInformationImpl displayScoresImplSystemOut = new DisplayInformationImpl();
        Player player1 = new Player(PLAYER_1);
        Player player2 = new Player(PLAYER_2);
        Set set = new Set(player1, player2);

        List<Player> testQuickestGameWinP1 = new ArrayList<>();
        testQuickestGameWinP1.add(player1); // ( 15 - 0 )
        testQuickestGameWinP1.add(player1); // ( 30 - 0 )
        testQuickestGameWinP1.add(player1); // ( 40 - 0 )
        testQuickestGameWinP1.add(player1); // => Win

        List<Player> testQuickestGameWinP2 = new ArrayList<>();
        testQuickestGameWinP2.add(player2); // ( 0 - 15 )
        testQuickestGameWinP2.add(player2); // ( 0 - 30 )
        testQuickestGameWinP2.add(player2); // ( 0 - 40 )
        testQuickestGameWinP2.add(player2); // => Win

        List<Player> testTieBreakP1 = new ArrayList<>();
        testTieBreakP1.add(player1); // ( 1 - 0 )
        testTieBreakP1.add(player1); // ( 2 - 0 )
        testTieBreakP1.add(player1); // ( 3 - 0 )
        testTieBreakP1.add(player1); // ( 4 - 0 )
        testTieBreakP1.add(player1); // ( 5 - 0 )
        testTieBreakP1.add(player1); // ( 6 - 0 )
        testTieBreakP1.add(player1); // ( 7 - 0 ) => Win

        Integer setIndex = 0;
        // We stop incrementing set scores when scores reach score ( 6 - 6)
        while (set.getWinner() == null && setIndex < 6) {
            set.setCurrentGame(new Game(player1, player2));
            for (Player player : testQuickestGameWinP1) {
                set.getCurrentGame().incrementGameScorePlayer(player, displayScoresImplSystemOut);
            }
            set.incrementSetScorePlayer(set.getCurrentGame().getWinner());
            set.setCurrentGame(new Game(player1, player2));
            for (Player player : testQuickestGameWinP2) {
                set.getCurrentGame().incrementGameScorePlayer(player, displayScoresImplSystemOut);
            }
            set.incrementSetScorePlayer(set.getCurrentGame().getWinner());
            setIndex++;
        }

        // Play Tie Break game
        for (Player player : testTieBreakP1) {
            set.incrementSetScorePlayer(player);
        }

        // Ensure Player1 wins the set
        assertEquals(player1, set.getWinner());
    }

    @Test
    public void testSetWinP2_6_6_tieBreak() {  // Sought Set result ( 6 - 6 ) Tie Break (0 - 7)

        DisplayInformationImpl displayScoresImplSystemOut = new DisplayInformationImpl();
        Player player1 = new Player(PLAYER_1);
        Player player2 = new Player(PLAYER_2);
        Set set = new Set(player1, player2);

        List<Player> testQuickestGameWinP1 = new ArrayList<>();
        testQuickestGameWinP1.add(player1); // ( 15 - 0 )
        testQuickestGameWinP1.add(player1); // ( 30 - 0 )
        testQuickestGameWinP1.add(player1); // ( 40 - 0 )
        testQuickestGameWinP1.add(player1); // => Win

        List<Player> testQuickestGameWinP2 = new ArrayList<>();
        testQuickestGameWinP2.add(player2); // ( 0 - 15 )
        testQuickestGameWinP2.add(player2); // ( 0 - 30 )
        testQuickestGameWinP2.add(player2); // ( 0 - 40 )
        testQuickestGameWinP2.add(player2); // => Win

        List<Player> testTieBreakP2 = new ArrayList<>();
        testTieBreakP2.add(player2); // ( 0 - 1 )
        testTieBreakP2.add(player2); // ( 0 - 2 )
        testTieBreakP2.add(player2); // ( 0 - 3 )
        testTieBreakP2.add(player2); // ( 0 - 4 )
        testTieBreakP2.add(player2); // ( 0 - 5 )
        testTieBreakP2.add(player2); // ( 0 - 6 )
        testTieBreakP2.add(player2); // ( 0 - 7 ) => Win

        Integer setIndex = 0;
        // We stop incrementing set scores when scores reach score ( 6 - 6)
        while (set.getWinner() == null && setIndex < 6) {
            set.setCurrentGame(new Game(player1, player2));
            for (Player player : testQuickestGameWinP1) {
                set.getCurrentGame().incrementGameScorePlayer(player, displayScoresImplSystemOut);
            }
            set.incrementSetScorePlayer(set.getCurrentGame().getWinner());
            set.setCurrentGame(new Game(player1, player2));
            for (Player player : testQuickestGameWinP2) {
                set.getCurrentGame().incrementGameScorePlayer(player, displayScoresImplSystemOut);
            }
            set.incrementSetScorePlayer(set.getCurrentGame().getWinner());
            setIndex++;
        }

        // Play Tie Break game until score ( 0 - 7 )
        for (Player player : testTieBreakP2) {
            set.incrementSetScorePlayer(player);
        }

        // Ensure Player2 wins the set
        assertEquals(player2, set.getWinner());
    }

    @Test
    public void testSetWinP1_6_6_tieBreak_extended() {  // Sought Set result ( 6 - 6 ) Tie Break (7 - 0)

        DisplayInformationImpl displayScoresImplSystemOut = new DisplayInformationImpl();
        Player player1 = new Player(PLAYER_1);
        Player player2 = new Player(PLAYER_2);
        Set set = new Set(player1, player2);

        List<Player> testQuickestGameWinP1 = new ArrayList<>();
        testQuickestGameWinP1.add(player1); // ( 15 - 0 )
        testQuickestGameWinP1.add(player1); // ( 30 - 0 )
        testQuickestGameWinP1.add(player1); // ( 40 - 0 )
        testQuickestGameWinP1.add(player1); // => Win

        List<Player> testQuickestGameWinP2 = new ArrayList<>();
        testQuickestGameWinP2.add(player2); // ( 0 - 15 )
        testQuickestGameWinP2.add(player2); // ( 0 - 30 )
        testQuickestGameWinP2.add(player2); // ( 0 - 40 )
        testQuickestGameWinP2.add(player2); // => Win

        List<Player> testTieBreakP1 = new ArrayList<>();
        testTieBreakP1.add(player1); // ( 1 - 0 )
        testTieBreakP1.add(player2); // ( 1 - 1 )
        testTieBreakP1.add(player1); // ( 2 - 1 )
        testTieBreakP1.add(player2); // ( 2 - 2 )
        testTieBreakP1.add(player1); // ( 3 - 2 )
        testTieBreakP1.add(player2); // ( 3 - 3 )
        testTieBreakP1.add(player1); // ( 4 - 3 )
        testTieBreakP1.add(player2); // ( 4 - 4 )
        testTieBreakP1.add(player1); // ( 5 - 4 )
        testTieBreakP1.add(player2); // ( 5 - 5 )
        testTieBreakP1.add(player1); // ( 6 - 5 )
        testTieBreakP1.add(player2); // ( 6 - 6 )
        testTieBreakP1.add(player1); // ( 7 - 6 )
        testTieBreakP1.add(player2); // ( 7 - 7 )
        testTieBreakP1.add(player1); // ( 8 - 7 )
        testTieBreakP1.add(player1); // ( 9 - 7 ) => Win

        Integer setIndex = 0;
        // We stop incrementing set scores when scores reach score ( 6 - 6)
        while (set.getWinner() == null && setIndex < 6) {
            set.setCurrentGame(new Game(player1, player2));
            for (Player player : testQuickestGameWinP1) {
                set.getCurrentGame().incrementGameScorePlayer(player, displayScoresImplSystemOut);
            }
            set.incrementSetScorePlayer(set.getCurrentGame().getWinner());
            set.setCurrentGame(new Game(player1, player2));
            for (Player player : testQuickestGameWinP2) {
                set.getCurrentGame().incrementGameScorePlayer(player, displayScoresImplSystemOut);
            }
            set.incrementSetScorePlayer(set.getCurrentGame().getWinner());
            setIndex++;
        }

        // Play Tie Break game
        for (Player player : testTieBreakP1) {
            set.incrementSetScorePlayer(player);
        }

        // Ensure Player1 wins the set
        assertEquals(player1, set.getWinner());
    }

    @Test
    public void testSetWinP2_6_6_tieBreak_extended() {  // Sought Set result ( 6 - 6 ) Tie Break (0 - 7)

        DisplayInformationImpl displayScoresImplSystemOut = new DisplayInformationImpl();
        Player player1 = new Player(PLAYER_1);
        Player player2 = new Player(PLAYER_2);
        Set set = new Set(player1, player2);

        List<Player> testQuickestGameWinP1 = new ArrayList<>();
        testQuickestGameWinP1.add(player1); // ( 15 - 0 )
        testQuickestGameWinP1.add(player1); // ( 30 - 0 )
        testQuickestGameWinP1.add(player1); // ( 40 - 0 )
        testQuickestGameWinP1.add(player1); // => Win

        List<Player> testQuickestGameWinP2 = new ArrayList<>();
        testQuickestGameWinP2.add(player2); // ( 0 - 15 )
        testQuickestGameWinP2.add(player2); // ( 0 - 30 )
        testQuickestGameWinP2.add(player2); // ( 0 - 40 )
        testQuickestGameWinP2.add(player2); // => Win

        List<Player> testTieBreakP2 = new ArrayList<>();
        testTieBreakP2.add(player1); // ( 1 - 0 )
        testTieBreakP2.add(player2); // ( 1 - 1 )
        testTieBreakP2.add(player1); // ( 2 - 1 )
        testTieBreakP2.add(player2); // ( 2 - 2 )
        testTieBreakP2.add(player1); // ( 3 - 2 )
        testTieBreakP2.add(player2); // ( 3 - 3 )
        testTieBreakP2.add(player1); // ( 4 - 3 )
        testTieBreakP2.add(player2); // ( 4 - 4 )
        testTieBreakP2.add(player1); // ( 5 - 4 )
        testTieBreakP2.add(player2); // ( 5 - 5 )
        testTieBreakP2.add(player1); // ( 6 - 5 )
        testTieBreakP2.add(player2); // ( 6 - 6 )
        testTieBreakP2.add(player1); // ( 7 - 6 )
        testTieBreakP2.add(player2); // ( 7 - 7 )
        testTieBreakP2.add(player2); // ( 7 - 8 )
        testTieBreakP2.add(player2); // ( 7 - 9 ) => Win

        Integer setIndex = 0;
        // We stop incrementing set scores when scores reach score ( 6 - 6)
        while (set.getWinner() == null && setIndex < 6) {
            set.setCurrentGame(new Game(player1, player2));
            for (Player player : testQuickestGameWinP1) {
                set.getCurrentGame().incrementGameScorePlayer(player, displayScoresImplSystemOut);
            }
            set.incrementSetScorePlayer(set.getCurrentGame().getWinner());
            set.setCurrentGame(new Game(player1, player2));
            for (Player player : testQuickestGameWinP2) {
                set.getCurrentGame().incrementGameScorePlayer(player, displayScoresImplSystemOut);
            }
            set.incrementSetScorePlayer(set.getCurrentGame().getWinner());
            setIndex++;
        }

        // Play Tie Break game until score ( 0 - 7 )
        for (Player player : testTieBreakP2) {
            set.incrementSetScorePlayer(player);
        }

        // Ensure Player2 wins the set
        assertEquals(player2, set.getWinner());
    }
}
