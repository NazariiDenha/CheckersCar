package com.nazar.checkerscar.states;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.nazar.checkerscar.sprites.Lane;
import com.nazar.checkerscar.sprites.MyCar;
import com.nazar.checkerscar.tools.Background;

import java.util.ArrayList;

public class GameState extends State{
    private com.nazar.checkerscar.tools.Background background;
    private MyCar myCar;
    private ArrayList<Lane> lanes;
    private Integer score;
    private Label scoreLabel;
    public Stage stage;
    private Texture gameOver;
    private boolean isGameOver;
    private Float timeGameOver;


    public GameState(StateManager manager) {
        super(manager);
        background = new Background();
        myCar = new MyCar();
        lanes = new ArrayList<>();
        lanes.add(new Lane(false, 5, 56, this));
        lanes.add(new Lane(false, 140, 191, this));
        lanes.add(new Lane(true, 280, 331, this));
        lanes.add(new Lane(true, 415, 466, this));
        isGameOver = false;
        timeGameOver = 0f;


        stage = new Stage();
        Table table = new Table();
        table.top();
        table.setFillParent(true);
        score = 0;
        BitmapFont bf = new BitmapFont(Gdx.files.internal("dada.fnt"));
        scoreLabel = new Label(String.format("%06d", score), new Label.LabelStyle(bf, Color.WHITE));
        scoreLabel.setFontScale(1.3f);
        table.add(scoreLabel).expandX();
        stage.addActor(table);
        //scoreLabel = new Label("");
        //scoreLabel.setColor(1, 1, 1, 1);
    }

    @Override
    protected void handle() {

    }

    @Override
    public void update(float time) {
        if (!isGameOver) {
            background.update();
            myCar.update();
            for (Lane lane : lanes) {
                lane.update();
            }
        }

        if (isGameOver){
            timeGameOver += time;
            if (timeGameOver >= 3)manager.reset(new MenuState(manager));
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
        //scoreLabel.draw(batch, "SCORE: " + score.toString(), 0, 500);
        if (isGameOver)batch.draw(gameOver, 228, 131);

        batch.end();
        stage.draw();
    }

    public void endGame()  {
        gameOver = new Texture("gameover.png");
        isGameOver = true;
    }

    public void updateScore() {
        score++;
        scoreLabel.setText(String.format("%06d", score));
    }
}
