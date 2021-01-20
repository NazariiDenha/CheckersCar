package com.nazar.checkerscar.states;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nazar.checkerscar.sprites.Lane;
import com.nazar.checkerscar.sprites.MyCar;
import com.nazar.checkerscar.tools.Background;

import java.util.ArrayList;

public class GameState extends State{
    private com.nazar.checkerscar.tools.Background background;
    private MyCar myCar;
    private ArrayList<Lane> lanes;

    public GameState(StateManager manager) {
        super(manager);
        background = new Background();
        myCar = new MyCar();
        lanes = new ArrayList<>();
        lanes.add(new Lane(false, 5, 51, this));
        lanes.add(new Lane(false, 140, 185, this));
        lanes.add(new Lane(true, 280, 325, this));
        lanes.add(new Lane(true, 415, 461, this));
    }

    @Override
    protected void handle() {

    }

    @Override
    public void update(float time) {
        background.update();
        myCar.update();
        for (Lane lane : lanes){
            lane.update();
        }
        //System.out.println("updated");
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        background.render(batch);
        myCar.render(batch);
        for (Lane lane : lanes){
            lane.render(batch);
        }
        batch.end();
    }

    public void endGame()  {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
        manager.reset(new MenuState(manager));
    }
}
