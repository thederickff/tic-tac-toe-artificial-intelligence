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
public class Players {
    
    protected int score;
    protected boolean playing;
    protected String name;
    protected String type;
    
    public Players(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    

    @Override
    public String toString() {
        return "Player = [" + "name = " + name + ", score = " + score + ", playing = " + playing + ']';
    }
    
    
    
    
}
