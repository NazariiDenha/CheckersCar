package com.nazar.checkerscar.sprites;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.LinkedList;
import java.util.Random;

public class Lane {
    private boolean isReversed;
    private int yMin, yMax;
    private LinkedList<EnemyCar> cars;
    private Random random;

    public Lane(boolean isReversed, int yMin, int yMax) {
        this.isReversed = isReversed;
        this.yMin = yMin;
        this.yMax = yMax;
        random = new Random();
        cars = new LinkedList<>();
    }

    public void update(){
        EnemyCar lastCar = null;
        for (EnemyCar car : cars){
            car.update();
            lastCar = car;
        }
        if (!cars.isEmpty() && cars.peek().pos.x + cars.peek().texture.getWidth() < 0){
            cars.remove();
        }
        if (lastCar == null || lastCar.pos.x + lastCar.texture.getWidth() < 860){
            cars.add(new EnemyCar(860 + 50 + random.nextInt(4000), yMin + random.nextInt(yMax - yMin), isReversed));
        }
    }
    public void render(SpriteBatch batch){
        for (EnemyCar car : cars){
            car.render(batch);
        }
    }
}
