package link.newBee.Controller;

import link.newBee.constant.Constant;
import link.newBee.util.MapUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static link.newBee.util.StringUtil.generateUrlString;

/**
 * data 2018-08-02   18:50
 * E-mail   sis.nonacosa@gmail.com
 * github oauth 2.0
 * @author sis.nonacosa
 */
@RestController
@RequestMapping("/github")
public class GitHubOauthController {


    @RequestMapping(value = "/getUser/{code}", method = RequestMethod.GET)
    public Map getUser(@PathVariable String code)   {
        RestTemplate rest               = new RestTemplate();
        String tokenUrl = Constant.GITHUB_ACCESS_TOKEN_URL + generateUrlString((new MapUtils<String,String>().put("client_secret",Constant.GITHUB_client_secret).put("client_id",Constant.GITHUB_client_ID).put("code",code).map()) );
        Map<String,String> access_token = rest.getForObject(tokenUrl,Map.class);
        String tokenKet = access_token.get("access_token");
        String userUrl = Constant.GITHUB_USER_API_URL + generateUrlString(new MapUtils<String,String>().put("access_token",tokenKet).map());
        Map<String,String> githubUser   = rest.getForObject(userUrl,Map.class);
        return githubUser;
    }
}
