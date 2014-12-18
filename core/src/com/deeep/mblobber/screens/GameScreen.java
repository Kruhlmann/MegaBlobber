package com.deeep.mblobber.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.deeep.mblobber.World;
import com.deeep.mblobber.input.GameInputProcessor;

/**
 * Created by scanevaro on 05/12/2014.
 */
public class GameScreen implements Screen {
    private Core game;
    //    private Logger logger;
    private SpriteBatch batch;
    public static Stage stage;
    public World world;

    public GameScreen(Core game) {
        this.game = game;
    }

    @Override
    public void render(float delta) {
        /** updates */
        world.update(delta);

        /** draws */
//        world.draw(batch);
        stage.draw();
    }

    @Override
    public void show() {
//        logger = Logger.getInstance();
        batch = Core.batch;
        stage = new Stage(new FitViewport(Core.VIRTUAL_WIDTH, Core.VIRTUAL_HEIGHT), batch);
        world = new World(game);
        stage.addActor(world);

        Gdx.input.setInputProcessor(new GameInputProcessor(this));

        game.actionResolver.loginGPGS();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
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