package com.tochycomputerservices.orangeplayer.vx.Utils;

import android.content.Context;
import android.graphics.Typeface;

import java.util.Hashtable;

//Caches the custom fonts in memory to improve rendering performance.
public class TypefaceHelper {

    public static final String FUTURA_BOLD = "asap_semibold";
    public static final String FUTURA_CONDENSED = "asap_bold";
    public static final String TYPEFACE_FOLDER = "fonts";
    public static final String TYPEFACE_EXTENSION = ".ttf";
    public static final String FUTURA_BOOK = "asap_medium";

    private static Hashtable<String, Typeface> sTypeFaces = new Hashtable<String, Typeface>(4);

    public static Typeface getTypeface(Context context, String fileName) {
        Typeface tempTypeface = sTypeFaces.get(fileName);

        if (tempTypeface == null) {
            String fontPath = new StringBuilder(TYPEFACE_FOLDER).append('/')
                    .append(fileName)
                    .append(TYPEFACE_EXTENSION)
                    .toString();

            tempTypeface = Typeface.createFromAsset(context.getAssets(), fontPath);
            sTypeFaces.put(fileName, tempTypeface);
        }

        return tempTypeface;
    }

}
