package com.marko.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.marko.world.GameWorld;

public class Ball {

    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private int radius;
    private int midY;
    private int midX;
    private int dVY = -1200;

    private boolean isAlive;

    private Circle circle, collisionCircle;
    private ObjectColor ballColor;
    private GameWorld world;

    public Ball(float x, float y, int radius, int midY, int midX, GameWorld world) {

        this.midY = midY;
        this.midX = midX;
        this.radius = radius;
        this.world = world;

        position = new Vector2(x, y);
        velocity = new Vector2(0, dVY);
        acceleration = new Vector2(0, 1700);

        circle = new Circle();
        isAlive = true;
        collisionCircle = new Circle();

        ballColor = ObjectColor.BLUE;
    }

    public void update(float delta, Platform[] platform) {
        velocity.add(acceleration.cpy().scl(delta));
        position.add(velocity.cpy().scl(delta));

        circle.set(position.x, position.y, radius);
        collisionCircle.set(position.x, position.y + radius / 2, radius / 2);

        position.x -= Gdx.input.getAccelerometerX() * 3 * (1 + delta);
        if (position.y > midY * 2) {
            isAlive = false;
        }
        
        if (position.y <= midY) {
            position.y = midY;
            for (int i = 0; i < platform.length; i++) {
                if (velocity.y < 0)
                    platform[i].moveDown(velocity.cpy().scl(delta));
            }
        }

        if (position.x < 0) {
            position.x = midX * 2;
        } else if (position.x > midX * 2) {
            position.x = 0;
        }
    }

    public void onClick() {
        switch (ballColor) {
            case BLUE:
                ballColor = ballColor.RED;
                break;
            case RED:
                ballColor = ballColor.YELLOW;
                break;
            case YELLOW:
                ballColor = ballColor.BLUE;
                break;
            default:
                ballColor = ballColor.BLUE;
                break;
        }
    }

    public void jump(int v) {
        velocity.y = v;
    }

    //***GETTERS***
    public Circle getCircle() { return circle; }

    public Circle getCollisionCircle() { return collisionCircle;}

    public float getvY() { return velocity.y; }

    public boolean isAlive() { return isAlive; }

    public ObjectColor getBallColor() { return ballColor; }

    public int getdVY() { return dVY; }

    //***SETTERS***
    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }






}
