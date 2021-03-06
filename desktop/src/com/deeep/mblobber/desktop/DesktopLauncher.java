package com.deeep.mblobber.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.deeep.mblobber.desktop.classes.ActionResolverDesktop;
import com.deeep.mblobber.AbstractGame;
import com.deeep.mblobber.Core;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = (int) AbstractGame.VIRTUAL_WIDTH;
        config.height = (int) AbstractGame.VIRTUAL_HEIGHT;
        new LwjglApplication(new Core(new ActionResolverDesktop()), config);
    }
}
