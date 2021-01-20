package com.nazar.checkerscar.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class MenuState extends State {
    private Texture bgtexture;
    private ImageButton startButton;
    private Stage stage;

    public MenuState(final StateManager manager) {
        super(manager);
        bgtexture = new Texture("back.jpg");


        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        startButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("startbtn.png"))));
        startButton.setPosition(270, 226);
        startButton.addListener(new ClickListener(){
           public void clicked(InputEvent event, float x, float y){
               manager.reset(new com.nazar.checkerscar.states.GameState(manager));
           }
        });
        stage.addActor(startButton);
    }

    @Override
    protected void handle() {

    }

    @Override
    public void update(float time) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            manager.reset(new GameState(manager));
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        //batch.enableBlending();
        batch.begin();
        //

        batch.draw(bgtexture, 0, 0);
        //batch.draw(bb, 0, 0);
        batch.end();
        stage.draw();
    }
}
