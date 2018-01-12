package com.company;

import com.googlecode.lanterna.terminal.Terminal;

import java.util.List;

class PrintEntities {

    static void printEntities(Player player, List<Enemy> enemies, Terminal terminal) {
        //removes the old pos
        terminal.clearScreen();

        //Print the player
        terminal.moveCursor(player.x, player.y);
        terminal.putCharacter(player.hero);

        for(Enemy enemy : enemies) {
            terminal.moveCursor(enemy.x, enemy.y);
            terminal.putCharacter(enemy.enemy);

        }

        //Keeps the Cursor in left-top corner
        terminal.moveCursor(0, 0);

    }
}