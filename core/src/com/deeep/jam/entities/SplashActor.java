package com.deeep.jam.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.utils.Array;
import com.deeep.jam.screens.AbstractGame;

/**
 * Created by scanevaro on 09/12/2014.
 */
public class SplashActor extends Actor {
    private Animation animation;
    private float stateTime;

    public SplashActor() {
        Array<TextureAtlas.AtlasRegion> atlasRegions = new TextureAtlas(Gdx.files.internal("data/newLogo.pack")).getRegions();
        animation = new Animation(0.5f, atlasRegions);

        setActions();

        stateTime = 0;
    }

    private void setActions() {
        SequenceAction secAction = new SequenceAction();
        secAction.addAction(Actions.fadeIn(0.5f));
        secAction.addAction(Actions.delay(2.5f));
        secAction.addAction(Actions.fadeOut(0.5f));
        addAction(secAction);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = new Color(getColor().r, getColor().g,
                getColor().b, getColor().a * parentAlpha);

        batch.setColor(color);

        batch.draw(animation.getKeyFrame(stateTime), 0, 0, AbstractGame.VIRTUAL_WIDTH, AbstractGame.VIRTUAL_HEIGHT);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        stateTime += delta;
    }
}