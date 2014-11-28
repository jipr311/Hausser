package co.ve.jipr.mygdx.test.screens;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class Splash implements Screen {

	private static final String TAG = Splash.class.getSimpleName();

	// private Texture texture = new Texture(Gdx.files.internal("images/ic_launcher.png"));
	private Texture texture = new Texture(Gdx.files.internal("images/bmw_logo.png"));
	private Image splashBmwImage = new Image(texture);

	private float screenWidth = Gdx.graphics.getWidth();
	private float screenHeight = Gdx.graphics.getHeight();
	private float screenMiddleX = screenWidth / 2;
	private float screenMiddleY = screenHeight / 2;
	private float x = screenMiddleX;
	private float y = screenMiddleY;


	private Stage stage = new Stage();

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		changeScreen();
	}

	private void changeScreen() {
		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		Gdx.app.log(TAG, "..Resizing!");
	}

	@Override
	public void show() {
		splashBmwImage.setX(x - splashBmwImage.getWidth() / 2);
		splashBmwImage.setY(y - splashBmwImage.getHeight() / 2);

		stage.addActor(splashBmwImage);

		splashBmwImage.addAction(Actions.sequence(Actions.alpha(0), Actions.fadeIn(0.45f), Actions.delay(0.5f), Actions.fadeOut(1.5f),
				Actions.run(new Runnable() {

					@Override
					public void run() {
						((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());

					}
				})));
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		texture.dispose();
		stage.dispose();
	}


}
