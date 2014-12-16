package com.deeep.mblobber.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.deeep.mblobber.screens.AbstractGame;
import com.deeep.mblobber.screens.Core;

public class HtmlLauncher extends GwtApplication {

    @Override
    public GwtApplicationConfiguration getConfig() {
        GwtApplicationConfiguration config = new GwtApplicationConfiguration((int) AbstractGame.VIRTUAL_WIDTH, (int) AbstractGame.VIRTUAL_HEIGHT);
        config.preferFlash = false;
        return config;
    }

    @Override
    public ApplicationListener getApplicationListener() {
        return new Core(null);
    }
}