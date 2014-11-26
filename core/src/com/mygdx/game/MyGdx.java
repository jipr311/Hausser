package com.mygdx.game;


import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.screens.Splash;

@SuppressWarnings("unused")
public class MyGdx extends Game {

	private static final String TAG = MyGdx.class.getSimpleName();

	private static final String TITLE = "Animated Project";
	private static final int WIDTH = 480;
	private static final int HEIGHT = 800; // used later to set window size

	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		Gdx.app.log(TAG, "...Creating!");
		setScreen(new Splash());
	}
}
