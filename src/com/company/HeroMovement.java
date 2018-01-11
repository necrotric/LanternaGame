package com.company;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

public class HeroMovement {

    public static void moveHero(Player player, Terminal terminal) throws InterruptedException {

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

                }
                break;
            case ArrowUp:

                player.y--;
                break;
            case ArrowLeft:

                if (player.x > 0) {

                    player.x--;

                }
                break;
            case ArrowRight:

                if (player.x < 99) {

                    player.x++;

                }
                break;
        }


        System.out.println(key.getCharacter() + " " + key.getKind());
    }

}
