/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.derick.tictactoe.controller;

import com.derick.tictactoe.model.Enemy;
import com.derick.tictactoe.model.Player;
import com.derick.tictactoe.model.Players;
import java.awt.Color;
import javax.swing.JLabel;

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
    public void update(JLabel status) {

        // Check if the player won
        checkWinner(this.player, status);
        // if the player did'nt won check if the enemy did it.
        if (running) {
            this.enemy.setPlaying(true);
            this.enemy.update(this);
            checkWinner(this.enemy, status);
        }
        // Check if there is space to guest
        checkBoard(status);

    }

    public void drawScores(JLabel lblPlayer, JLabel lblEnemy) {
       lblPlayer.setText(Integer.toString(player.getScore()));
       lblEnemy.setText(Integer.toString(enemy.getScore()));
    }
    public void resetScores(JLabel lblPlayer, JLabel lblEnemy) {
       player.setScore(0);
       enemy.setScore(0);
       lblPlayer.setText("0");
       lblEnemy.setText("0");
    }

    // Responsible for counting the quantity of blank spaces
    private void checkBoard(JLabel out) {
        // Creates a new variable to
        int total = 0;

        for (int i = 0; i < this.table.length; i++) {
            for (int j = 0; j < this.table.length; j++) {
                if (!this.table[i][j].equals(" ")) {
                    total++;
                }
            }
        }

        // If there is no blank space the game is stopped
        if (total == 9) {
            this.running = false;
            out.setForeground(Color.BLUE.darker());
            out.setText("Draw Game");
        }
    }

    private void checkWinner(Players obj, JLabel lblStatus) {

        /*  [ ][ ][X]
         *  [ ][X][ ]
         *  [X][ ][ ]  */
        if (this.table[2][0].equals(obj.getType()) && table[1][1].equals(obj.getType()) && table[0][2].equals(obj.getType())) {
            this.running = false;
        }
        /*  [X][ ][ ]
         *  [ ][X][ ]
         *  [ ][ ][X]  */
        if (this.table[0][0].equals(obj.getType()) && table[1][1].equals(obj.getType()) && this.table[2][2].equals(obj.getType())) {
            this.running = false;
        }

        // VERTICAL SEEK
        /*  [X][X][X]
         *  [ ][ ][ ]
         *  [ ][ ][ ]  */
        if (table[0][0].equals(obj.getType()) && table[0][1].equals(obj.getType()) && table[0][2].equals(obj.getType())) {
            this.running = false;
        }
        /*  [ ][ ][ ]
         *  [X][X][X]
         *  [ ][ ][ ]  */
        if (table[1][0].equals(obj.getType()) && table[1][1].equals(obj.getType()) && table[1][2].equals(obj.getType())) {
            this.running = false;
        }
        /*  [ ][ ][ ]
         *  [ ][ ][ ]
         *  [X][X][X]  */
        if (table[2][0].equals(obj.getType()) && table[2][1].equals(obj.getType()) && table[2][2].equals(obj.getType())) {
            this.running = false;
        }

        // HORIZONTAL SEEK
        /*  [X][ ][ ]
         *  [X][ ][ ]
         *  [X][ ][ ]  */
        if (table[0][0].equals(obj.getType()) && table[1][0].equals(obj.getType()) && table[2][0].equals(obj.getType())) {
            this.running = false;
        }
        /*  [ ][X][ ]
         *  [ ][X][ ]
         *  [ ][X][ ]  */
        if (table[0][1].equals(obj.getType()) && table[1][1].equals(obj.getType()) && table[2][1].equals(obj.getType())) {
            this.running = false;
        }
        /*  [ ][ ][X]
         *  [ ][ ][X]
         *  [ ][ ][X]  */
        if (table[0][2].equals(obj.getType()) && table[1][2].equals(obj.getType()) && table[2][2].equals(obj.getType())) {
            this.running = false;
        }

        if (running == false) {
            lblStatus.setForeground(obj.getColor());
            lblStatus.setText(obj.getName() + " won!");
            obj.setScore(obj.getScore() + 1);
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

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    

}
