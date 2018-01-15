package com.company;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

class GameInterface{

    static boolean startMenu(Terminal terminal) throws InterruptedException {
        terminal.setCursorVisible(false);

        TextPrinter.printText(45,5, "Follow John",terminal);
        TextPrinter.printText(45,10, "1.Play",terminal);
        TextPrinter.printText(45,15, "2.Quit",terminal);

        boolean toggleMenu = true;
        Key key;
        do {
            Thread.sleep(50);
            key = terminal.readInput();

        }
        while (key == null);

        switch (key.getCharacter()) {
            case 49:
                terminal.clearScreen();
                toggleMenu = false;
                StartGame.startGame(terminal);

                break;

            case 50:
                toggleMenu = false;
                System.exit(0);
                break;
        }
        return toggleMenu;
    }
}


