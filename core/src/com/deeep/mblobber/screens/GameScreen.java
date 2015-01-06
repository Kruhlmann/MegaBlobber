package com.deeep.mblobber.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.deeep.mblobber.Core;
import com.deeep.mblobber.World;
import com.deeep.mblobber.background.Space;
import com.deeep.mblobber.input.Assets;
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
    private BitmapFont bitmapFont;
    public TextEffects textEffects;

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
        space.draw(hudBatch, shapeRenderer);
        shapeRenderer.end();
        Gdx.gl.glDisable(GL20.GL_BLEND);
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
        hudBatch.begin();
        bitmapFont.setScale(1);
        bitmapFont.draw(hudBatch, "Score: " + world.difficulty.score, 10, Gdx.graphics.getHeight() - 5);
        int tempY = (int) bitmapFont.getLineHeight();
        bitmapFont.setScale(0.5f);
        bitmapFont.draw(hudBatch, "Multiplier: " + world.difficulty.getMultiplier() + "x", 10, Gdx.graphics.getHeight() - 10 - tempY + bitmapFont.getLineHeight());
        bitmapFont.setScale(0.4f);
        bitmapFont.draw(hudBatch, "" + world.difficulty.consecutive, Gdx.graphics.getWidth() - 25, Gdx.graphics.getHeight() - 25);
        textEffects.draw(hudBatch);
        hudBatch.end();
    }

    @Override
    public void show() {
//        logger = Logger.getInstance();
        space = new Space(400);
        shapeRenderer = new ShapeRenderer();
        batch = Core.batch;
        hudBatch = new SpriteBatch();
        stage = new Stage(new FitViewport(Core.VIRTUAL_WIDTH, Core.VIRTUAL_HEIGHT), batch);
        hudStage = new Stage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), hudBatch);
        world = new World(game);
        stage.addActor(world);

        Gdx.input.setInputProcessor(new GameInputProcessor(this));
        bitmapFont = Assets.getAssets().getBitmapFont();
        game.actionResolver.loginGPGS();
        textEffects = new TextEffects();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
        hudStage = new Stage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), hudBatch);
        space = new Space(400);
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