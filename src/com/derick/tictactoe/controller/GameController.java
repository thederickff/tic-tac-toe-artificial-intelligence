/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.derick.tictactoe.controller;


/**
 *
 * @author derickfelix
 */
public class GameController {

    // Tic tac toe 
    private String[][] table;
    
    public GameController(){
        // initialize a 3x3 table
        this.table = new String[3][3];
        
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
            if (!this.table[i][j].equals("X") || !this.table[i][j].equals("O")) {
                this.table[i][j] = guest;
            } else {
                System.out.println("Error: YOU CANNOT GUEST HERE!");
            }
        } else {
            System.out.println("Error: PLACES GIVEN OUT OF BOUND!");
        }
    }

    public String[][] getTable() {
        return table;
    }

    public void setTable(String[][] table) {
        this.table = table;
    }
    
    
}
