package com.marko.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.marko.game.ColorBounce;
import com.marko.handlers.InputHandler;
import com.marko.objects.Ball;
import com.marko.world.GameRender;
import com.marko.world.GameWorld;


public class GameScreen implements Screen {

    public ColorBounce colorBounce;

    private Ball ball;
    private GameWorld world;
    private GameRender renderer;

    private float runTime = 0;

    public GameScreen(ColorBounce colorBounce) {
        this.colorBounce = colorBounce;
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 720;
        float gameHeight = screenHeight / (screenWidth / gameWidth);

        int midPointY = (int) (gameHeight / 2);
        int midPointX = (int) (gameWidth / 2);

        world = new GameWorld(midPointX, midPointY);
        renderer = new GameRender(world, (int) gameHeight, midPointY,midPointX);

        Gdx.input.setInputProcessor(new InputHandler(world.getBall()));

    }

    @Override
    public void render(float delta) {
        runTime += delta;
        world.update(delta, this);
        renderer.render(runTime);
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
