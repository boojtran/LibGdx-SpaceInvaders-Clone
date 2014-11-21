package com.eightbitdreams.spaceinvaders.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.eightbitdreams.spaceinvaders.SpaceInvadersGame;
import com.eightbitdreams.spaceinvaders.util.Constants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Space Invaders";
		config.useGL30 = false;
		config.width = Constants.VIEWPORT_WIDTH;
		config.height = Constants.VIEWPORT_HEIGHT;
		new LwjglApplication(new SpaceInvadersGame(), config);
	}
}
