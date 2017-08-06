/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.derick.tictactoe.model;

/**
 *
 * @author derickfelix
 */
public class Player extends Players {
    
    public Player(String name) {
        super(name);
        this.playing = true;
        this.type = "X";
    }
    
}
