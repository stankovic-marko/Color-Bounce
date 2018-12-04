package com.marko.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Align;
import com.marko.handlers.Loader;
import com.marko.objects.Ball;
import com.marko.objects.Platform;

public class GameRender {

    private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batcher;

    private Ball ball;
    private Platform[] platform;

    private BitmapFont font;

    private int midPointY;
    private int midPointX;
    private int gameHeight;

    public GameRender(GameWorld world, int gameHeight, int midPointY,int midPointX) {
        myWorld = world;
        ball = myWorld.getBall();
        platform = myWorld.getPlatform();
        this.gameHeight = gameHeight;
        this.midPointY = midPointY;
        this.midPointX = midPointX;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 720, gameHeight);

        batcher = new SpriteBatch();

        batcher.setProjectionMatrix(cam.combined);


        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);

        font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(5, -5);
    }

    public void render(float runTime){

        //***BACKGROUND***
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        for (int i = 0; i< platform.length; i++){
            shapeRenderer.rect(platform[i].getRectangle().x, platform[i].getRectangle().y, platform[i].getRectangle().width, platform[i].getRectangle().height);
        }
        shapeRenderer.end();
        batcher.begin();

        batcher.draw(Loader.backgroundRegion,0,0,720,1280);

        //***PLATFORMS***
        for (int i = 0; i< platform.length; i++) {
            TextureRegion regionPlatform;
            switch (platform[i].getPlatformColor()){
                case BLUE:
                    regionPlatform = Loader.bluePlatform;
                    break;
                case RED:
                    regionPlatform = Loader.redPlatform;
                    break;
                case YELLOW:
                    regionPlatform = Loader.yellowPlatform;
                    break;
                default:
                    regionPlatform = Loader.bluePlatform;
                    break;

            }
            batcher.draw(regionPlatform, platform[i].getRectangle().x,platform[i].getRectangle().y,platform[i].getRectangle().width,platform[i].getRectangle().height);
        }

        //***BALL***
        TextureRegion regionBall;
        switch (ball.getBallColor()){
            case BLUE:
                regionBall = Loader.blueBall;
                break;
            case RED:
                regionBall = Loader.redBall;
                break;
            case YELLOW:
                regionBall = Loader.yellowBall;
                break;
            default:
                regionBall = Loader.blueBall;
                break;
        }
        batcher.draw(regionBall, ball.getCircle().x - ball.getCircle().radius, ball.getCircle().y - ball.getCircle().radius, ball.getCircle().radius * 2, ball.getCircle().radius * 2);

        //***TOP BANNER***
        batcher.draw(Loader.bannerTop,0,0,720,80);

        //***SCORE***
        font.draw(batcher, Integer.toString(Platform.getScore()), midPointX, 10, 0, Align.center, false);

        //***INDICATOR***
        batcher.draw(Loader.blueIndicator, 10, 10, 60, 60);
        batcher.draw(Loader.redIndicator,90,10,60,60);
        batcher.draw(Loader.yellowIndicator, 170, 10, 60, 60);

        switch (ball.getBallColor()){
            case BLUE:
                batcher.draw(Loader.indicator,10, 10, 60, 60);
                break;
            case RED:
                batcher.draw(Loader.indicator,90,10,60,60);
                break;
            case YELLOW:
                batcher.draw(Loader.indicator,170, 10, 60, 60);
                break;
            default:
                break;
        }
        batcher.end();
    }
}
