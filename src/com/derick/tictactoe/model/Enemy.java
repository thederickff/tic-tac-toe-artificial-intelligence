/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.derick.tictactoe.model;

import com.derick.tictactoe.controller.GameController;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author derickfelix
 */
public class Enemy extends Players {

    private Random random;
    private boolean firstGuest;

    public Enemy(String name) {
        super(name);
        this.playing = false;
        this.type = "O";
        this.firstGuest = true;
        this.random = new Random();
    }

    public void update(GameController game) {

        if (firstGuest) {
            randGuest(game.getTable());
        } else {
            defense(game.getTable());
        }

    }
    private void defense(String[][] table) {
        
        
        
    }
    private void attack(String[][] table) {
        
    }
    private void randGuest(String[][] table) {
        int randRow = random.nextInt(3);
        int randCol = random.nextInt(3);

        pressButton(table, this.type, randRow, randCol);
        
        if (firstGuest) {
            this.firstGuest = false;
        }
    }

    @Override
    public void pressButton(String[][] table, String guest, int i, int j) {
        // Check if the places is out of bound                
        if (i < 3 && j < 3) {
            // Check if the place given weren't used yet
            if (!table[i][j].equals("X") && !table[i][j].equals("O")) {
                table[i][j] = guest;
            } else {
                randGuest(table);
            }
        } else {
            System.out.println("Error: PLACES GIVEN OUT OF BOUND!");
        }
    }

}
