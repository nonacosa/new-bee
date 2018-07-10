package link.newBee.util;

/**
 * data 2018-06-30   12:43
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class DateUtil {

    public static final String DEFAULT_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public final static String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 线程安全的获取默认本地时间
     * @return
     */
    public static String getDefaultDateStr() {
        return getLocaleDate(DEFAULT_TIME_FORMAT);
    }


    public static String getLocaleDate(String format) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatRole = DateTimeFormatter.ofPattern(format);
        return  now.format(formatRole);
    }


    /**
     * 非1.8中线程安全的
     */
    private static ThreadLocal<DateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat(DEFAULT_TIME_FORMAT));

    public static Date parse(String dateStr) throws ParseException {
        return threadLocal.get().parse(dateStr);
    }

    public static String format(Date date) {
        return threadLocal.get().format(date);
    }



}