package com.eightbitdreams.spaceinvaders.gameobjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by CrazyHendrix on 18 Nov 2014.
 */
public class HeroBullet {

    private Rectangle boundingBox;
    private Vector2 position, velocity;

    public HeroBullet() {
        boundingBox = new Rectangle(0, 0, 2, 4);
        position = new Vector2(boundingBox.x, boundingBox.y);
        velocity = new Vector2(0, 0);
    }

    public void update(float delta) {
        if (velocity.y < 0) {
            position.add(velocity.cpy().scl(delta));
        }
        if (position.y < 0) {
            velocity.set(0, 0);
            position.set(0, 0);
        }
        boundingBox.setPosition(position);
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public Vector2 getPosition() {
        return position;
    }

}
