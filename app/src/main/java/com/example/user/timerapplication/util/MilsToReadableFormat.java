package com.example.user.timerapplication.util;

/**
 * Created by user on 16/04/03.
 */
public class MilsToReadableFormat {
    static public String format(long mils){
        final long h = mils / 1000 / 3600;
        final long m = (mils / 1000 % 3600) / 60;
        final long s = (mils / 1000 % 3600) % 60;
        final long mil = mils % 1000 / 100;

        return String.format("%02d:%02d:%02d.%d",
                h, m, s, mil);
    }
}
