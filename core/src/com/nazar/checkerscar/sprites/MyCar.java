package com.nazar.checkerscar.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class MyCar extends Car{
    public static int xSpeed;
    private int minSpeed = 0;
    private int ySpeed = 3;
    private int mxYSpeed = 10;
    protected static Rectangle bounds;
    public MyCar() {
        super(20, 233);
        vel = new Vector2(minSpeed, 0);
        xSpeed = minSpeed;
        texture = new Texture("mycar.png");
        bounds = new Rectangle(20 + 10, 233 + 10, texture.getWidth() - 20, texture.getHeight() - 20);
    }

    @Override
    public void update() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT) || Gdx.input.isKeyJustPressed(Input.Keys.D)){
            vel.x++;
            xSpeed++;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT) || Gdx.input.isKeyJustPressed(Input.Keys.A)){
            if (vel.x - 1 >= minSpeed){
                vel.x--;
                xSpeed--;
            }
            if (vel.x - 1 >= minSpeed){
                vel.x--;
                xSpeed--;
            }
        }
        int ys = (int)Math.min(mxYSpeed, ySpeed + vel.x - minSpeed);
        if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)){
            if (pos.y + ys + texture.getHeight() <= 562){
                vel.y = ys;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)){
            if (pos.y - ys >= 0){
                vel.y = -ys;
            }
        }
        pos.y += vel.y;
        vel.y = 0;
        bounds.setPosition(pos.x + 10, pos.y + 10);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(texture, pos.x, pos.y);
    }
}
