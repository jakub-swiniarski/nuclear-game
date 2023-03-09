package com.nucleargame;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.nucleargame.NuclearGame;
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(1600,900);
		config.useVsync(true);
		config.setTitle("Nuclear Game");
		new Lwjgl3Application(new NuclearGame(), config);
	}
}