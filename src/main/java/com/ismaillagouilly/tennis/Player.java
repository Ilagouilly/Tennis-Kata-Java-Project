package com.ismaillagouilly.tennis;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Ismail Lagouilly.
 */

/* ********************************************************************************* */
/*                                                                                   */
/*  Player Class                                                                     */
/*                                                                                   */
/*  Manages players of a Game, Set or a Tennis Match.                                */
/*                                                                                   */
/*   The class uses Lombok a java library to automatically generate                  */
/*   Getters & Setters. More information on the link: https://www.projectlombok.org/ */
/*                                                                                   */
/* ********************************************************************************* */

@Getter
@Setter
public class Player {

    private String username;

    public Player(String username) {

        this.username = username;
    }

}
