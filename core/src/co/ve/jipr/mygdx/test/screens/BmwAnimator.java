package co.ve.jipr.mygdx.test.screens;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

@SuppressWarnings("unused")
public class BmwAnimator implements Screen {


	private static final String TAG = BmwAnimator.class.getSimpleName();

	private Texture texture = new Texture(Gdx.files.internal("images/bmw_logo.png"));
	private Image animatedImage = new Image(texture);
	private Stage stage = new Stage();
	private float screenWidth = Gdx.graphics.getWidth();
	private float screenHeight = Gdx.graphics.getHeight();
	private float screenMiddleX = screenWidth / 2;
	private float screenMiddleY = screenHeight / 2;
	private float x = screenMiddleX;
	private float y = screenMiddleY;

	// Table for the button
	private Table table = new Table();
	private Skin skin = new Skin(Gdx.files.internal("skins/menuSkin.json"), new TextureAtlas(Gdx.files.internal("skins/TextureTest.pack")));
	private TextButton buttonMenu = new TextButton("Menü", skin, "white");
	private Label title = new Label("Animation Title", skin);

	// ***
	private float k = 2.5f;

	private boolean flag = false;

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
		animatedImage.setX(x - animatedImage.getImageWidth() / 2);
		animatedImage.setY(y - animatedImage.getImageHeight() / 2);
		int min = 0;
		int max = 300;
		Random rand = new Random();
		int randomNumber = rand.nextInt((max - min) + 1) + min - 100;
		k = randomNumber;
		Gdx.app.error(TAG, "..Random: " + k);
		if (flag) {
			if (x < screenWidth - animatedImage.getImageWidth()) {
				x += k;
			}
			if (y < screenHeight - animatedImage.getImageHeight()) {
				y += k;
			}
		}
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		animatedImage.setX(x);
		animatedImage.setY(y);


		buttonMenu.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				// ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
				flag = !flag;

			}
		});
		// The elements are displayed in the order you add them.
		// The first appear on top, the last at the bottom.
		table.add(buttonMenu).size(250, 100).padBottom(20).row();
		table.bottom().right();

		table.setFillParent(true);
		Gdx.input.setInputProcessor(stage);

		stage.addActor(table);
		stage.addActor(animatedImage);
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
