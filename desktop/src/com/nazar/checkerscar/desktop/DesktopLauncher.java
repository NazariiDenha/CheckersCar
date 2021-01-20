package com.nazar.checkerscar.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nazar.checkerscar.CheckersCar;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 562;
		config.width = 860;
		new LwjglApplication(new CheckersCar(), config);
	}
}
