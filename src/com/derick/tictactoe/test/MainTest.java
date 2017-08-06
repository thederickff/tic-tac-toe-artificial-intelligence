/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.derick.tictactoe.test;

import com.derick.tictactoe.controller.GameController;
import com.derick.tictactoe.model.Player;
import java.util.Scanner;

/**
 *
 * @author derickfelix
 */
public class MainTest {

    public static String table;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Player player = new Player("Player");
        GameController game = new GameController(player);
        

        while (game.isRunning()) {
            game.update();
            // this command is just for test
            drawBoard(game.getTable());
            
            
            
            // Test section
            try {
                if (game.isRunning()) {

                    System.out.print("Give a ROW (between 1 and 3): $ ");
                    int rowGuest = input.nextInt() - 1;
                    System.out.print("Give a COL (between 1 and 3): $ ");
                    int columnGuest = input.nextInt() - 1;

                    System.out.println("\n\n\n************************************");
                    player.pressButton(game.getTable(),"X", rowGuest, columnGuest);
                }
            } catch (Exception e) {
                game.setRunning(false);
                System.out.println("Error: " + e);
            }

        }

    }

    // Just for test
    static void drawBoard(String[][] places) {

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

}
