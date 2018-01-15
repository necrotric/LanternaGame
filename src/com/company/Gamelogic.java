package com.company;

import com.googlecode.lanterna.terminal.Terminal;
import java.util.List;
import java.util.Random;

class Gamelogic {

    static void monsterMovement(Player player, List<Enemy> enemies) throws InterruptedException {

        for (int i = 0; i < enemies.size(); i++) {
            float diffX = Math.abs(enemies.get(i).x - player.x);
            float diffY = Math.abs(enemies.get(i).y - player.y);

            boolean collideX = false;
            boolean collideY = false;
            //Collision Check
            for (int j = 0; j < enemies.size(); j++) {
                if (j != i) {
                    if (diffX >= diffY) {
                        if (enemies.get(i).x > player.x && enemies.get(i).x - 1 == enemies.get(j).x) {
                            collideX = true;
                        } else if (enemies.get(i).x < player.x && enemies.get(i).x + 1 == enemies.get(j).x) {
                            collideX = true;
                        }
                    } else if (diffX < diffY || collideX) {
                        if (enemies.get(i).y > player.y && enemies.get(i).y - 1 == enemies.get(j).y)

                        {
                            collideX = true;
                        } else if (enemies.get(i).y < player.x && enemies.get(i).y + 1 == enemies.get(j).y)

                        {
                            collideX = true;
                        }
                    }
                }
                if (collideX && collideY) {
                    break;
                }
            }
            //Movement
            if (!collideX || !collideY) {
                if (diffX >= diffY && !collideX) {
                    if (enemies.get(i).x > player.x) {
                        enemies.get(i).x -= 0.5;
                    } else {
                        enemies.get(i).x += 0.5;
                    }
                } else {
                    if (enemies.get(i).y > player.y) {
                        enemies.get(i).y -= 0.5;
                    } else {
                        enemies.get(i).y += 0.5;
                    }
                }
            }
        }
    }

    static void playerHighScore(HighScore highscore, Terminal terminal) throws InterruptedException{
        TextPrinter.printText(45,0,"Score:" + highscore.highscore, terminal);

    }

    static void printBonusCoin(Player player, HighScore highscore, Bonus bonus) throws InterruptedException {
        Random rn = new Random();
        int lowX = 0;
        int highX = 99;
        int lowY = 1;
        int highY = 29;

        if(bonus.x == player.x && bonus.y == player.y){
            highscore.highscore += 10;
            bonus.x = rn.nextInt(highX - lowX) + lowX;
            bonus.y = rn.nextInt(highY - lowY) + lowY;

        }
    }

    static void spawnEnemy(Player player, List<Enemy> enemies, HighScore highscore){

        Random rn = new Random();
        int lowX = 0;
        int highX = 99;
        int lowY = 1;
        int highY = 29;

        if(highscore.highscore%100==0){
            int randX = rn.nextInt(highX - lowX) + lowX;
            int randY = rn.nextInt(highY - lowY) + lowY;

            if(randX != player.x && randY != player.y){

                enemies.add(new Enemy(randX,randY));

            }

            else if(randX == player.x && randY==player.y){

                randX = rn.nextInt(highX - lowX) + lowX;
                randY = rn.nextInt(highY - lowY) + lowY;

                enemies.add(new Enemy(randX, randY));

            }
        }
    }

    static boolean gameOver(Player player, List<Enemy> enemies, Terminal terminal) throws InterruptedException {
        boolean gameOver = false;

        for (Enemy enemy : enemies ){
            if(player.x == enemy.x && player.y == enemy.y){
                terminal.clearScreen();

                TextPrinter.printText(45, 20, "Game Over", terminal);
                gameOver = true;

            }
        }
        return gameOver;
    }
}


