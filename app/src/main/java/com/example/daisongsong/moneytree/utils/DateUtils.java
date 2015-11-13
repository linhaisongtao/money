package com.example.daisongsong.moneytree.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by daisongsong on 2015/11/13.
 */
public class DateUtils {

    public static String longToFullString(long t) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return simpleDateFormat.format(new Date(t));
    }
}


