package com.nazar.checkerscar.sprites;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class EnemyCar extends Car{
    private boolean isReversed;
    private Random random = new Random();
    public EnemyCar(int x, int y) {
        super(x, y);
        isReversed = random.nextBoolean();

    }

    @Override
    public void update(float time) {

    }

    @Override
    public void render(SpriteBatch batch) {

    }
}
