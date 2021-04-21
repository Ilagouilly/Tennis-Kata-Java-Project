package com.ismaillagouilly.tennis;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ismail Lagouilly.
 */

@Getter
@Setter
public class Player {

    private String username;

    private Integer gameScore;

    private String gameScoreText;

    private Integer setScore;

    private Integer tieBreakScore;

    private List<String> pointsList = Arrays.asList("0", "15", "30", "40", "ADV");

    public Player(String username) {

        this.username = username;
        this.gameScore = 0;
        this.gameScoreText = "";
        this.setScore = 0;
        this.tieBreakScore = 0;
    }

    public void playerGameReset() {
        this.gameScore = 0;
        this.gameScoreText = "";
    }

    public String getScoreDescription() {
        return pointsList.get(gameScore);
    }

    public Integer incrementGameScore() {
        System.out.println(this.username + " has won 1 point!");
        return gameScore++;
    }

    public Integer incrementSetScore() {
        return setScore++;
    }

    public Integer incrementTieBreakScore() {
        return tieBreakScore++;
    }


}
