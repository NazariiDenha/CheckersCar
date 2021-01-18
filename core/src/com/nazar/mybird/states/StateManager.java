package com.nazar.mybird.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class StateManager {
    private Stack<State> states;

    public StateManager() {
        states = new Stack<>();
    }
    public void push(State state){
        states.push(state);
    }
    public void pop(){
        states.pop();
    }
    public void reset(State state){
        states.pop();
        states.push(state);
    }
    public void update(float time){
        states.peek().update(time);
    }
    public void render(SpriteBatch batch){
        states.peek().render(batch);
    }
}
