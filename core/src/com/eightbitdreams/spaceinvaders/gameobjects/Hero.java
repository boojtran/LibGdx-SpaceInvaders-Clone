package com.eightbitdreams.spaceinvaders.gameobjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.eightbitdreams.spaceinvaders.util.Constants;

/**
 * Created by CrazyHendrix on 17 Nov 2014.
 */
public class Hero {
    private Vector2 position;
    private Vector2 velocity;
    private Rectangle boundingBox;
    private boolean movingLeft;
    private float bulletFireLapse;

    private int width, height;

    public enum HeroState {
        READY, FIRING, DEAD
    }

    private HeroState state;

    public Hero(float x, float y, int width, int height) {
        this.width = width;
        this.height = height;
        bulletFireLapse = 0.5f;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        boundingBox = new Rectangle(x, y, width, height - 5);
        movingLeft = false;
        state = HeroState.READY;
    }

    public void update(float delta) {
        if (position.x < 0) {
            position.x = 0;
        } else if (position.x > Constants.VIEWPORT_WIDTH - 20) {
            position.x = Constants.VIEWPORT_WIDTH - 20;
        }
        position.add(velocity.cpy().scl(delta));
        boundingBox.setPosition(position);
        bulletFireLapse += delta;
    }

    public float getBulletFireLapse() {
        return bulletFireLapse;
    }

    public void setBulletFireLapset(float bulletFireLapse) {
        this.bulletFireLapse = bulletFireLapse;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public boolean isMovingLeft() {
        return movingLeft;
    }

    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    public HeroState getState() {
        return state;
    }

    public void setState(HeroState state) {
        this.state = state;
    }
}
