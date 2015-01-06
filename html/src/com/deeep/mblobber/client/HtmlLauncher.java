package com.deeep.mblobber.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.deeep.mblobber.Core;
import com.deeep.mblobber.client.classes.ActionResolverHtml;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;

public class HtmlLauncher extends GwtApplication {

    @Override
    public void onModuleLoad() {
        super.onModuleLoad();
        com.google.gwt.user.client.Window.addResizeHandler(new ResizeHandler() {
            public void onResize(ResizeEvent ev) {
                Gdx.graphics.setDisplayMode(ev.getWidth() - 100, ev.getHeight() - 100, false);
            }
        });
    }

    @Override
    public GwtApplicationConfiguration getConfig() {
        int height = com.google.gwt.user.client.Window.getClientHeight() - 100;
        int width = com.google.gwt.user.client.Window.getClientWidth() - 100;
        GwtApplicationConfiguration cfg = new GwtApplicationConfiguration(width, height);
        return cfg;
    }

    @Override
    public ApplicationListener getApplicationListener() {
        return new Core(new ActionResolverHtml());
    }
}