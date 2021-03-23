package com.tenco.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.tenco.game.DeckGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = DeckGame.height;
		config.width = DeckGame.width;
		new LwjglApplication(new DeckGame(), config);
	}
}
