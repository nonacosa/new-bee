package link.newBee.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Message;
import com.google.protobuf.Struct;
import com.google.protobuf.util.JsonFormat;
import org.springframework.http.HttpRequest;
import sun.misc.BASE64Decoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * data 2018-07-05   19:11
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */
public class CookieUtil<T> {

    public static String getCookieByKey(HttpServletRequest request, String key)  {
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if(key.equals(cookie.getName())){
                return cookie.getValue();
            }
        }
        return null;
    }





}
