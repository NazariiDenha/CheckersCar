package com.nazar.mybird.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nazar.mybird.tools.Background;

public class GameState extends State{
    private Background background;

    public GameState(StateManager manager) {
        super(manager);
        background = new Background();
    }

    @Override
    protected void handle() {

    }

    @Override
    public void update(float time) {
        background.update();
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            System.out.println("Right");
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            System.out.println("Left");
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            System.out.println("Up");
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            System.out.println("Down");
        }
        //System.out.println("updated");
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        background.render(batch);
        batch.end();
    }
}
