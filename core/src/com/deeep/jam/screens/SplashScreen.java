package com.deeep.jam.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.deeep.jam.entities.SplashActor;

/**
 * Created by scanevaro on 09/12/2014.
 */
public class SplashScreen implements Screen {
    private static final float DURATION = 4f; //Duration of the SplashScreen
    private Core game;
    private Stage stage;
    private SplashActor splashSprite;
    private Timer.Task timer;

    public SplashScreen() {
        game = (Core) Gdx.app.getApplicationListener();

        stage = new Stage(new StretchViewport(AbstractGame.VIRTUAL_WIDTH, AbstractGame.VIRTUAL_HEIGHT), Core.batch);

        Gdx.input.setInputProcessor(stage);

        setActors();
        configureActors();
        setListeners();
        setLayout();

        Timer.schedule(timer = new Timer.Task() {
            @Override
            public void run() {
                game.setScreen(new GameScreen());
            }
        }, DURATION);
    }

    private void setActors() {
        splashSprite = new SplashActor();
    }

    private void configureActors() {
        splashSprite.setColor(1, 1, 1, 0);
    }

    private void setListeners() {
        splashSprite.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                timer.cancel();
                game.setScreen(new GameScreen());
            }
        });
    }

    private void setLayout() {
        stage.addActor(splashSprite);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0.1f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        splashSprite.setPosition(AbstractGame.VIRTUAL_WIDTH / 2, AbstractGame.VIRTUAL_HEIGHT / 2);
        splashSprite.setSize(AbstractGame.VIRTUAL_WIDTH, AbstractGame.VIRTUAL_HEIGHT);
    }

    @Override
    public void show() {
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