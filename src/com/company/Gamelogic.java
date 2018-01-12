package com.company;

import com.googlecode.lanterna.terminal.Terminal;


import java.util.ArrayList;
import java.util.List;

class Gamelogic {

    static void monsterMovement(Player player, List<Enemy> enemies) throws InterruptedException {


        for (int i = 0; i < enemies.size(); i++) {
            int diffX = Math.abs(enemies.get(i).x - player.x);
            int diffY = Math.abs(enemies.get(i).y - player.y);
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
                        enemies.get(i).x -= 1;
                    } else {
                        enemies.get(i).x += 1;
                    }
                } else {
                    if (enemies.get(i).y > player.y) {
                        enemies.get(i).y -= 1;
                    } else {
                        enemies.get(i).y += 1;
                    }
                }
            }

        }

    }

}