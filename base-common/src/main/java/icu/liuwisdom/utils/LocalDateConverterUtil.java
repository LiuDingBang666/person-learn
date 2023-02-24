package icu.liuwisdom.utils;

import java.time.*;
import java.util.Date;

/**
 * LocalDateConverterUtil
 *
 * @author LDB
 * @version 1.0
 * @date 2023-02-08 10:36
 */
@SuppressWarnings("all")
public final class LocalDateConverterUtil {

    /**
     * LocalDateToDate
     *
     * @param date date
     * @return java.util.Date
     * @author LDB
     * @date 2023-02-08
     **/
    public static Date LocalDateToDate(LocalDate date) {
        return Date.from(date.atStartOfDay(ZoneOffset.ofHours(8)).toInstant());
    }

    /**
     * LocalDateTimeToDate
     *
     * @param date date
     * @return java.util.Date
     * @author LDB
     * @date 2023-02-08
     **/
    public static Date LocalDateTimeToDate(LocalDateTime date) {
        return Date.from(date.atZone(ZoneOffset.ofHours(8)).toInstant());
    }

    /**
     * LocalDateTimeToDate
     *
     * @param date date
     * @return java.util.Date
     * @author LDB
     * @date 2023-02-08
     **/
    public static Date LocalTimeToDate(LocalTime date) {
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, date);
        Instant instant = localDateTime.atZone(ZoneOffset.ofHours(8)).toInstant();
        return Date.from(instant);
    }

    /**
     * DateToLocalDate
     *
     * @param date date
     * @return java.util.Date
     * @author LDB
     * @date 2023-02-08
     **/
    public static LocalDate DateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneOffset.ofHours(8)).toLocalDate();
    }

    /**
     * LocalDateToStamp
     *
     * @param date date
     * @return long
     * @author LDB
     * @date 2023-02-08
     **/
    public static long LocalDateToStamp(LocalDate date) {
        return date.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
    }

    /**
     * LocalDateTimeToStamp
     *
     * @param date date
     * @return long
     * @author LDB
     * @date 2023-02-08
     **/
    public static Long LocalDateTimeToStamp(LocalDateTime date) {
        return date.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }

    /**
     * stampToLocalDate
     *
     * @param stamp stamp
     * @return java.time.LocalDate
     * @author LDB
     * @date 2023-02-08
     **/
    public static LocalDate stampToLocalDate(long stamp) {
        return Instant.ofEpochMilli(stamp).atZone(ZoneOffset.ofHours(8)).toLocalDate();
    }

    /**
     * stampToLocalDateTime
     *
     * @param stamp stamp
     * @return java.time.LocalDateTime
     * @author LDB
     * @date 2023-02-08
     **/
    public static LocalDateTime stampToLocalDateTime(long stamp) {
        return Instant.ofEpochMilli(stamp).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
    }
}
