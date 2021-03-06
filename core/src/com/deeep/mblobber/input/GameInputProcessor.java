package com.deeep.mblobber.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.deeep.mblobber.Settings;
import com.deeep.mblobber.World;
import com.deeep.mblobber.screens.GameScreen;

/**
 * Created by scanevaro on 06/12/2014.
 */
public class GameInputProcessor implements InputProcessor {
    private boolean touched;
    private float pressedRotation;
    private float worldRotation;
    private GameScreen screen;
    private int screenX;
    private int screenY;

    public GameInputProcessor(GameScreen screen) {
        this.screen = screen;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(!Settings.android) return false;
        if (screen.world.state == World.GAMEOVER) return false;
        float mouseX = (World.VIRTUAL_WIDTH / Gdx.graphics.getWidth()) * screenX;
        float mouseY = (World.VIRTUAL_HEIGHT / Gdx.graphics.getHeight()) * screenY;
        pressedRotation = (float) (Math.atan2(mouseX - World.VIRTUAL_WIDTH / 2, World.VIRTUAL_HEIGHT - mouseY - World.VIRTUAL_HEIGHT / 2) ) ;
        worldRotation = screen.world.globe.getAngleFacing();
        System.out.println(pressedRotation);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if(!Settings.android) return false;
        if (screen.world.state == World.GAMEOVER) return false;
        float mouseX = (World.VIRTUAL_WIDTH / Gdx.graphics.getWidth()) * screenX;
        float mouseY = (World.VIRTUAL_HEIGHT / Gdx.graphics.getHeight()) * screenY;
        float current = (float) (Math.atan2(mouseX - World.VIRTUAL_WIDTH / 2, World.VIRTUAL_HEIGHT - mouseY - World.VIRTUAL_HEIGHT / 2) );
        screen.world.globe.setAngleFacing(worldRotation + (pressedRotation - current)*2);

        this.screenX = screenX;
        this.screenY = screenY;

        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        if(Settings.android) return false;
        if (screen.world.state == World.GAMEOVER) return false;
        float mouseX = (World.VIRTUAL_WIDTH / Gdx.graphics.getWidth()) * screenX;
        float mouseY = (World.VIRTUAL_HEIGHT / Gdx.graphics.getHeight()) * screenY;
        screen.world.globe.setAngleFacing((float) (Math.atan2(mouseX - World.VIRTUAL_WIDTH / 2, World.VIRTUAL_HEIGHT - mouseY - World.VIRTUAL_HEIGHT / 2) * -1));


        this.screenX = screenX;
        this.screenY = screenY;

        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}