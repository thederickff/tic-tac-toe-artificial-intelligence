/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.derick.tictactoe.controller;

import com.derick.tictactoe.model.Enemy;
import com.derick.tictactoe.model.Player;
import com.derick.tictactoe.model.Players;
import javax.swing.JButton;

/**
 *
 * @author derickfelix
 */
public class GameController {

    // Tic tac toe 
    private String[][] table;
    private boolean running;
    private Enemy enemy;
    private Player player;

    public GameController(Player player) {
        // Initialize game as running
        this.running = true;
        // Initialize a 3x3 table
        this.table = new String[3][3];
        // Initialize the enemy
        this.enemy = new Enemy("Enemy");
        this.player = player;

        // Set them all as blank
        for (int i = 0; i < this.table.length; i++) {
            for (int j = 0; j < this.table.length; j++) {
                this.table[i][j] = " ";
            }
        }
    }

    // Update method
    public void update() {

        checkWinner(this.player);
        this.enemy.setPlaying(true);
        this.enemy.update(this);
        if (running) {
            checkWinner(this.enemy);
        }
        checkBoard();
    }

    private void checkBoard() {
        int total = 0;

        for (int i = 0; i < this.table.length; i++) {
            for (int j = 0; j < this.table.length; j++) {
                if (!this.table[i][j].equals(" ")) {
                    total++;
                }
            }
        }

        if (total == 9) {
            this.running = false;
        }
    }

    private void checkWinner(Players obj) {

        /*  [ ][ ][X]
         *  [ ][X][ ]
         *  [X][ ][ ]  */
        if (this.table[2][0].equals(obj.getType()) && table[1][1].equals(obj.getType()) && table[0][2].equals(obj.getType())) {
            System.out.println(obj.getName() + " WON!");
            this.running = false;
        }
        /*  [X][ ][ ]
         *  [ ][X][ ]
         *  [ ][ ][X]  */
        if (this.table[0][0].equals(obj.getType()) && table[1][1].equals(obj.getType()) && this.table[2][2].equals(obj.getType())) {
            System.out.println(obj.getName() + " WON!");
            this.running = false;
        }

        // VERTICAL SEEK
        /*  [X][X][X]
         *  [ ][ ][ ]
         *  [ ][ ][ ]  */
        if (table[0][0].equals(obj.getType()) && table[0][1].equals(obj.getType()) && table[0][2].equals(obj.getType())) {
            System.out.println(obj.getName() + " WON!");
            this.running = false;
        }
        /*  [ ][ ][ ]
         *  [X][X][X]
         *  [ ][ ][ ]  */
        if (table[1][0].equals(obj.getType()) && table[1][1].equals(obj.getType()) && table[1][2].equals(obj.getType())) {
            System.out.println(obj.getName() + " WON!");
            this.running = false;
        }
        /*  [ ][ ][ ]
         *  [ ][ ][ ]
         *  [X][X][X]  */
        if (table[2][0].equals(obj.getType()) && table[2][1].equals(obj.getType()) && table[2][2].equals(obj.getType())) {
            System.out.println(obj.getName() + " WON!");
            this.running = false;
        }

        // HORIZONTAL SEEK
        /*  [X][ ][ ]
         *  [X][ ][ ]
         *  [X][ ][ ]  */
        if (table[0][0].equals(obj.getType()) && table[1][0].equals(obj.getType()) && table[2][0].equals(obj.getType())) {
            System.out.println(obj.getName() + " WON!");
            this.running = false;
        }
        /*  [ ][X][ ]
         *  [ ][X][ ]
         *  [ ][X][ ]  */
        if (table[0][1].equals(obj.getType()) && table[1][1].equals(obj.getType()) && table[2][1].equals(obj.getType())) {
            System.out.println(obj.getName() + " WON!");
            this.running = false;
        }
        /*  [ ][ ][X]
         *  [ ][ ][X]
         *  [ ][ ][X]  */
        if (table[0][2].equals(obj.getType()) && table[1][2].equals(obj.getType()) && table[2][2].equals(obj.getType())) {
            System.out.println(obj.getName() + " WON!");
            this.running = false;
        }
    }
    
    public String[][] getTable() {
        return table;
    }

    public void setTable(String[][] table) {
        this.table = table;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

}
