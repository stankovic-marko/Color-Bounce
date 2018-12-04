package com.marko.handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Loader {

    //***TEXTURES***
    public static Texture balls, platforms,indicators,bannerTop,background;
    public static TextureRegion blueBall, redBall, yellowBall, bluePlatform, redPlatform, yellowPlatform, blueIndicator,redIndicator,yellowIndicator, indicator,backgroundRegion;
    //***SOUNDS***
    public static Sound hitSound;

    public static void load() {

        //***LOADS TEXTURE***
        background = new Texture(Gdx.files.internal("data/Background.png"));
        bannerTop = new Texture(Gdx.files.internal("data/Banner_Top.png"));
        balls = new Texture(Gdx.files.internal("data/Balls.png"));
        platforms = new Texture(Gdx.files.internal("data/Platforms.png"));
        indicators = new Texture(Gdx.files.internal("data/Indicator.png"));

        backgroundRegion = new TextureRegion(background, 0,0,720,1280);
        backgroundRegion.flip(false,true);

        blueBall = new TextureRegion(balls, 0, 0, 50, 51);
        redBall = new TextureRegion(balls, 0, 51, 50, 51);
        yellowBall = new TextureRegion(balls, 0, 102, 50, 51);

        bluePlatform = new TextureRegion(platforms, 0, 0, 120, 20);
        redPlatform = new TextureRegion(platforms, 0, 20, 120, 20);
        yellowPlatform = new TextureRegion(platforms, 0, 40, 120, 20);

        blueIndicator = new TextureRegion(indicators, 0,0,5,5);
        redIndicator = new TextureRegion(indicators,5,0,5,5);
        yellowIndicator = new TextureRegion(indicators,10,0,5,5);
        indicator = new TextureRegion(indicators ,0,5,5,5);

        //***LOADS SOUND***
        hitSound = Gdx.audio.newSound(Gdx.files.internal("data/sound.wav"));

    }

    public static void dispose() {
        bannerTop.dispose();
        balls.dispose();
        platforms.dispose();
    }
}
