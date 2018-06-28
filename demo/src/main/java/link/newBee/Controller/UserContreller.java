package link.newBee.Controller;

import link.newBee.Entity.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * data 2018-06-28   02:47
 * E-mail   sis.nonacosa@gmail.com
 * @author sis.nonacosa
 */
@RestController
@RequestMapping("/user")
public class UserContreller {

    @RequestMapping("/register/")
    public User register(Model model){

        User user = new User();
        
        return user;

    }

}
