package com.company;

import java.util.List;

public class Gamelogic {

    public static void monsterMovement(Player player, List<Enemy> enemies) throws InterruptedException {

        System.out.println(enemies.get(0));

        for (Enemy enemy : enemies) {


                int diffX = enemy.x - player.x;
                int diffY = enemy.y - player.y;

                for (int j = 0; j < 4; j++) {
                for (int i = 1; i < 4; i++) {


                    if (enemies.get(j).x != enemies.get(i).x && enemies.get(j).y != enemies.get(i).y) {



                        if (enemy.x != player.x && enemy.y != player.y) {

                            if (Math.abs(diffX) >= Math.abs(diffY)) {

                                if (enemy.x < player.x) {

                                    enemy.x++;

                                } else if (enemy.x > player.x) {

                                    enemy.x--;

                                }
                            } else {

                                if (enemy.y < player.y) {

                                    enemy.y++;

                                }
                                if (enemy.y > player.y) {

                                    enemy.y--;

                                }


                            }


                        }


                    }

                    if (enemies.get(0).x == enemies.get(i).x && enemies.get(0).y == enemies.get(i).y) {
                        enemies.get(i).x = 2;
                        enemies.get(i).y = 29;
                    }


                }
            }


        }

}}
