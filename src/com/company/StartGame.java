package com.company;

import com.googlecode.lanterna.terminal.Terminal;
import java.util.ArrayList;
import java.util.List;

class StartGame {

    static void startGame(Terminal terminal) throws InterruptedException {

        HighScore highscore = new HighScore(0);

        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy(10,2));
        enemies.add(new Enemy(90,2 ));
        enemies.add(new Enemy(10,25));
        enemies.add(new Enemy(90,25 ));

        Player player = new Player(50, 15);
        Bonus bonus = new Bonus(1,1);
        //while gameOver is false, run game
        boolean gameOver = Gamelogic.gameOver(player,enemies,terminal);
        while (!gameOver) {
            Gamelogic.gameOver(player,enemies,terminal);
            HeroMovement.moveHero(player, terminal, highscore);
            Gamelogic.monsterMovement(player,enemies);
            Gamelogic.spawnEnemy(player, enemies, highscore);
            PrintEntities.printEntities(player, enemies, terminal,bonus);
            Gamelogic.playerHighScore(highscore,terminal);
            Gamelogic.printBonusCoin(player, highscore, bonus);
            gameOver = Gamelogic.gameOver(player,enemies,terminal);

        }
        //while menu is true, show menu
        boolean menu = GameInterface.startMenu(terminal);
        while (menu){
            GameInterface.startMenu(terminal);
        }
    }
}
