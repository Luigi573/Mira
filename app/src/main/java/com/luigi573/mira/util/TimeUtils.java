package com.luigi573.mira.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeUtils {
    public static String timeStamp2String(long seconds, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.CHINA);
        return simpleDateFormat.format(new Date(seconds));
    }
}
