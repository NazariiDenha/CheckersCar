package com.nazar.checkerscar;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nazar.checkerscar.states.MenuState;
import com.nazar.checkerscar.states.StateManager;

public class CheckersCar extends ApplicationAdapter {
	private SpriteBatch batch;
	private StateManager manager;
	private Music music;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		manager = new StateManager();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		manager.push(new MenuState(manager));

		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setLooping(true);
		music.setVolume(0.5f);
		music.play();
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		manager.update(Gdx.graphics.getDeltaTime());
		manager.render(batch);
	}

	
	@Override
	public void dispose () {

	}
}
