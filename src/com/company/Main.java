package com.company;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //Creating a window
        Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();

        //creating enemies
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy(10,2));
        enemies.add(new Enemy(90,2 ));
        enemies.add(new Enemy(10,28));
        enemies.add(new Enemy(90,28 ));

        //Create player, add Movement, print Enteties.
        Player player = new Player(50, 15);



        //While gameover is false, call methods moveHero, printEntities
        boolean gameOver = false;

        while (!gameOver) {
            HeroMovement.moveHero(player, terminal);
            Gamelogic.monsterMovement(player,enemies);
            PrintEntities.printEntities(player, enemies, terminal);

        }


    }

}

