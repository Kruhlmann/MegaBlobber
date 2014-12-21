package com.deeep.mblobber.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.deeep.mblobber.World;
import com.deeep.mblobber.input.Assets;

/**
 * Created by E on 12/10/2014.
 */
public class TextEffects {
    float x, y;
    private BitmapFont bitmapFont;
    public static String text;
    private String prevText;
    private float scale = 0;
    private boolean growing = true;
    private float time = 0;
    private float alpha = 1;
    private Color color = Color.WHITE;

    public TextEffects() {
        this.bitmapFont = Assets.getAssets().getBitmapFont();
        text = "";
        prevText = "";
    }

    public void draw(SpriteBatch spriteBatch) {
        if (!prevText.equals(text)) {
            growing = true;
            time = 0;
            prevText = text;
        }
        if (growing) {
            alpha = 1 - time / 1;
            color.a = alpha;
            color.r = 1;
            color.g = 1;
            color.b = 1;
            bitmapFont.setColor(color);
            time += Gdx.graphics.getDeltaTime();
            scale = (float) (8 * Math.pow(2f, time) - 8);
            bitmapFont.scale(scale);
            float x = bitmapFont.getBounds(text).width / 2;
            float y = (bitmapFont.getBounds(text).height) / 2;
            bitmapFont.draw(spriteBatch, text, Gdx.graphics.getWidth()/2 - x, Gdx.graphics.getHeight()/2 + y);
            color.a = 1;
            bitmapFont.setColor(color);
            if (alpha <= 0.1f) {
                growing = false;
                text = "";
                prevText = "";
            }
        }
    }

    class Text {
        String text;

        public Text(String text) {
            this.text = text;
        }
    }
}
