package com.deeep.mblobber.background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.deeep.mblobber.screens.GameScreen;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by E on 12/7/2014.
 */
public class Space {
    private ArrayList<Star> stars = new ArrayList<Star>();
    private float rotation;
    public Space(int starNumber) {
        Random random = new Random();
        int width = Gdx.graphics.getWidth();
        int height= Gdx.graphics.getHeight();
        double distance = Math.sqrt(width * width + height* height);
        for (int i = 0; i < starNumber; i++) {
            stars.add(new Star(random.nextInt((int) distance/2), random.nextDouble() * Math.PI * 2, random.nextFloat(), 0.5f * random.nextFloat() + 0.5f, random.nextBoolean()));
        }
    }

    public void update(float deltaT) {
        for (Star star : stars) {
            star.update(deltaT);
        }
    }

    public void setRotation(float rotation){
           this.rotation = rotation;
    }

    public void draw(SpriteBatch spriteBatch, ShapeRenderer shapeRenderer) {
        shapeRenderer.rotate(20,20,0,rotation);
        for (Star star : stars) {
            star.draw(shapeRenderer, spriteBatch);
        }
        shapeRenderer.rotate(20,20,0,-rotation);
    }
}
