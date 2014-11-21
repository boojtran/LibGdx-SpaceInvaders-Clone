package com.eightbitdreams.spaceinvaders.gameobjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by CrazyHendrix on 18 Nov 2014.
 */
public abstract class AbstractAlien {

    private Vector2 position;
    private int width, height;
    private Rectangle boundingBox;
    private boolean lastLeft, lastRight;
    private boolean moveLeft;

    public AbstractAlien(float x, float y, int width, int height, boolean lastLeft, boolean lastRight) {
        this.position = new Vector2(x, y);
        this.width = width;
        this.height = height;
        this.lastLeft = lastLeft;
        this.lastRight = lastRight;
        boundingBox = new Rectangle(x, y, width, height);
        moveLeft = false;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    public void setLastLeft(boolean lastLeft) {
        this.lastLeft = lastLeft;
    }

    public void setLastRight(boolean lastRight) {
        this.lastRight = lastRight;
    }

    public boolean isLastLeft() {
        return lastLeft;
    }

    public boolean isLastRight() {
        return lastRight;
    }

    public boolean isMoveLeft() {
        return moveLeft;
    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }

    public void update(float delta) {
        boundingBox.setPosition(position);
    }

}
