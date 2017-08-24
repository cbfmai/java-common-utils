package com.imdnd.common.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Format date with java8 DateTimeFormatter
 */
public class DateTimeUtils {

    private static final String DEFAULT_FORMATTER = "yyyy-MM-dd HH:mm:ss";

    private static Date format(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_FORMATTER);
        LocalDateTime localDateTime = LocalDateTime.parse(dateStr, formatter);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    private static LocalDateTime format(String dateStr, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(dateStr, formatter);
    }

    private static String format(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_FORMATTER);
        return localDateTime.format(formatter);
    }


    public static void main(String[] args) {
        System.out.println(DateTimeUtils.format("2017-08-22 11:22:12"));
        System.out.println(DateTimeUtils.format("2017-08-22 11:22:12", DEFAULT_FORMATTER));
        System.out.println(DateTimeUtils.format(LocalDateTime.now()));

    }

}
