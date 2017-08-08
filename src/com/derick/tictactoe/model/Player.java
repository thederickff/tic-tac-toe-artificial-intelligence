/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.derick.tictactoe.model;

import java.awt.Color;
/**
 *
 * @author derickfelix
 */
public class Player extends Players {
    
    public Player(String name) {
        super(name);
        this.playing = false;
        this.type = "X";
        this.color = Color.green.darker();
    }
    
    @Override
    public void pressButton(String[][] table, String guest, int i, int j) {
        // Check if the places is out of bound
        if (i < 3 && j < 3) {
            // Check if the place given weren't used yet
            if (!table[i][j].equals("X") && !table[i][j].equals("O")) {
                table[i][j] = guest;
                this.playing = false;
            } else {
                System.out.println("Error: YOU CANNOT GUEST HERE!");
            }
        } else {
            System.out.println("Error: PLACES GIVEN OUT OF BOUND!");
        }
    }
}
