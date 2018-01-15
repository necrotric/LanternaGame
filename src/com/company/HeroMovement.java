package com.company;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

class HeroMovement {

    static void moveHero(Player player, Terminal terminal, HighScore highscore) throws InterruptedException {
        terminal.setCursorVisible(false);
        //Wait for a key to be pressed
        Key key;
        do {
            Thread.sleep(50);
            key = terminal.readInput();

        }
        while (key == null);

        switch (key.getKind()) {

            case ArrowDown:
                if (player.y < 100) {
                    player.y++;
                    highscore.highscore++;

                }
                break;

            case ArrowUp:
                player.y--;
                highscore.highscore++;
                break;

            case ArrowLeft:
                if (player.x > 0) {
                    player.x--;
                    highscore.highscore++;

                }
                break;

            case ArrowRight:
                if (player.x < 99) {
                    player.x++;
                    highscore.highscore++;

                }
                break;
        }
    }
}
