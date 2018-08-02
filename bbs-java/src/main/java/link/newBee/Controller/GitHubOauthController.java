package link.newBee.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

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
        Map<String,String> access_token = rest.getForObject("https://github.com/login/oauth/access_token?client_id=b371e2de74a7b1a56ca4&client_secret=be2bbf103764e6b5a436f6830bf2a8630784fcf3&code="+code,Map.class);
        String tokenKet = access_token.get("access_token");
        Map<String,String> githubUser   = rest.getForObject("https://api.github.com/user?access_token="+tokenKet,Map.class);
        return githubUser;
    }
}
