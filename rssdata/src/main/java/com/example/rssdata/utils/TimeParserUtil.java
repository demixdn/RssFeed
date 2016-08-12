package com.example.rssdata.utils;

import android.support.annotation.NonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TimeZone;

/**
 * Created by Aleksandr on 11.08.2016 in RssFeed.
 */
public class TimeParserUtil {

    private static final String CBC_TIME_FORMAT = "EEE, d MMM yyyy HH:mm:ss zzz";

    /**
     * Convert time from rss to millis value.
     * Use format 'EEE, d MMM yyyy HH:mm:ss zzz'
     *
     * @param time value from rss feed
     * @param lang value of channel language
     * @return time in millis
     * @throws ParseException extended from {@link java.text.DateFormat#parse(String)}
     */
    public static long rssTimeFrom(@NonNull String time, @NonNull String lang) throws ParseException {
        Locale locale = new Locale(lang);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CBC_TIME_FORMAT, locale);
        Date date = simpleDateFormat.parse(time);
        return date.getTime();
    }

    /**
     * Convert time from rss to millis value with current timezone.
     * Use format 'EEE, d MMM yyyy HH:mm:ss zzz'
     *
     * @param time value from rss feed
     * @param lang value of channel language
     * @return time in millis
     * @throws ParseException extended from {@link java.text.DateFormat#parse(String)}
     */
    public static long rssTimeWithZoneFrom(@NonNull String time, @NonNull String lang) throws ParseException {

        Locale locale = null;
        if(lang.contains("-")){
            locale = stringToLocale(lang, "-");
        }else if(lang.contains(",")){
            locale = stringToLocale(lang, ",");
        }else {
            locale = new Locale(lang);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CBC_TIME_FORMAT, locale);
        Date date = simpleDateFormat.parse(time);
        Calendar calendar = new GregorianCalendar(TimeZone.getDefault());
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }

    public static Locale stringToLocale(String source, String delim) {
        StringTokenizer tempStringTokenizer = new StringTokenizer(source, delim);
        String lang = null, country = null;
        if(tempStringTokenizer.hasMoreTokens())
            lang = String.valueOf(tempStringTokenizer.nextElement());
        if(tempStringTokenizer.hasMoreTokens())
            country = String.valueOf(tempStringTokenizer.nextElement());
        return new Locale(lang, country);
    }
}
