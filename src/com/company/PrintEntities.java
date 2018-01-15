package com.company;

import com.googlecode.lanterna.terminal.Terminal;
import java.util.List;

class PrintEntities {

    static void printEntities(Player player, List<Enemy> enemies, Terminal terminal, Bonus bonus) {
        //removes the old pos
        terminal.clearScreen();
        //Sets the cursor to invisible
        terminal.setCursorVisible(false);
        //Print the player
        terminal.moveCursor(player.x, player.y);
        terminal.putCharacter(player.hero);
        //Print enemies
        for(Enemy enemy : enemies) {
            terminal.moveCursor((int)enemy.x, (int)enemy.y);
            terminal.putCharacter(enemy.enemy);
        }
        //Print bonusCoin
        terminal.moveCursor(bonus.x, bonus.y);
        terminal.putCharacter(bonus.coin);

    }
}
