/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.derick.tictactoe.test;

import com.derick.tictactoe.controller.GameController;
import java.util.Scanner;

/**
 *
 * @author derickfelix
 */
public class MainTest {

    public static String[][] places = new String[3][3];
    public static String table;
    public static boolean running = true;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        GameController game = new GameController();
        

        while (running) {

            updateBoard();

            try {
                System.out.print("Give a row (between 1 and 3): $ ");
                int rowGuest = input.nextInt() - 1;
                System.out.print("Give a column (between 1 and 3): $ ");
                int columnGuest = input.nextInt() - 1;
                
                 System.out.println("\n\n\n************************************");
                pressButton(places, "X", rowGuest, columnGuest);
            } catch (Exception e) {
                running = false;
                System.out.println("Error: " + e);
            }
        }

    }

    static void updateBoard() {

        // Prints column position ex: # 1 2 3
        table = "# ";
        for (int i = 0; i < places.length; i++) {
            table += "  " + (i + 1) + "  ";
        }
        table += ("\n");
        /**
         * prints row position and game status ex: a [X][O][O] b [O][O][X] c
         * [X][X][O]
         */
        for (int i = 0; i < places.length; i++) {

            table += (i + 1) + " ";
            for (int j = 0; j < places.length; j++) {
                table += "[ ";
                table += places[i][j];
                table += " ]";
            }
            table += "\n";

        }
        System.out.println(table);
    }

    static void pressButton(String[][] place, String guest, int i, int j) {
       
        if (i < 3 && j < 3) {
            if (!place[i][j].equals("X")) {
                place[i][j] = guest;
            } else {
                System.out.println("Error: YOU CANNOT GUEST HERE!");
            }
        } else {
            System.out.println("Error: PLACES GIVEN OUT OF BOUND!");
        }
    }
}
