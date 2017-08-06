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
    
    public Enemy(String name) {
        super(name);
        this.playing = false;
        this.type = "O";
        this.firstGuest = true;
        this.random = new Random();
    }
    
    public void update(GameController game) {
        if(this.firstGuest) {
            firstGuest(game);
        }
    }
    
    private void firstGuest(GameController game){
        int randRow = random.nextInt(3);
        int randCol = random.nextInt(3);
        
        game.pressButton(this.type, randRow, randCol);
        this.firstGuest = false;
    }
    
}
