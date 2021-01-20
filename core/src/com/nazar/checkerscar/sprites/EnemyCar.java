package com.nazar.checkerscar.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

public class EnemyCar extends Car{
    private boolean isReversed;
    private Random random = new Random();
    private Lane lane;
    public EnemyCar(int x, int y, boolean isReversed, Lane lane) {
        super(x, y);
        this.lane = lane;
        this.isReversed = isReversed;
        if (!isReversed)texture = new Texture("enemycar.png");else texture = new Texture("enemycarreversed.png");
        bounds = new Rectangle(x + 10, y + 7, texture.getWidth() - 20, texture.getHeight() - 14);
    }

    @Override
    public void update() {
        if (bounds.overlaps(MyCar.bounds))lane.endGame();
        if (isReversed)pos.x -= 4 + MyCar.xSpeed;else pos.x -= MyCar.xSpeed - 1;
        bounds.setPosition(pos.x + 10, pos.y + 7);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(texture, pos.x, pos.y);
    }
}
