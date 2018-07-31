package com.imdnd.common.thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Thread local for simple date format
 *
 * @author Adam DENG
 */
public class ThreadLocalDateFormat {

    private static final ThreadLocal<SimpleDateFormat> formatter =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static String dateToString(Date date) {
        return formatter.get().format(date);
    }

    public static Date stringToDate(String date) throws ParseException {
        return formatter.get().parse(date);
    }
}
