package link.newBee.util;

/**
 * data 2018-06-30   12:43
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */

import com.google.common.base.Objects;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class DateUtil {

    public static final String DEFAULT_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public final static String MONTH_FORMAT = "yyyy-MM";
    public final static String YEAR_FORMAT = "yyyy";
    public final static String DATE_FORMAT = "yyyy-MM-dd";
    public final static String DATETIME_Hour_FORMAT = "yyyy-MM-dd HH:mm";
    public final static String DATE_YUNMA_FORMAT = "yyyyMMddHHmm";
    public final static String HOUR_FORMAT = "HH:mm:ss";

    //	使用系统时区及系统时间
    public static String getDefaultDateStr() {
        return convertDateToStringLocale(new Date(System.currentTimeMillis()), DEFAULT_TIME_FORMAT);
    }

    public static String getDefaultDateStr(String format) {
        return convertDateToStringLocale(new Date(System.currentTimeMillis()), format);
    }

    /**
     * 获取本地自定义格式时间
     *
     * @param format 自定义格式,如"yyyy-MM-dd HH:mm:ss"等
     * @return 本地自定义格式时间
     */
    public static String getLocalDefineDate(String format) {
        return convertDateToString(new Date(), format);
    }

    public static String getLocaleDate(String format) {
        return convertDateToStringLocale(new Date(), format);
    }

    public static String convertDateToStringLocale(Date date, String format) {
        String dateString = "";
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        dateString = formatter.format(date);
        return dateString;
    }


    public static String convertDateToString(Date date, String format) {
        String dateString = "";
        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.CHINA);
        dateString = formatter.format(date);
        return dateString;
    }

    /**
     * @param dateString
     * @param format
     * @return converted date or <b>null</b> if cannot convert
     * @throws ParseException
     */
    public static Date convertStringToDateLocale(String dateString, String format) throws ParseException {
        Date date;
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        date = formatter.parse(dateString);
        return date;
    }

    /**
     * @param dateString
     * @param format
     * @return converted date or <b>null</b> if cannot convert
     * @throws ParseException
     */
    public static Date convertStringToDate(String dateString, String format) throws ParseException {
        Date date;
        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.CHINA);
        date = formatter.parse(dateString);
        return date;
    }

    /**
     * @param date 待转化的日期,格式为：yyyy-MM-dd HH:mm:ss
     * @return 字符串式的日期, 格式为：yyyy-MM-dd HH:mm:ss
     */
    public static String getDateTimeToStr(Date date) {
        return convertDateToString(date, DEFAULT_TIME_FORMAT);
    }

    /**
     * 2015年1月6日
     * 处理Timestamp 格式Timestamp 格式
     * zhiyuan.guo 改
     *
     * @param t
     * @return
     */
    public static String convertTimeSampToString(java.sql.Timestamp t) {
        String str = "";
        if (t != null) {
            try {
                //str=t.toString();
                str = convertDateToString(t, "yyyy-MM-dd HH:mm:ss");
            } catch (Exception x) {
                str = "";
            }
        }
        return str;

    }

    public static String spellDateSql(String bdate, String edate, String fieldName) {
        String resql = "";

        return resql;
    }

    /**
     * 验证日期时间格式 xxxx-xx-xx xx:xx:xx 或xxxxxxxxxxxxxx
     *
     * @param dateTimeStr
     * @return
     */
    public static boolean vaildateDateTimeIs(String dateTimeStr) {
        String ruler = "\\d{4}(?:\\-)?([0]{1}\\d{1}|[1]{1}[0-2]{1})(?:\\-)?([0-2]{1}\\d{1}|[3]{1}[0-1]{1})(?:\\s)?([0-1]{1}\\d{1}|[2]{1}[0-3]{1})(?::)?([0-5]{1}\\d{1})(?::)?([0-5]{1}\\d{1})";
        Pattern p = Pattern.compile(ruler);
        return p.matcher(dateTimeStr).matches();
    }

    public static boolean vaildateDateIs(String dateStr) {
        String ruler = "^[0-9]{4}-(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))|(02-(0[1-9]|[1-2][0-9]))|((0[469]|11)-(0[1-9]|[1-2][0-9]|30)))$";
        Pattern p = Pattern.compile(ruler);
        return p.matcher(dateStr).matches();
    }

    /**
     * 验证24小时时间格式 xx:xx:xx
     *
     * @param dateTimeStr
     * @return
     */
    public static boolean vaildateTimeIs(String dateTimeStr) {
        String ruler = "^((20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d)$";
        Pattern p = Pattern.compile(ruler);
        return p.matcher(dateTimeStr).matches();
    }

    public static List<String> allDateBetween2Date(String startDate, String endDate) {
        if (StringUtils.isEmpty(startDate)) {
            return null;
        }

        if (StringUtils.isEmpty(endDate)) {
            return null;
        }
        List<String> dayList = new ArrayList<String>();
        Calendar cal = Calendar.getInstance();
        String[] sDate = startDate.split("-");
        int vyear = Integer.parseInt(sDate[0]);
        int vmonth = Integer.parseInt(sDate[1]) - 1;
        int vday = Integer.parseInt(sDate[2]) - 1;
        int i = 1;
        String newDate = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        while (!Objects.equal(newDate,endDate)) {
            cal.set(vyear, vmonth, vday + i);
            newDate = sdf.format(cal.getTime());
            i++;
            dayList.add(newDate);
        }
        return dayList;
    }

    /**
     * 月份加减
     *
     * @param strdate 当前日期
     * @param ageNum  加/减去的月数(正负整数)
     * @return
     */
    public static String subMonth(String strdate, int ageNum) {
        Date date = new Date(); // 构造一个日期型中间变量
        String dateresult = null; // 返回的日期字符串
        // 创建格式化格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        // 加减日期所用
        GregorianCalendar gc = new GregorianCalendar();
        try {
            date = df.parse(strdate); // 将字符串格式化为日期型
        } catch (ParseException e) {
            e.printStackTrace();
        }
        gc.setTime(date); // 得到gc格式的时间
        gc.add(2, ageNum); // 2表示月的加减，年代表1依次类推(周,天。。)
        // 把运算完的时间从新赋进对象
        gc.set(gc.get(gc.YEAR), gc.get(gc.MONTH), gc.get(gc.DATE));
        // 在格式化回字符串时间
        dateresult = df.format(gc.getTime());
        return dateresult;
    }

    /**
     * 日期加减
     *
     * @param strdate 当前日期
     * @param ageNum  加/减去的天数(正负整数)
     * @return
     */
    public static String subDay(String strdate, int ageNum) {
        Date date = new Date(); // 构造一个日期型中间变量
        String dateresult = null; // 返回的日期字符串
        // 创建格式化格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        // 加减日期所用
        GregorianCalendar gc = new GregorianCalendar();
        try {
            date = df.parse(strdate); // 将字符串格式化为日期型
        } catch (ParseException e) {
            e.printStackTrace();
        }
        gc.setTime(date); // 得到gc格式的时间
        gc.add(5, ageNum); // 2表示月的加减，年代表1依次类推(周,天。。)
        // 把运算完的时间从新赋进对象
        gc.set(gc.get(gc.YEAR), gc.get(gc.MONTH), gc.get(gc.DATE));
        // 在格式化回字符串时间
        dateresult = df.format(gc.getTime());
        return dateresult;
    }

    /**
     * 日期相减，得天数
     *
     * @param d1     大数
     * @param d2     小数
     * @param format 格式
     * @return
     */
    public static long getCalculateDayOfDay(String d1, String d2, String format) {
        long day = 0;
        if (vaildateDateIs(d1) && vaildateDateIs(d2)) {
            try {
                Date date1 = new SimpleDateFormat(format).parse(d1);
                Date date2 = new SimpleDateFormat(format).parse(d2);
                long ltime = date1.getTime() - date2.getTime() > 0 ? date1.getTime() - date2.getTime() : 0;
                day = ltime / (24 * 60 * 60 * 1000);
            } catch (Exception x) {
                x.printStackTrace();
                System.out.println(x.getMessage());
            }
        }
        return day;
    }

    /**
     * 日期相减，得到秒数
     *
     * @param d1     大数
     * @param d2     小数
     * @param format 格式
     * @return
     */
    public static long getCalculateDayOfmm(String d1, String d2, String format) {
        long mm = 0;
        if (vaildateDateTimeIs(d1) && vaildateDateTimeIs(d2)) {
            try {
                Date date1 = new SimpleDateFormat(format).parse(d1);
                Date date2 = new SimpleDateFormat(format).parse(d2);
                mm = date1.getTime() - date2.getTime() > 0 ? date1.getTime() - date2.getTime() : 0;

            } catch (Exception x) {
                x.printStackTrace();
                System.out.println(x.getMessage());
            }
        }
        return mm / 1000;
    }

    public static long getCalculateDayOfDay(String d1, String d2) {
        return getCalculateDayOfDay(d1, d2, "yyyy-MM-dd");
    }

    /**
     * 格式化yyyy-MM-dd HH:mm:ss 的日期格式为 yyyyMMddHHmmss 格式
     *
     * @param dateStr
     * @return
     */
    public static String getFormatDateStrToNumerStr(String dateStr) {
        if (dateStr != null && dateStr.length() > 0) {
            dateStr = dateStr.replaceAll("[-\\s:]", "");
            if (dateStr.indexOf(".") >= 0) {
                dateStr = dateStr.substring(0, dateStr.indexOf("."));
            }
        } else {
            dateStr = "00000000000000";
        }
        return dateStr;
    }


}