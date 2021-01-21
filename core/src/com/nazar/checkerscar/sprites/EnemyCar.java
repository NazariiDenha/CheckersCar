package com.nazar.checkerscar.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

public class EnemyCar extends Car{
    private boolean isReversed;
    private Random random = new Random();
    private Lane lane;
    private int mySpeed;
    public EnemyCar(int x, int y, boolean isReversed, Lane lane) {
        super(x, y);
        this.lane = lane;
        this.isReversed = isReversed;
        Integer color = random.nextInt(4);
        if (!isReversed)texture = new Texture("enemycars/enemycar" + color.toString() + ".png");
            else texture = new Texture("enemycars/enemycarreversed" + color.toString() + ".png");
        bounds = new Rectangle(x + 12, y + 7, texture.getWidth() - 24, texture.getHeight() - 14);
        mySpeed = random.nextInt(3) + 4;
        System.out.println(mySpeed);
    }

    public int getMySpeed() {
        return mySpeed;
    }

    public void setMySpeed(int mySpeed) {
        this.mySpeed = mySpeed;
    }

    @Override
    public void update() {
        if (bounds.overlaps(MyCar.bounds))lane.endGame();
        if (isReversed)pos.x -= mySpeed + MyCar.xSpeed;else pos.x -= MyCar.xSpeed - mySpeed + 3;
        bounds.setPosition(pos.x + 12, pos.y + 7);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(texture, pos.x, pos.y);
    }
}
