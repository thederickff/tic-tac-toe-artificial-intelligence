/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.derick.tictactoe.model;

import com.derick.tictactoe.controller.GameController;
import java.util.Random;

/**
 *
 * @author derickfelix
 */
public class Enemy extends Players {

    private Random random;
    private boolean firstGuest;
    private String blank;

    public Enemy(String name) {
        super(name);
        this.playing = true;
        this.type = "O";
        this.firstGuest = true;
        this.random = new Random();
        this.blank = " ";
    }

    public void update(GameController game) {

        if (firstGuest) {
            randGuest(game.getTable());
        } else {
            defense(game.getTable());
        }

    }

    private void defense(String[][] table) {

        /*  #  0  1  2
         *  0 [ ][ ][ ]
         *  1 [ ][X][ ]
         *  2 [X][ ][ ]  */
        if (!table[2][0].equals(this.type) && !table[2][0].equals(blank)
                && !table[1][1].equals(this.type) && !table[1][1].equals(blank)) {
            // Check if the wished places is blank
            if (table[0][2].equals(blank)) {
                // then pressButton
                pressButton(table, this.type, 0, 2);
            }
        }

        /*  #  0  1  2
         *  0 [ ][ ][X]
         *  1 [ ][ ][ ]
         *  2 [X][ ][ ]  */
        if (!table[0][2].equals(this.type) && !table[0][2].equals(blank)
                && !table[2][0].equals(this.type) && !table[2][0].equals(blank)) {
            // Check if the wished places is blank
            if (table[1][1].equals(blank)) {
                // then pressButton
                pressButton(table, this.type, 1, 1);
            }
        }

        /*  #  0  1  2
         *  0 [ ][ ][X]
         *  1 [ ][X][ ]
         *  2 [ ][ ][ ]  */
        if (!table[0][2].equals(this.type) && !table[0][2].equals(blank)
                && !table[1][1].equals(this.type) && !table[1][1].equals(blank)) {
            // Check if the wished places is blank
            if (table[2][0].equals(blank)) {
                // then pressButton
                pressButton(table, this.type, 2, 0);
            }
        }

        // ************************************************************
        /*  #  0  1  2
         *  0 [X][ ][ ]
         *  1 [ ][X][ ]
         *  2 [ ][ ][ ]  */
        if (!table[0][0].equals(this.type) && !table[0][0].equals(blank)
                && !table[1][1].equals(this.type) && !table[1][1].equals(blank)) {
            // Check if the wished places is blank
            if (table[2][2].equals(blank)) {
                // then pressButton
                pressButton(table, this.type, 2, 2);
                System.out.println("defense");
            }
        }

        /*  #  0  1  2
         *  0 [X][ ][ ]
         *  1 [ ][ ][ ]
         *  2 [ ][ ][X]  */
        if (!table[0][0].equals(this.type) && !table[0][0].equals(blank)
                && !table[2][2].equals(this.type) && !table[2][2].equals(blank)) {
            // Check if the wished places is blank
            if (table[1][1].equals(blank)) {
                // then pressButton
                pressButton(table, this.type, 1, 1);
                System.out.println("defense");
            }
        }

        /*  #  0  1  2
         *  0 [ ][ ][ ]
         *  1 [ ][X][ ]
         *  2 [ ][ ][X]  */
        if (!table[1][1].equals(this.type) && !table[1][1].equals(blank)
                && !table[2][2].equals(this.type) && !table[2][2].equals(blank)) {
            // Check if the wished places is blank
            if (table[0][0].equals(blank)) {
                // then pressButton
                pressButton(table, this.type, 0, 0);
                System.out.println("defense");
            }
        }

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
            // Check if it is machine's turn
            if (playing) {
                // Check if the place given weren't used yet
                if (!table[i][j].equals("X") && !table[i][j].equals("O")) {
                    table[i][j] = guest;
                    this.playing = false;
                } else {
                    randGuest(table);
                }
            }
        } else {
            System.out.println("Error: PLACES GIVEN OUT OF BOUND!");
        }
    }

}
