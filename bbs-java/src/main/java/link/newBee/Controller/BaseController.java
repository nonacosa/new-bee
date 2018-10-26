package link.newBee.Controller;

import link.newBee.constant.Constant;
import link.newBee.util.CookieUtil;
import link.newBee.util.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * data 2018-07-07   20:39
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */
@Controller
@RequestMapping(Constant.BASE_URL + "/BaseRest")
public class BaseController {

    @Resource
    HttpServletRequest request;
    @Resource
    HttpServletResponse response;

    public HttpServletRequest getRequest() {
        if(request==null){
        }
        return request;
    }
    public HttpServletResponse getResponse() {
        if(response==null){
        }
        return response;
    }


    public String getToken()  {
        if(getRequest()!=null){
            return CookieUtil.getCookieByKey(getRequest(),TOKEN);
        }
        return null;
    }


    public String getEmail() throws Exception {
        Map<String,String> token =  JsonUtil.tokenToObject(getToken(),Map.class);

        return token.getOrDefault(TOKEN_USER_EMAIL,null);
    }

    public String getUserId() {
        Map<String,String> token =  JsonUtil.tokenToObject(getToken(),Map.class);
        return token.getOrDefault(TOKEN_USER_ID,null);
    }



    public static final String TOKEN ="token";
    public static final String TOKEN_USER_ID ="id";
    public static final String TOKEN_USER_EMAIL ="email";



}
