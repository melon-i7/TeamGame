package com.example.melon_i7.teamgame.utilis;

import android.content.SharedPreferences;


import com.example.melon_i7.teamgame.app.App;

import static android.content.Context.MODE_PRIVATE;

/**
 *
 */

public class SPUtils {
    private static SharedPreferences sp;

    public static void writeBoolean(String key, boolean value) {
        sp = App.app.getSharedPreferences("Settings", MODE_PRIVATE);
        sp.edit().putBoolean(key, value).commit();
    }

    public static boolean readBoolean(String key) {
        sp = App.app.getSharedPreferences("Settings", MODE_PRIVATE);
        return sp.getBoolean(key, true);
    }

}
