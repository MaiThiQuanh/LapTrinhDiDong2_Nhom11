package com.sethphat.musicstation;

import android.content.res.Resources;


public class Util {
    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}
