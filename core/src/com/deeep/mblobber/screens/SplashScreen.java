package com.deeep.mblobber.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.deeep.mblobber.AbstractGame;
import com.deeep.mblobber.Core;
import com.deeep.mblobber.entities.LoadingBar;
import com.deeep.mblobber.entities.SplashActor;
import com.deeep.mblobber.input.Assets;

/**
 * Created by scanevaro on 09/12/2014.
 */
public class SplashScreen implements Screen {
    private static final float DURATION = 3.5f; //Duration of the SplashScreen
    private Core game;
    private Stage stage;
    private SplashActor splashSprite;
    private Timer.Task timer;
    private Image loadingFrame;
    private Image loadingBarHidden;
    private Image loadingBg;
    private Actor loadingBar;
    private float startX, endX;
    private float percent;

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
                if (Assets.getAssets().assetManager.update()) {
                    timer.cancel();
                    game.setScreen(new GameScreen(game));
                }
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

        if (Assets.getAssets().assetManager.update() && !Assets.loaded) {
            Assets.getAssets().set();

            if (splashSprite.stateTime < 3f) {
                /**Delay fade out*/
                splashSprite.addAction(Actions.delay(3f - splashSprite.stateTime));
                loadingFrame.addAction(Actions.delay(3f - splashSprite.stateTime));
                loadingBar.addAction(Actions.delay(3f - splashSprite.stateTime));
                loadingBarHidden.addAction(Actions.delay(3f - splashSprite.stateTime));
                loadingBg.addAction(Actions.delay(3f - splashSprite.stateTime));
            }

            /**Fade out actors*/
            splashSprite.addAction(Actions.fadeOut(0.5f));
            loadingFrame.addAction(Actions.fadeOut(0.5f));
            loadingBar.addAction(Actions.fadeOut(0.5f));
            loadingBarHidden.addAction(Actions.fadeOut(0.5f));
            loadingBg.addAction(Actions.fadeOut(0.5f));
            Timer.schedule(timer = new Timer.Task() {
                @Override
                public void run() {
                    game.setScreen(new GameScreen(game));
                }
            }, DURATION - splashSprite.stateTime);
            Assets.loaded = true;
        }

        percent = Interpolation.linear.apply(percent, Assets.getAssets().assetManager.getProgress(), 0.1f);

        loadingBarHidden.setX(startX + endX * percent);
        loadingBg.setSize(512, 50);
        loadingBg.setX(loadingBarHidden.getX() + 30);
        loadingBg.setY(loadingBarHidden.getY() + 4);
        loadingBg.setWidth(512 - 512 * percent);
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }

    @Override
    public void show() {
        game = (Core) Gdx.app.getApplicationListener();

        stage = new Stage(new FitViewport(AbstractGame.VIRTUAL_WIDTH, AbstractGame.VIRTUAL_HEIGHT), Core.batch);

        Gdx.input.setInputProcessor(stage);

        setActors();
        configureActors();
        setListeners();
        setLayout();

        TextureAtlas atlas = Assets.getAssets().assetManager.get("data/loading.pack");

        loadingFrame = new Image(atlas.findRegion("loading-frame"));
        loadingFrame.setSize(512, 55);
        loadingFrame.setPosition(0, 0);
        loadingBarHidden = new Image(atlas.findRegion("loading-bar-hidden"));
        loadingBarHidden.setPosition(0, 1.1f);
        loadingBg = new Image(atlas.findRegion("loading-frame-bg"));

        Animation anim = new Animation(0.05f, atlas.findRegions("loading-bar-anim"));
        anim.setPlayMode(Animation.PlayMode.LOOP_REVERSED);
        loadingBar = new LoadingBar(anim);
        loadingBar.setPosition(0, 5);

        stage.addActor(loadingBar);
        stage.addActor(loadingBg);
        stage.addActor(loadingBarHidden);
        stage.addActor(loadingFrame);

        startX = 0;
        endX = 512;
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