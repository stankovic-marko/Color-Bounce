package com.marko.handlers;

import com.badlogic.gdx.InputProcessor;
import com.marko.objects.Ball;
import com.marko.world.GameWorld;

public class InputHandler implements InputProcessor {

    private GameWorld world;
    private Ball myBall;

    public InputHandler(GameWorld world) {
        this.world = world;
    }

    public InputHandler(Ball ball) {
        this.myBall = ball;
    }

    @Override
    public boolean keyDown(int keycode) {return false; }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        myBall.onClick();
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
