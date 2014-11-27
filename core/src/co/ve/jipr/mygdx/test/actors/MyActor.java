package co.ve.jipr.mygdx.test.actors;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;


public class MyActor extends Actor {

	Texture texture = new Texture(Gdx.files.internal("images/ic_launcher.png"));
	float actorX = 0, actorY = 0;
	public boolean started = false;

	public MyActor() {
		setBounds(actorX, actorY, texture.getWidth(), texture.getHeight());
		addListener(new InputListener() {

			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				// do something on touch!!
				((MyActor) event.getTarget()).started = true;
				return true;
			}
		});
	}

	@Override
	public void draw(Batch batch, float alpha) {
		batch.draw(texture, actorX, actorY);
	}

	@Override
	public void act(float delta) {
		// if (started) {
		actorX += 5;
		// }
	}


}
