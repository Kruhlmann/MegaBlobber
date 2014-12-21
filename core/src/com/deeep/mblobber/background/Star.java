package com.deeep.mblobber.background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.deeep.mblobber.entities.Entity;


/**
 * Created by E on 12/7/2014.
 */
public class Star extends Entity {
    private int distance;
    private double angle;
    private double maxDistance;
    boolean increment;
    private Color color = new Color(1f,1f,1f,1f);
    float incrementSpeed;
    float alpha = 0;

    public Star(int distance, double angle, float initial, float speed, boolean up) {
        this.distance = distance;
        this.angle = angle;
        this.alpha = initial;
        this.increment = up;
        this.incrementSpeed = speed;
        maxDistance = Math.sqrt(Gdx.graphics.getWidth() * Gdx.graphics.getWidth()+ Gdx.graphics.getHeight()* Gdx.graphics.getHeight());
    }

    @Override
    public void update(float deltaT) {
        angle += (deltaT/50);
        this.x = (float) (Math.cos(angle) * distance) + Gdx.graphics.getWidth()/2;
        this.y = (float) (Math.sin(angle) * distance) + Gdx.graphics.getHeight()/2;
        if (increment) {
            if (alpha + deltaT * incrementSpeed >= 1) {
                increment = false;
            } else {
                alpha += deltaT * incrementSpeed;
            }
        } else {
            if (alpha - deltaT * incrementSpeed <= 0) {
                increment = true;
            } else {
                alpha -= deltaT * incrementSpeed;
            }
        }
        color.a = alpha;
    }


    public void draw(ShapeRenderer shapeRenderer, SpriteBatch spriteBatch) {
        shapeRenderer.setColor(color);
        shapeRenderer.rect(x, y, 2,2);
    }
}
