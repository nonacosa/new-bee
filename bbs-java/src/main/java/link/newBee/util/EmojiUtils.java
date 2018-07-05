package link.newBee.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * data 2018-07-06   01:05
 * E-mail   sis.nonacosa@gmail.com
 * Emoji 帮助类 转换为了存贮在 utf-8 中
 * @author sis.nonacosa
 */
public class EmojiUtils {

    private static final Logger LOG = LoggerFactory.getLogger(EmojiUtils.class);

    /**
     * 编码格式
     */
    private static final String ENCODING = "UTF-8";

    private EmojiUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 将字符串中的emoji表情转换成可以在utf-8字符集数据库中保存的格式（表情占4个字节，需要utf8mb4字符集）
     *
     * @param str 待转换字符串
     * @return 转换后字符串
     */
    public static String emojiConvert(String str) {

        if (StringUtils.isEmpty(str)) {
            return "";
        }

        String patternString = "([\\x{10000}-\\x{10ffff}\ud800-\udfff])";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            try {
                matcher.appendReplacement(sb, "[[" + URLEncoder.encode(matcher.group(1), ENCODING) + "]]");
            } catch (UnsupportedEncodingException e) {
                LOG.error("emoji convert fail", e);
                return str;
            }
        }
        matcher.appendTail(sb);

        return sb.toString();
    }

    /**
     * 还原utf8数据库中保存的含转换后emoji表情的字符串
     *
     * @param str 转换后的字符串
     * @return 转换前的字符串
     */
    public static String emojiRecovery(String str) {

        String patternString = "\\[\\[(.*?)\\]\\]";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str);

        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            try {
                matcher.appendReplacement(sb, URLDecoder.decode(matcher.group(1), ENCODING));
            } catch (UnsupportedEncodingException e) {
                LOG.error("emoji recovery fail", e);
                return str;
            }
        }
        matcher.appendTail(sb);

        return sb.toString();
    }

}
