package com.eightbitdreams.spaceinvaders.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.eightbitdreams.spaceinvaders.gameobjects.AbstractAlien;
import com.eightbitdreams.spaceinvaders.gameobjects.Hero;
import com.eightbitdreams.spaceinvaders.gameobjects.HeroBullet;
import com.eightbitdreams.spaceinvaders.util.Constants;

import java.util.List;

/**
 * Created by CrazyHendrix on 17 Nov 2014.
 */
public class GameRenderer {
    private GameWorld world;
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batch;
    private Hero hero;
    private Array<HeroBullet> heroBullets;
    private AbstractAlien[][] aliens;

    public GameRenderer(GameWorld world) {
        this.world = world;
        hero = world.getHero();
        heroBullets = world.getHeroBullets();
        aliens = world.getAliens();
        camera = new OrthographicCamera();
        camera.setToOrtho(true, Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
        batch = new SpriteBatch();
        batch.setProjectionMatrix(camera.combined);
    }

    public void render() {
        // Sets a color to fill the screen with
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rect(hero.getBoundingBox().x, hero.getBoundingBox().y,
                hero.getBoundingBox().width, hero.getBoundingBox().height);
        shapeRenderer.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.YELLOW);
        for (int col = 0; col < 5; col++) {
            for (int row = 0; row < 10; row++) {
                if (aliens[col][row] != null) {
                    shapeRenderer.rect(aliens[col][row].getBoundingBox().x, aliens[col][row].getBoundingBox().y,
                            aliens[col][row].getBoundingBox().width, aliens[col][row].getBoundingBox().height);
                }
            }
        }
        shapeRenderer.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.GREEN);
        for (HeroBullet bullet : heroBullets) {
            shapeRenderer.rect(bullet.getBoundingBox().x, bullet.getBoundingBox().y,
                    bullet.getBoundingBox().width, bullet.getBoundingBox().height);
        }
        shapeRenderer.end();
    }
}
