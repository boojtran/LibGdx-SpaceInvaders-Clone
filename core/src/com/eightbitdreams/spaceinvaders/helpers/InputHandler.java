package com.eightbitdreams.spaceinvaders.helpers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.utils.Array;
import com.eightbitdreams.spaceinvaders.gameobjects.Hero;
import com.eightbitdreams.spaceinvaders.gameobjects.HeroBullet;

/**
 * Created by CrazyHendrix on 17 Nov 2014.
 */
public class InputHandler implements InputProcessor{
    private Hero hero;
    private Array<HeroBullet> heroBullets;

    public InputHandler(Hero hero, Array<HeroBullet> heroBullets) {
        this.hero = hero;
        this.heroBullets = heroBullets;
    }
    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.A) {
            hero.setMovingLeft(true);
            hero.getVelocity().x = -200;
        }
        if (keycode == Input.Keys.D) {
            hero.setMovingLeft(false);
            hero.getVelocity().x = 200;
        }
        if (keycode == Input.Keys.J) {
            hero.setState(Hero.HeroState.FIRING);
            // Check that last bullet fired has lapse for 1/2 sec or more
            if (hero.getBulletFireLapse() > 0.5f) {
                // Cycle through bullets in array
                for (HeroBullet bullet : heroBullets) {
                    // If bullet is already moving, go to next on the array
                    if (bullet.getVelocity().y >= 0) {
                        bullet.getVelocity().set(0, -300);
                        // Set the lapse time back to 0
                        hero.setBulletFireLapset(0);
                        break; // Break out of for loop
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.A && hero.isMovingLeft()) {
            hero.getVelocity().x = 0;
        }
        if (keycode == Input.Keys.D && !hero.isMovingLeft()) {
            hero.getVelocity().x = 0;
        }
        if (keycode == Input.Keys.J) {
            hero.setState(Hero.HeroState.READY);
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
