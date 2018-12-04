package com.marko.objects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.marko.world.GameWorld;


public class Platform {

    private Vector2 position;
    private Rectangle rectangle;
    private int width, height, midY, midX;
    private ObjectColor platformColor;
    private GameWorld world;

    public static int score;

    public Platform(float x, float y, int midX, int midY, GameWorld world) {
        this.world = world;
        rectangle = new Rectangle();
        this.midY = midY;
        this.midX = midX;
        width = 120;
        height = 20;
        position = new Vector2(x, y);

        platformColor = ObjectColor.BLUE;
        score = 0;

    }

    public void update(float delta, Platform platform, Ball ball) {
        if (position.y > midY * 2) {
            onTop(platform);
            score++;
        }

        rectangle.set(position.x, position.y, width, height);
    }

    public void onTop(Platform platform) {
        position.x = (midX * 2 - width) * (float) Math.random();
        position.y = platform.getPosition().y - 100 - 200 * (float) Math.random();

        switch ((int) (3 * Math.random())) {
            case 0:
                platformColor = platformColor.BLUE;
                break;
            case 1:
                platformColor = platformColor.RED;
                break;
            case 2:
                platformColor = platformColor.YELLOW;
                break;
            default:
                break;
        }
    }

    public void moveDown(Vector2 v) {
        position.add(0, -v.y);
    }

    //***GETTERS***
    public Rectangle getRectangle() { return rectangle; }

    public Vector2 getPosition() {
        return position;
    }

    public ObjectColor getPlatformColor() {
        return platformColor;
    }

    public static int getScore(){ return score; }

}
