package com.nazar.mybird;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import sun.security.mscapi.CPublicKey;


public class Background {
    private final int speed;
    private static class Picture{
        public Texture texture;
        public Vector2 pos;
        public Picture(Vector2 pos) {
            this.pos = pos;
            texture = new Texture("background.png");
        }
    }
    private final Picture[] pictures;
    public Background(int x) {
        speed = 4;
        pictures = new Picture[2];
        pictures[0] = new Picture(new Vector2(0, 0));
        pictures[1] = new Picture(new Vector2(900, 0));
    }

    public void render(SpriteBatch batch){
        for (Picture picture : pictures) {
            batch.draw(picture.texture, picture.pos.x, picture.pos.y);
        }
    }

    public void update(){
        for (Picture picture : pictures) {
            picture.pos.x -= speed;
            if (picture.pos.x <= -900) {
                picture.pos.x = 900;
            }
        }
    }
}
