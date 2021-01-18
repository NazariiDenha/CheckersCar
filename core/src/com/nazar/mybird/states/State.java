package com.nazar.mybird.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class State {
    protected StateManager manager;

    public State(StateManager manager) {
        this.manager = manager;
    }
    protected abstract void handle();
    public abstract void update(float time);
    public abstract void render(SpriteBatch batch);
}
