package com.nazar.checkerscar.states;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nazar.checkerscar.sprites.MyCar;
import com.nazar.checkerscar.tools.Background;

public class GameState extends State{
    private com.nazar.checkerscar.tools.Background background;
    private MyCar myCar;

    public GameState(StateManager manager) {
        super(manager);
        background = new Background();
        myCar = new MyCar(20, 233);
    }

    @Override
    protected void handle() {

    }

    @Override
    public void update(float time) {
        background.update();
        myCar.update(time);

        //System.out.println("updated");
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        background.render(batch);
        myCar.render(batch);
        batch.end();
    }
}
