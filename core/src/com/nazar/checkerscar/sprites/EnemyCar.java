package com.nazar.checkerscar.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

public class EnemyCar extends Car{
    private boolean isReversed;
    private Random random = new Random();
    public EnemyCar(int x, int y, boolean isReversed) {
        super(x, y);
        this.isReversed = isReversed;
        if (!isReversed)texture = new Texture("enemycar.png");else texture = new Texture("enemycarreversed.png");
        bounds = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
    }

    @Override
    public void update() {
        if (isReversed)pos.x -= 1.5 * MyCar.xSpeed;else pos.x -= MyCar.xSpeed / 1.5;
    }

    @Override
    public void render(SpriteBatch batch) {
        System.out.println(pos.x + " " + pos.y);
        batch.draw(texture, pos.x, pos.y);
    }
}
