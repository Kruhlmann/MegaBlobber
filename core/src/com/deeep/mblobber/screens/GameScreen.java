package com.deeep.mblobber.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.deeep.mblobber.World;
import com.deeep.mblobber.background.Space;
import com.deeep.mblobber.input.GameInputProcessor;

/**
 * Created by scanevaro on 05/12/2014.
 */
public class GameScreen implements Screen {
    private Core game;
    //    private Logger logger;
    private SpriteBatch batch;
    private SpriteBatch hudBatch;
    public static Stage stage;
    public static Stage hudStage;
    public World world;
    private Space space;
    private ShapeRenderer shapeRenderer;

    public GameScreen(Core game) {
        this.game = game;
    }

    @Override
    public void render(float delta) {
        Gdx.graphics.getGL20().glClearColor(0, 0, 0, 1);
        Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        space.update(delta);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setProjectionMatrix(hudStage.getCamera().combined);
        shapeRenderer.setColor(Color.WHITE);
        Gdx.gl.glDisable(GL20.GL_BLEND);
        space.draw(hudBatch, shapeRenderer);
        shapeRenderer.end();
        batch.setProjectionMatrix(stage.getCamera().combined);
        /** updates */
        world.update(delta);

        /** draws */
//        world.draw(batch);
        Gdx.gl.glViewport(stage.getViewport().getScreenX(), stage.getViewport().getScreenY(), stage.getViewport().getScreenWidth(), stage.getViewport().getScreenHeight());
        stage.draw();
        hudStage.act();
        Gdx.gl.glViewport(hudStage.getViewport().getScreenX(), hudStage.getViewport().getScreenY(), hudStage.getViewport().getScreenWidth(), hudStage.getViewport().getScreenHeight());
        hudStage.draw();

    }

    @Override
    public void show() {
//        logger = Logger.getInstance();
        space = new Space(500);
        shapeRenderer = new ShapeRenderer();
        batch = Core.batch;
        hudBatch = new SpriteBatch();
        stage = new Stage(new FitViewport(Core.VIRTUAL_WIDTH, Core.VIRTUAL_HEIGHT), batch);
        hudStage = new Stage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), hudBatch);
        world = new World(game);
        stage.addActor(world);

        Gdx.input.setInputProcessor(new GameInputProcessor(this));

        game.actionResolver.loginGPGS();
    }

    @Override
    public void resize(int width, int height) {
        hudStage.getViewport().update(width, height, true);
        stage.getViewport().update(width, height, true);
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