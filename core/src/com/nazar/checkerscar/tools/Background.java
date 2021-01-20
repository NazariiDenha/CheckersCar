package com.nazar.checkerscar.tools;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.nazar.checkerscar.sprites.MyCar;


public class Background {
    private final int speed;
    private static class Picture{
        public Texture texture;
        public Vector2 pos;
        public Picture(Vector2 pos) {
            this.pos = pos;
            texture = new Texture("back.jpg");
        }
    }
    private final Picture[] pictures;
    public Background() {
        speed = 1;
        pictures = new Picture[2];
        pictures[0] = new Picture(new Vector2(0, 0));
        pictures[1] = new Picture(new Vector2(860, 0));
    }

    public void render(SpriteBatch batch){
        for (Picture picture : pictures) {
            batch.draw(picture.texture, picture.pos.x, picture.pos.y);
        }
    }

    public void update(){
        int sp = MyCar.xSpeed;
        for (Picture picture : pictures) {
            picture.pos.x -= sp;
            if (picture.pos.x <= -860) {
                picture.pos.x = 860 + picture.pos.x + 860;
            }
        }
    }
}
