package com.eightbitdreams.spaceinvaders.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.eightbitdreams.spaceinvaders.gameworld.GameRenderer;
import com.eightbitdreams.spaceinvaders.gameworld.GameWorld;
import com.eightbitdreams.spaceinvaders.helpers.InputHandler;
import com.eightbitdreams.spaceinvaders.util.Constants;

/**
 * Created by CrazyHendrix on 16 Nov 2014.
 */
public class GameScreen implements Screen{
    private GameWorld world;
    private GameRenderer renderer;

    public GameScreen() {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameHeight = Constants.VIEWPORT_HEIGHT;
        float gameWidth = screenWidth / (screenHeight / gameHeight);

        int midPointX = (int) (gameWidth / 2);
        Gdx.app.log("GameScreen", "Attached");
        world = new GameWorld(midPointX, (int) gameHeight);
        renderer = new GameRenderer(world);

        // Set the screen input processor to class InputHandler
        Gdx.input.setInputProcessor(new InputHandler(world.getHero(), world.getHeroBullets()));
    }
    @Override
    public void render(float delta) {
        world.update(delta);
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
