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
public class Computer extends Players {
    
    public Computer(String name) {
        super(name);
        this.playing = false;
    }
    
}
