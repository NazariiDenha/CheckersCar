package com.nazar.checkerscar.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class MyCar extends Car{
    private int minSpeed = 4;
    private int ySpeed = 3;
    private int mxYSpeed = 8;
    public MyCar(int x, int y) {
        super(x, y);
        vel = new Vector2(minSpeed, 0);
        texture = new Texture("mycar.png");
        bounds = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
    }

    public int getXSpeed(){
        return (int)vel.x;
    }

    @Override
    public void update(float time) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            vel.x++;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            if (vel.x - 1 >= minSpeed){
                vel.x--;
            }
        }
        int ys = (int)Math.min(mxYSpeed, ySpeed + vel.x - 4);
        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            if (pos.y + ys + texture.getHeight() <= 562){
                vel.y = ys;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            if (pos.y - ys >= 0){
                vel.y = -ys;
            }
        }
        pos.y += vel.y;
        vel.y = 0;
        bounds.setPosition(pos.x, pos.y);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(texture, pos.x, pos.y);
    }
}
