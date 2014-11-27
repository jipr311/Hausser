package co.ve.jipr.mygdx.test.screens;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;


public class BmwAnimator implements Screen {

	private static final String TAG = BmwAnimator.class.getSimpleName();

	private Texture texture = new Texture(Gdx.files.internal("images/ic_launcher.png"));
	private Stage stage = new Stage();
	private Table table = new Table();
	private Skin skin = new Skin(Gdx.files.internal("skins/menuSkin.json"), new TextureAtlas(Gdx.files.internal("skins/TextureTest.pack")));
	private TextButton buttonMenu = new TextButton("Menu", skin);

	private SpriteBatch spriteBatch;
	private BitmapFont font;
	private CharSequence str = "Hello World!";

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		spriteBatch.begin();
		stage.act();
		stage.draw();
		font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		font.draw(spriteBatch, str, 100, 100);
		spriteBatch.end();
	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		Gdx.app.log(TAG, "...Resizing!");
	}

	@Override
	public void show() {

		spriteBatch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("fonts/broadway_red64.fnt"), Gdx.files.internal("fonts/broadway_red64.png"), false);

		buttonMenu.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				// Same way we moved here from the Splash Screen
				// We set it to new Splash because we got no other screens
				// otherwise you put the screen there where you want to go
				((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
			}
		});

		// The elements are displayed in the order you add them.
		// The first appear on top, the last at the bottom.
		table.add(buttonMenu).size(250, 100).padBottom(20).row();
		table.top().right();
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
	}

	@Override
	public void dispose() {
		texture.dispose();
		stage.dispose();

	}
}
