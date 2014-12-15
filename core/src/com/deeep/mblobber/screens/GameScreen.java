package com.deeep.mblobber.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.deeep.mblobber.World;
import com.deeep.mblobber.input.GameInputProcessor;

/**
 * Created by scanevaro on 05/12/2014.
 */
public class GameScreen implements Screen {

    //    private Logger logger;
    private SpriteBatch batch;
    public World world;

    @Override
    public void render(float delta) {
        /** updates */
        world.update(delta);

        /** draws */
        world.draw(batch);
    }

    @Override
    public void show() {
//        logger = Logger.getInstance();
        batch = Core.batch;
        world = new World();

        Gdx.input.setInputProcessor(new GameInputProcessor(this));
    }

    @Override
    public void resize(int width, int height) {
        if(world!=null){

        }
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}