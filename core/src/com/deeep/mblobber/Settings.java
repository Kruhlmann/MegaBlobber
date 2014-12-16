package com.deeep.mblobber;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

/**
 * Created by scanevaro on 07/12/2014.
 */
public class Settings {
    public static boolean soundEnabled = true;
    //    public final static int[] highscores = new int[]{100, 80, 50, 30, 10};
    public final static String file = ".ludumDare";

    public static void load() {
        try {
            FileHandle filehandle = Gdx.files.external(file);

            String[] strings = filehandle.readString().split("\n");

            soundEnabled = Boolean.parseBoolean(strings[0]);
//            String[] strings = filehandle.readString().split("\n");
//            for (int i = 0; i < 5; i++) {
//                highscores[i] = Integer.parseInt(strings[i]);
//            }
        } catch (Throwable e) {
            // :( It's ok we have defaults
        }
    }

    //
    public static void save() {
        try {
            FileHandle filehandle = Gdx.files.external(file);

            filehandle.writeString(Boolean.toString(soundEnabled) + "\n", false);
//            filehandle.writeString(Integer.toString(highscores[0]) + "\n", false);
//            for (int i = 1; i < 5; i++) {
//                filehandle.writeString(Integer.toString(highscores[i]) + "\n", true);
//            }
        } catch (Throwable e) {
        }
    }
//
//    public static void addScore(int score) {
//        for (int i = 0; i < 5; i++) {
//            if (highscores[i] < score) {
//                for (int j = 4; j > i; j--)
//                    highscores[j] = highscores[j - 1];
//                highscores[i] = score;
//                break;
//            }
//        }
//    }
}