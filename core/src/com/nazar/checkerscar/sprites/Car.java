package com.nazar.checkerscar.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public abstract class Car {
    protected Vector2 pos;
    protected Vector2 vel;
    protected Rectangle bounds;
    protected Texture texture;
    public Car(int x, int y){
        pos = new Vector2(x, y);
    }
    public abstract void update(float time);
    public abstract void render(SpriteBatch batch);
}
