package com.ismaillagouilly.tennis;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ismail Lagouilly.
 */

public class MatchTest {

    private String PLAYER_1 = "player1";
    private String PLAYER_2 = "player2";

    @Test
    public void testQuickestMatchWinP1_3_0() {  // Sought Match result ( 3 - 0 )

        DisplayInformationImpl displayScoresImplSystemOut = new DisplayInformationImpl();
        Player player1 = new Player(PLAYER_1);
        Player player2 = new Player(PLAYER_2);
        Match match = new Match(player1, player2);
        Integer matchIndex = 0;

        while (matchIndex < 3) {
            match.setCurrentSet(new Set(player1, player2));
            List<Player> testQuickestGameWinP1 = new ArrayList<>();
            testQuickestGameWinP1.add(player1); // ( 15 - 0 )
            testQuickestGameWinP1.add(player1); // ( 30 - 0 )
            testQuickestGameWinP1.add(player1); // ( 40 - 0 )
            testQuickestGameWinP1.add(player1); // => Win

            while (match.getCurrentSet().getWinner() == null) {
                match.getCurrentSet().setCurrentGame(new Game(player1, player2));
                for (Player player : testQuickestGameWinP1) {
                    match.getCurrentSet().getCurrentGame().incrementGameScorePlayer(player, displayScoresImplSystemOut);
                    match.getCurrentSet().getCurrentGame().displayGameScore(displayScoresImplSystemOut);
                }
                match.getCurrentSet().incrementSetScorePlayer(match.getCurrentSet().getCurrentGame().getWinner());
            }
            match.incrementMatchScorePlayer(match.getCurrentSet().getWinner());
            matchIndex++;
        }
        // Ensure Player1 wins the Match
        assertEquals(player1, match.getWinner());
    }

    @Test
    public void testQuickestMatchWinP2_0_3() {  // Sought Match result ( 0 - 3 )

        DisplayInformationImpl displayScoresImplSystemOut = new DisplayInformationImpl();
        Player player1 = new Player(PLAYER_1);
        Player player2 = new Player(PLAYER_2);
        Match match = new Match(player1, player2);
        Integer matchIndex = 0;

        while (matchIndex < 3) {
            match.setCurrentSet(new Set(player1, player2));
            List<Player> testQuickestGameWinP1 = new ArrayList<>();
            testQuickestGameWinP1.add(player2); // ( 0 - 15 )
            testQuickestGameWinP1.add(player2); // ( 0 - 30 )
            testQuickestGameWinP1.add(player2); // ( 0 - 40 )
            testQuickestGameWinP1.add(player2); // => Win

            while (match.getCurrentSet().getWinner() == null) {
                match.getCurrentSet().setCurrentGame(new Game(player1, player2));
                for (Player player : testQuickestGameWinP1) {
                    match.getCurrentSet().getCurrentGame().incrementGameScorePlayer(player, displayScoresImplSystemOut);
                    match.getCurrentSet().getCurrentGame().displayGameScore(displayScoresImplSystemOut);
                }
                match.getCurrentSet().incrementSetScorePlayer(match.getCurrentSet().getCurrentGame().getWinner());
            }
            match.incrementMatchScorePlayer(match.getCurrentSet().getWinner());
            matchIndex++;
        }
        // Ensure Player2 wins the Match
        assertEquals(player2, match.getWinner());
    }
}
