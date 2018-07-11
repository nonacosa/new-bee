package link.newBee.util;

/**
 * data 2018-06-30   12:43
 * E-mail   sis.nonacosa@gmail.com
 * 1.7线程 安全 | 1.8 线程安全
 * @author sis.nonacosa
 */


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class DateUtil {

    /**
     * 仅仅避免jvm自动提供不必要的无参构造器，节省开销
     */
    private  DateUtil(){
        throw new AssertionError();
    }

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
     * 线程安全的
     */
    private static ThreadLocal<DateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat(DEFAULT_TIME_FORMAT));

    public static Date parse(String dateStr) throws ParseException {
        return threadLocal.get().parse(dateStr);
    }

    public static String format(Date date) {
        return threadLocal.get().format(date);
    }



}