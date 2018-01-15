package com.company;

import com.googlecode.lanterna.terminal.Terminal;

class TextPrinter{

    static void printText(int x, int y, String message, Terminal terminal) {
        for (int i = 0; i < message.length(); i++) {
            terminal.moveCursor(x++, y);
            terminal.putCharacter(message.charAt(i));

        }
    }
}
