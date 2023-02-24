package icu.liuwisdom.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日期时间相关工具
 *
 * @author Louis
 * @date Jan 14, 2019
 */
public class DateUtils {

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static final String HH_MM_SS = "HH:mm:ss";

    /**
     * 获取当前标准格式化日期时间
     *
     * @param
     * @return
     */
    public static String getDateTime() {
        return getDateTime(new Date());
    }

    /**
     * 标准格式化日期时间
     *
     * @param date
     * @return
     */
    public static String getDateTime(Date date) {
        return (new SimpleDateFormat(DATE_FORMAT)).format(date);
    }

    /**
     * 获取当前格式化日期时间
     *
     * @param date
     * @param format
     * @return java.lang.String
     * @author LDB
     * @date 2022-11-20
     **/
    public static String getDateByFormat(Date date, String format) {
        return (new SimpleDateFormat(format)).format(date);
    }


    /**
     * 日期转字符串
     *
     * @param dateTime
     * @param formatter
     * @return java.lang.String
     * @author LDB
     * @date 2022-08-21
     **/
    public static String dateToStr(LocalDateTime dateTime, String formatter) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern(formatter);
        return dateTime.format(pattern);
    }

    /**
     * 获取现在时间
     *
     * @return java.lang.String
     * @author LDB
     * @date 2022-08-21
     **/
    public static String nowDate() {
        return dateToStr(LocalDateTime.now(), DateUtils.DATE_FORMAT);
    }

    /**
     * 字符串转日期
     *
     * @param dateTime
     * @param formatter
     * @return java.time.LocalDateTime
     * @author LDB
     * @date 2022-08-21
     **/
    public static LocalDateTime strToDate(String dateTime, String formatter) {
        return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(formatter));
    }

    /**
     * LocalDateTimeToStr
     * @author LDB
     * @date 2023-02-19
     * @param localDateTime
     * @return java.lang.String
     **/
    public static String LocalDateTimeToStr(LocalDateTime localDateTime) {
        String s = localDateTime.toString();
        s = s.replace("T", " ");
        s = s.substring(0, s.indexOf("."));
        return s;
    }

    /**
     * LocalTimeToStr
     * @author LDB
     * @date 2023-02-19
     * @param localTime
     * @return java.lang.String
     **/
    public static String LocalTimeToStr(LocalTime localTime) {
        String s = localTime.toString();
        s = s.substring(0, s.indexOf("."));
        return s;
    }

    public static void main(String[] args) {

    }


}
