package cz.barasuchanova.util;

import lombok.extern.java.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;


@Log
public class Utils {

    public static void log(String message) {
        log.info(message);
    }

    public static void log(String message, Exception e) {
        log.info(message);
        if (e != null) log.log(Level.WARNING, e.getMessage(), e);
    }

    public static String formatISO8601GMT(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.000Z'");
        return df.format(date);
    }

    public static Date parseISO8601(String date) {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ISO_DATE_TIME;
        TemporalAccessor accessor = timeFormatter.parse(date);
        return Date.from(Instant.from(accessor));
    }

    public static String formatISO8601GMTTimestamp(Date date) {
        DateFormat df = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
        return df.format(date);
    }

    public static String formatISO8601Short(Date date) {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.format(date);
    }

    public static Date addToDate(Date date, int type, int amount) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(type, amount);
        return calendar.getTime();
    }

}