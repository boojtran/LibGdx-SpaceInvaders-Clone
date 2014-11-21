package com.eightbitdreams.spaceinvaders;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.eightbitdreams.spaceinvaders.screens.GameScreen;

public class SpaceInvadersGame extends Game {

    @Override
    public void create() {
        setScreen(new GameScreen());
        Gdx.app.log("SpaceInvadersGame", "created");
    }
}
