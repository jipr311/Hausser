package co.ve.jipr.mygdx.test.screens;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;


public class MainMenu implements Screen {

	private static final String TAG = MainMenu.class.getSimpleName();

	private Stage stage = new Stage();
	private Skin skin = new Skin(Gdx.files.internal("skins/menuSkin.json"), new TextureAtlas(Gdx.files.internal("skins/TextureTest.pack")));

	private TextButton buttonAnimate = new TextButton("Animate", skin, "white");
	private TextButton buttonExit = new TextButton("Exit", skin, "white");
	private Table table = new Table();
	private Label title = new Label("OpenGL Demo App @" + Gdx.graphics.getFramesPerSecond() + "FPS", skin);

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		buttonAnimate.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				// Same way we moved here from the Splash Screen
				// We set it to new Splash because we got no other screens
				// otherwise you put the screen there where you want to go
				((Game) Gdx.app.getApplicationListener()).setScreen(new BmwAnimator());
			}
		});
		buttonExit.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
			}
		});
		// The elements are displayed in the order you add them.
		// The first appear on top, the last at the bottom.
		table.add(title).padBottom(40).row();
		table.add(buttonAnimate).size(250, 100).padBottom(20).row();
		table.add(buttonExit).size(250, 100).padBottom(20).row();
		table.setFillParent(true);
		stage.addActor(table);


		Gdx.input.setInputProcessor(stage);
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
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		Gdx.app.log(TAG, "...Resizing!");
	}

	@Override
	public void dispose() {
		stage.dispose();
		skin.dispose();

	}


}
