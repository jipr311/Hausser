package co.ve.jipr.mygdx.test.screens;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;


public class EndBmwAnimation implements Screen {

	private static final String TAG = EndBmwAnimation.class.getSimpleName();

	@Override
	public void render(float delta) {
		Gdx.app.setLogLevel(Application.LOG_INFO);
		Gdx.app.log(TAG, "my informative message");
		Gdx.app.error(TAG, "my error message");
		Gdx.app.debug(TAG, "my debug message");

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
