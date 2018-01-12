package com.company;

import java.util.List;
import com.googlecode.lanterna.terminal.Terminal;



public class GameOver {

    static void gameOver(Player player, List<Enemy> enemies, Terminal terminal, boolean gameOver) throws InterruptedException {

        for (Enemy enemy : enemies ){

            if(player.x == enemy.x && player.y == enemy.y){
                printText(45, 15, "Game Over", terminal);
                gameOver = true;
            }
        }

    }

    private static void printText(int x, int y, String message, Terminal terminal) {

        for (int i = 0; i < message.length(); i++) {
            terminal.moveCursor(x++, y);
            terminal.putCharacter(message.charAt(i));
        }
    }

}