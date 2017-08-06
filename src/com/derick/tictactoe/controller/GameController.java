/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.derick.tictactoe.controller;

import com.derick.tictactoe.model.Enemy;
import com.derick.tictactoe.model.Player;
import com.derick.tictactoe.model.Players;

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

    public GameController() {
        // Initialize game as running
        this.running = true;
        // Initialize a 3x3 table
        this.table = new String[3][3];
        // Initialize the enemy
        this.enemy = new Enemy("Enemy");
        this.player = new Player("Player");

        // Set them all as blank
        for (int i = 0; i < this.table.length; i++) {
            for (int j = 0; j < this.table.length; j++) {
                this.table[i][j] = " ";
            }
        }
    }

    // Press Button method
    public void pressButton(String guest, int i, int j) {
        // Check if the places is out of bound
        if (i < 3 && j < 3) {
            // Check if the place given weren't used yet
            if (!this.table[i][j].equals("X") && !this.table[i][j].equals("O")) {
                this.table[i][j] = guest;
            } else {
                System.out.println("Error: YOU CANNOT GUEST HERE!");
            }
        } else {
            System.out.println("Error: PLACES GIVEN OUT OF BOUND!");
        }
    }

    // Update method
    public void update() {

        checkBoard(this.player);
        this.enemy.update(this);
        checkBoard(this.enemy);
    }

    public void checkBoard(Players obj){
        
        /*  [ ][ ][X]
         *  [ ][X][ ]
         *  [X][ ][ ]  */      
        if(this.table[2][0].equals(obj.getType()) && table[1][1].equals(obj.getType()) && table[0][2].equals(obj.getType())) {
            System.out.println(obj.getName() + " WON!");
            this.running = false;
        }    
        /*  [X][ ][ ]
         *  [ ][X][ ]
         *  [ ][ ][X]  */      
        if(this.table[0][0].equals(obj.getType()) && table[1][1].equals(obj.getType()) && this.table[2][2].equals(obj.getType())) {
            System.out.println(obj.getName() + " WON!");
            this.running = false;
        }    
        
        // VERTICAL SEEK
        /*  [X][X][X]
         *  [ ][ ][ ]
         *  [ ][ ][ ]  */      
        if(table[0][0].equals(obj.getType()) && table[0][1].equals(obj.getType()) && table[0][2].equals(obj.getType())) {
            System.out.println(obj.getName() + " WON!");
            this.running = false;
        }    
        /*  [ ][ ][ ]
         *  [X][X][X]
         *  [ ][ ][ ]  */      
        if(table[1][0].equals(obj.getType()) && table[1][1].equals(obj.getType()) && table[1][2].equals(obj.getType())) {
            System.out.println(obj.getName() + " WON!");
            this.running = false;
        }    
        /*  [ ][ ][ ]
         *  [ ][ ][ ]
         *  [X][X][X]  */      
        if(table[2][0].equals(obj.getType()) && table[2][1].equals(obj.getType()) && table[2][2].equals(obj.getType())) {
            System.out.println(obj.getName() + " WON!");
            this.running = false;
        }    
        
        // HORIZONTAL SEEK
        /*  [X][ ][ ]
         *  [X][ ][ ]
         *  [X][ ][ ]  */      
        if(table[0][0].equals(obj.getType()) && table[1][0].equals(obj.getType()) && table[2][0].equals(obj.getType())) {
            System.out.println(obj.getName() + " WON!");
            this.running = false;
        }    
        /*  [ ][X][ ]
         *  [ ][X][ ]
         *  [ ][X][ ]  */      
        if(table[0][1].equals(obj.getType()) && table[1][1].equals(obj.getType()) && table[2][1].equals(obj.getType())) {
            System.out.println(obj.getName() + " WON!");
            this.running = false;
        }    
        /*  [ ][ ][X]
         *  [ ][ ][X]
         *  [ ][ ][X]  */      
        if(table[0][2].equals(obj.getType()) && table[1][2].equals(obj.getType()) && table[2][2].equals(obj.getType())) {
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
