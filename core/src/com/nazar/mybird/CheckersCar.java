package com.nazar.mybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nazar.mybird.states.MenuState;
import com.nazar.mybird.states.StateManager;

public class CheckersCar extends ApplicationAdapter {
	private SpriteBatch batch;
	private StateManager manager;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		manager = new StateManager();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		manager.push(new MenuState(manager));
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
