package com.example.user.timerapplication.util;

import java.util.Locale;

/**
 *
 */
public class MilsToReadableFormat {

    /**
     * converts millisecond value to human readable format like
     * hh:mm:ss.mil
     * @param milliseconds to be converted
     * @return string representation of given millisecond
     */
    static public String format(long milliseconds){
        final long h = milliseconds / 1000 / 3600;
        final long m = (milliseconds / 1000 % 3600) / 60;
        final long s = (milliseconds / 1000 % 3600) % 60;
        final long mil = milliseconds % 1000 / 100;

        return String.format(Locale.ENGLISH,
                "%02d:%02d:%02d.%d", h, m, s, mil);
    }
}

