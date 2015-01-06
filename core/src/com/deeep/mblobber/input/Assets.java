package com.deeep.mblobber.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created with IntelliJ IDEA.
 * User: Elmar
 * Date: 9/29/13
 * Time: 10:17 AM
 */
public class Assets {
    /**
     * instance for singleton
     */
    private static Assets assets;

    public AssetManager assetManager;
    /**
     * Just a check to be sure that the assets aren't loaded multiple times
     */
    public static boolean loaded = false;
    /**
     * The atlases containing all the images
     */
    private TextureAtlas textureAtlas;
    /**
     * Logger instance
     */
//    private Logger logger = Logger.getInstance();
    /**
     * The texture region for the shape renderer
     */
    private Sprite blankSprite;
    /**
     * Standard font
     */
    private BitmapFont font;
    private BitmapFont.BitmapFontData bitmapFontData;
    private Pixmap pixmap;

    private Music music;

    public Sound pointsGained;
    public Sound incorrect;
    public Sound power, pling;
    public Sound menu, ice;
    public Sound start1, game_over1, new_highscore1, quit1, easy1, keep_it_up1, well_done1, nice_going1, wow1, amazing1, incredible1, oh_my_god1, multiplier_loss1, angel_power1, protection1, points1, hasta1, healpower1, blow1, speed_slow1, speed_fast1;
    public Sound start2, game_over2, new_highscore2, quit2, easy2, keep_it_up2, well_done2, nice_going2, wow2, amazing2, incredible2, oh_my_god2, multiplier_loss2, angel_power2, protection2, points2, hasta2, healpower2, blow2, speed_slow2, speed_fast2;
    public Sound start3, game_over3, new_highscore3, quit3, easy3, keep_it_up3, well_done3, nice_going3, wow3, amazing3, incredible3, oh_my_god3, multiplier_loss3, angel_power3, protection3, points3, hasta3, healpower3, blow3, speed_slow3, speed_fast3;


    /**
     * Find a use for this, if there is any TODO
     */
    public Assets() {
        assetManager = new AssetManager();
        loaded = false;
    }

    /**
     * Simple singleton
     *
     * @return assets instance
     */
    public static Assets getAssets() {
        if (assets == null) {
            assets = new Assets();
        }
        return assets;
    }

    public TextureAtlas getTextureAtlas() {
        return textureAtlas;
    }


    /**
     * function to load everything. Nothing special. TODO add more resources here( sound music etc)
     */
    public void load() {
        assetManager.load("data/loading.pack", TextureAtlas.class);
        assetManager.finishLoading();

        pixmap = new Pixmap(64, 64, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fillRectangle(0, 0, 64, 64);
        blankSprite = new Sprite(new Texture(pixmap));

        font = loadBitmapFont();

        assetManager.load("TextureAtlas.txt", TextureAtlas.class);
        assetManager.load("sound/blub.mp3", Sound.class);
        assetManager.load("sound/knack.mp3", Sound.class);
        assetManager.load("sound/blob.mp3", Sound.class);
        assetManager.load("sound/menu.wav", Sound.class);
        assetManager.load("music.mp3", Music.class);
        assetManager.load("sound/pling.mp3", Sound.class);
        assetManager.load("sound/ice.mp3", Sound.class);
        assetManager.load("sound/letsgo1.mp3", Sound.class);
        assetManager.load("sound/uhoh1.mp3", Sound.class);
        assetManager.load("sound/stunning1.mp3", Sound.class);
        assetManager.load("sound/bye1.mp3", Sound.class);
        assetManager.load("sound/easy1.mp3", Sound.class);
        assetManager.load("sound/keepitup1.mp3", Sound.class);
        assetManager.load("sound/welldone1.mp3", Sound.class);
        assetManager.load("sound/nicegoing1.mp3", Sound.class);
        assetManager.load("sound/wow1.mp3", Sound.class);
        assetManager.load("sound/amazing1.mp3", Sound.class);
        assetManager.load("sound/incredible1.mp3", Sound.class);
        assetManager.load("sound/ohmygod1.mp3", Sound.class);
        assetManager.load("sound/multiplier1.mp3", Sound.class);
        assetManager.load("sound/letthemcome1.mp3", Sound.class);
        assetManager.load("sound/protection1.mp3", Sound.class);
        assetManager.load("sound/morepoints1.mp3", Sound.class);
        assetManager.load("sound/hastalavista1.mp3", Sound.class);
        assetManager.load("sound/heal1.mp3", Sound.class);
        assetManager.load("sound/blow1.mp3", Sound.class);
        assetManager.load("sound/notsoquickly1.mp3", Sound.class);
        assetManager.load("sound/speedup1.mp3", Sound.class);
        assetManager.load("sound/letsgo2.mp3", Sound.class);
        assetManager.load("sound/uhoh2.mp3", Sound.class);
        assetManager.load("sound/stunning2.mp3", Sound.class);
        assetManager.load("sound/bye2.mp3", Sound.class);
        assetManager.load("sound/easy2.mp3", Sound.class);
        assetManager.load("sound/keepitup2.mp3", Sound.class);
        assetManager.load("sound/welldone2.mp3", Sound.class);
        assetManager.load("sound/nicegoing2.mp3", Sound.class);
        assetManager.load("sound/wow2.mp3", Sound.class);
        assetManager.load("sound/amazing2.mp3", Sound.class);
        assetManager.load("sound/incredible2.mp3", Sound.class);
        assetManager.load("sound/ohmygod2.mp3", Sound.class);
        assetManager.load("sound/multiplier2.mp3", Sound.class);
        assetManager.load("sound/letthemcome2.mp3", Sound.class);
        assetManager.load("sound/protection2.mp3", Sound.class);
        assetManager.load("sound/morepoints2.mp3", Sound.class);
        assetManager.load("sound/hastalavista2.mp3", Sound.class);
        assetManager.load("sound/heal2.mp3", Sound.class);
        assetManager.load("sound/blow2.mp3", Sound.class);
        assetManager.load("sound/notsoquickly2.mp3", Sound.class);
        assetManager.load("sound/speedup2.mp3", Sound.class);
        assetManager.load("sound/letsgo3.mp3", Sound.class);
        assetManager.load("sound/uhoh3.mp3", Sound.class);
        assetManager.load("sound/stunning3.mp3", Sound.class);
        assetManager.load("sound/bye3.mp3", Sound.class);
        assetManager.load("sound/easy3.mp3", Sound.class);
        assetManager.load("sound/keepitup3.mp3", Sound.class);
        assetManager.load("sound/welldone3.mp3", Sound.class);
        assetManager.load("sound/nicegoing3.mp3", Sound.class);
        assetManager.load("sound/wow3.mp3", Sound.class);
        assetManager.load("sound/amazing3.mp3", Sound.class);
        assetManager.load("sound/incredible3.mp3", Sound.class);
        assetManager.load("sound/ohmygod3.mp3", Sound.class);
        assetManager.load("sound/multiplier3.mp3", Sound.class);
        assetManager.load("sound/letthemcome3.mp3", Sound.class);
        assetManager.load("sound/protection3.mp3", Sound.class);
        assetManager.load("sound/morepoints3.mp3", Sound.class);
        assetManager.load("sound/hastalavista3.mp3", Sound.class);
        assetManager.load("sound/heal3.mp3", Sound.class);
        assetManager.load("sound/blow3.mp3", Sound.class);
        assetManager.load("sound/notsoquickly3.mp3", Sound.class);
        assetManager.load("sound/speedup3.mp3", Sound.class);

        //            logger.system(Assets.class, "All assets have been loaded");
        loadSounds();
    }

    private void loadSounds() {
        //༼༼༼༼༼ຈຈຈຈຈل͜ل͜ل͜ل͜ل͜ຈຈຈຈຈ༽༽༽༽༽ﾉﾉﾉﾉﾉ
    }

    public void set() {
        bitmapFontData = new BitmapFont.BitmapFontData(Gdx.files.internal("font/font.fnt"), false);
        textureAtlas = assetManager.get("TextureAtlas.txt");

        pointsGained = assetManager.get("sound/blub.mp3");
        incorrect = assetManager.get("sound/knack.mp3");
        power = assetManager.get("sound/blob.mp3");
        menu = assetManager.get("sound/menu.wav");
        pling = assetManager.get("sound/pling.mp3");
        ice = assetManager.get("sound/ice.mp3");
//        music.loop(0.35f);
        /**
         * Ruwin files
         * start, game_over, new_highscore, quit, easy, keep_it_up, well_done, nice_going, wow, amazing, incredible, oh_my_god, multiplier_loss, angel_power, protection, points, hasta, healpower, blow, speed_slow, speed_fast;
         */
        start1 = assetManager.get("sound/letsgo1.mp3");
        game_over1 = assetManager.get("sound/uhoh1.mp3");
        new_highscore1 = assetManager.get("sound/stunning1.mp3");
        quit1 = assetManager.get("sound/bye1.mp3");
        easy1 = assetManager.get("sound/easy1.mp3");
        keep_it_up1 = assetManager.get("sound/keepitup1.mp3");
        well_done1 = assetManager.get("sound/welldone1.mp3");
        nice_going1 = assetManager.get("sound/nicegoing1.mp3");
        wow1 = assetManager.get("sound/wow1.mp3");
        amazing1 = assetManager.get("sound/amazing1.mp3");
        incredible1 = assetManager.get("sound/incredible1.mp3");
        oh_my_god1 = assetManager.get("sound/ohmygod1.mp3");
        multiplier_loss1 = assetManager.get("sound/multiplier1.mp3");
        angel_power1 = assetManager.get("sound/letthemcome1.mp3");
        protection1 = assetManager.get("sound/protection1.mp3");
        points1 = assetManager.get("sound/morepoints1.mp3");
        hasta1 = assetManager.get("sound/hastalavista1.mp3");
        healpower1 = assetManager.get("sound/heal1.mp3");
        blow1 = assetManager.get("sound/blow1.mp3");
        speed_slow1 = assetManager.get("sound/notsoquickly1.mp3");
        speed_fast1 = assetManager.get("sound/speedup1.mp3");
        start2 = assetManager.get("sound/letsgo2.mp3");
        game_over2 = assetManager.get("sound/uhoh2.mp3");
        new_highscore2 = assetManager.get("sound/stunning2.mp3");
        quit2 = assetManager.get("sound/bye2.mp3");
        easy2 = assetManager.get("sound/easy2.mp3");
        keep_it_up2 = assetManager.get("sound/keepitup2.mp3");
        well_done2 = assetManager.get("sound/welldone2.mp3");
        nice_going2 = assetManager.get("sound/nicegoing2.mp3");
        wow2 = assetManager.get("sound/wow2.mp3");
        amazing2 = assetManager.get("sound/amazing2.mp3");
        incredible2 = assetManager.get("sound/incredible2.mp3");
        oh_my_god2 = assetManager.get("sound/ohmygod2.mp3");
        multiplier_loss2 = assetManager.get("sound/multiplier2.mp3");
        angel_power2 = assetManager.get("sound/letthemcome2.mp3");
        protection2 = assetManager.get("sound/protection2.mp3");
        points2 = assetManager.get("sound/morepoints2.mp3");
        hasta2 = assetManager.get("sound/hastalavista2.mp3");
        healpower2 = assetManager.get("sound/heal2.mp3");
        blow2 = assetManager.get("sound/blow2.mp3");
        speed_slow2 = assetManager.get("sound/notsoquickly2.mp3");
        speed_fast2 = assetManager.get("sound/speedup2.mp3");
        start3 = assetManager.get("sound/letsgo3.mp3");
        game_over3 = assetManager.get("sound/uhoh3.mp3");
        new_highscore3 = assetManager.get("sound/stunning3.mp3");
        quit3 = assetManager.get("sound/bye3.mp3");
        easy3 = assetManager.get("sound/easy3.mp3");
        keep_it_up3 = assetManager.get("sound/keepitup3.mp3");
        well_done3 = assetManager.get("sound/welldone3.mp3");
        nice_going3 = assetManager.get("sound/nicegoing3.mp3");
        wow3 = assetManager.get("sound/wow3.mp3");
        amazing3 = assetManager.get("sound/amazing3.mp3");
        incredible3 = assetManager.get("sound/incredible3.mp3");
        oh_my_god3 = assetManager.get("sound/ohmygod3.mp3");
        multiplier_loss3 = assetManager.get("sound/multiplier3.mp3");
        angel_power3 = assetManager.get("sound/letthemcome3.mp3");
        protection3 = assetManager.get("sound/protection3.mp3");
        points3 = assetManager.get("sound/morepoints3.mp3");
        hasta3 = assetManager.get("sound/hastalavista3.mp3");
        healpower3 = assetManager.get("sound/heal3.mp3");
        blow3 = assetManager.get("sound/blow3.mp3");
        speed_slow3 = assetManager.get("sound/notsoquickly3.mp3");
        speed_fast3 = assetManager.get("sound/speedup3.mp3");

        music = assetManager.get("music.mp3");
        music.play();
        music.setLooping(true);
    }

    public Sprite getBlankSprite() {
        return blankSprite;
    }

    /**
     * Dispose function. should ALWAYS be called. This will get rid of the texture atlas
     */
    public void dispose() {
        assets = null;

        if (pixmap != null)
            pixmap.dispose();

        assetManager.dispose();
    }

    /**
     * Returns an texture region based on the name given. Get images using this function!
     *
     * @param name see TextureAtlas.txt
     * @return the texture region connected to the name
     */
    public TextureRegion getRegion(String name) {

        TextureRegion textureRegion = textureAtlas.findRegion(name);
        if (textureRegion == null) {
//            logger.error(Assets.class, "Unkown texture requested: " + name);
        }
        return textureAtlas.findRegion(name);
    }

    /**
     * Loads the bitmap font as BitmapFont object
     *
     * @return null or the font
     */
    public BitmapFont loadBitmapFont() {
        Texture texture = new Texture(Gdx.files.internal("font/font.png"));

        BitmapFont font = new BitmapFont(Gdx.files.internal("font/font.fnt"), new TextureRegion(texture), false);
        if (font != null) return font;
//        Logger.getInstance().error(this.getClass(), "Couldn't find specified font!");
        return null;
    }

    /**
     * Returns the bitmap font as BitmapFont object
     *
     * @return null or the font
     */
    public BitmapFont getBitmapFont() {
        return font;
    }

    public BitmapFont.BitmapFontData getBitmapFontData() {
        return bitmapFontData;
    }
}
