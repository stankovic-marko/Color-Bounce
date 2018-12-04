package com.marko.world;

import com.badlogic.gdx.math.Intersector;
import com.marko.handlers.Loader;
import com.marko.objects.Ball;
import com.marko.screens.GameScreen;

import com.marko.objects.Platform;


public class GameWorld {

    private int midPointY;
    private Ball ball;
    private Platform[] platform = new Platform[20];

    public GameWorld(int midX, int midY) {
        midPointY = midY;
        ball = new Ball(midX, midY * 2 - 50, 35, midY, midX, this);
        for (int i = 0; i < platform.length; i++) {
            platform[i] = new Platform((float) Math.random() * (midX * 2 - 200), midY * 2 - 100 * i, midX, midY, this);
        }
    }

    public  void update(float delta, GameScreen screen){
        if(ball.isAlive()) {
            for (int i = 0; i < platform.length; i++) {
                //***COLLISION***
                if (Intersector.overlaps(ball.getCollisionCircle(), platform[i].getRectangle()) && ball.getvY() > 0) {
                    if (ball.getBallColor() == platform[i].getPlatformColor()) {
                        ball.jump(ball.getdVY());
                        Loader.hitSound.play();
                    }else {
                    }
                }
                }
            } else {
        }
        ball.update(delta, platform);
        for (int i = 0; i< platform.length; i++){
            platform[i].update(delta, i == 0 ? platform[platform.length - 1] : platform[i - 1], ball);
        }
    }
    //***GETTERS***
    public Ball getBall(){
        return ball;
    }
    public Platform[] getPlatform(){
        return platform;
    }
}
