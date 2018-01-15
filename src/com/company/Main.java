package com.company;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;
import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //Creating a window
        Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();

        //Call StartMenu
        GameInterface.startMenu(terminal);

    }
}

