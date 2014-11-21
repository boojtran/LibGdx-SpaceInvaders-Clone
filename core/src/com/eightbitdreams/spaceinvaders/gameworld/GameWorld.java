package com.eightbitdreams.spaceinvaders.gameworld;

import com.badlogic.gdx.utils.Array;
import com.eightbitdreams.spaceinvaders.gameobjects.AbstractAlien;
import com.eightbitdreams.spaceinvaders.gameobjects.Alien1;
import com.eightbitdreams.spaceinvaders.gameobjects.Hero;
import com.eightbitdreams.spaceinvaders.gameobjects.HeroBullet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CrazyHendrix on 17 Nov 2014.
 */
public class GameWorld {
    private Hero hero;
    private Array<HeroBullet> heroBullets;
    private AbstractAlien[][] aliens = new AbstractAlien[5][10];
    private int midPointX;
    private int gameHeight;
    private float alienMoveLapseTime;
    private float timeLapsedAlienToMove;

    public GameWorld(int midPointX, int gameHeight) {
        this.midPointX = midPointX;
        this.gameHeight = gameHeight;
        hero = new Hero(midPointX - 10, gameHeight - 40, 20, 20);
        heroBullets = new Array<HeroBullet>(6);
        timeLapsedAlienToMove = 1f;
        alienMoveLapseTime = 0;

        for (int i = 0; i < 6; i++) {
            HeroBullet bullet = new HeroBullet();
            heroBullets.add(bullet);
            System.out.println("Adding bullet: #" + (i + 1));
        }
        for (int col = 0; col < 5; col++) {
            int rowPositionY = 25 * (col + 1);
            for (int row = 0; row < 10; row++) {
                int rowPositionX = row == 0 ? 0 : row * 25;
                boolean lastLeft = row == 0;
                boolean lastRight = row == 9;
                Alien1 alien1 = new Alien1(rowPositionX, rowPositionY, 20, 20, lastLeft, lastRight);
                aliens[col][row] = alien1;
                // System.out.println("Alien[" + col + "][" + row + "] int!");
            }
        }
    }

    public void update(float delta) {
        alienMoveLapseTime += delta;
        hero.update(delta);
        bulletHitAlienCheck();
        for (HeroBullet bullet : heroBullets) {
            if (bullet.getVelocity().y >= 0) {
                bullet.getPosition().x = hero.getX() + (hero.getWidth() / 2) - 1;
                bullet.getPosition().y = hero.getY();
            }
            bullet.update(delta);
        }
        if (alienMoveLapseTime > timeLapsedAlienToMove) {
            for (int col = 0; col < 5; col++) {
                for (int row = 0; row < 10; row++) {
                    if (aliens[col][row] != null) {
                        if (aliens[col][row].isMoveLeft()) {
                            aliens[col][row].getPosition().add(-5, 0);
                        } else {
                            aliens[col][row].getPosition().add(5, 0);
                        }
                    }
                }
            }
            for (int col = 0; col < 5; col++) {
                for (int row = 0; row < 10; row++) {
                    if (aliens[col][row] != null) {
                        if (row > 0 && row < 8) {
                            aliens[col][row].setLastLeft(aliens[col][row - 1] == null);
                            aliens[col][row].setLastRight(aliens[col][row + 1] == null);
                        }
                        if (aliens[col][row].getPosition().x < 5) {
                            for (int col1 = 0; col1 < 5; col1++) {
                                for (int row1 = 0; row1 < 10; row1++) {
                                    if (aliens[col1][row1] != null) {
                                        if (aliens[col1][row1].isMoveLeft())
                                            aliens[col1][row1].getPosition().y += 10;
                                        aliens[col1][row1].setMoveLeft(false);
                                    }
                                }
                            }
                        }
                        if (aliens[col][row].getPosition().x > 290) {
                            for (int col1 = 0; col1 < 5; col1++) {
                                for (int row1 = 0; row1 < 10; row1++) {
                                    if (aliens[col1][row1] != null) {
                                        if (!aliens[col1][row1].isMoveLeft())
                                            aliens[col1][row1].getPosition().y += 10;
                                        aliens[col1][row1].setMoveLeft(true);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            alienMoveLapseTime = 0;
        }
        for (int col = 0; col < 5; col++) {
            for (int row = 0; row < 10; row++) {
                if (aliens[col][row] != null) {
                    aliens[col][row].update(delta);
                }
            }
        }
    }
    public void bulletHitAlienCheck() {
        for (HeroBullet bullet : heroBullets) {
            for (int col = 0; col < 5; col++) {
                for (int row = 0; row < 10; row++) {
                    if (aliens[col][row] != null &&
                            bullet.getBoundingBox().overlaps(aliens[col][row].getBoundingBox())) {
                        aliens[col][row] = null;
                        bullet.getVelocity().set(0, 0);
                        bullet.getPosition().set(-10, -10);
                    }
                }
            }
        }
    }
    public Hero getHero() {
        return hero;
    }

    public Array<HeroBullet> getHeroBullets() {
        return heroBullets;
    }

    public AbstractAlien[][] getAliens() {
        return aliens;
    }
}
