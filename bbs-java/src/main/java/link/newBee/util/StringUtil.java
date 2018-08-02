package link.newBee.util;


import java.util.Map;

/**
 * data 2018-08-03   00:31
 * E-mail   sis.nonacosa@gmail.com
 * String util
 * @author sis.nonacosa
 */
public class StringUtil {

    public static String generateUrlString(Map map) {

        StringBuilder url = new StringBuilder("?");

        map.forEach((k,v) -> {
                url.append(k+"="+v+"&");

        });
        String urls = url.toString();
        return  urls.substring(0,urls.length()- 1);
    }



}
