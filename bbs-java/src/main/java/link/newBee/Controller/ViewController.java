package link.newBee.Controller;

import link.newBee.constant.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * data 2017-11-02   09:40
 * E-mail   sis.nonacosa@gmail.com
 * @author sis.nonacosa
 */


@RestController
@RequestMapping(Constant.BASE_URL + "/")
public class ViewController {

    @RequestMapping("/")
    public ModelAndView index(Model model){
        return new ModelAndView("index");

    }

    @RequestMapping("/login/")
    public ModelAndView login(Model model){
        return new ModelAndView("login");

    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public ModelAndView book(Model model,@PathVariable String id){
        return new ModelAndView("book");

    }

    @RequestMapping(value = "/blog/{id}", method = RequestMethod.GET)
    public ModelAndView blog(Model model,@PathVariable String id){
        return new ModelAndView("blog");

    }

    @RequestMapping(value = "/life/{id}", method = RequestMethod.GET)
    public ModelAndView life(Model model,@PathVariable String id){
        return new ModelAndView("life");

    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ModelAndView me(Model model,@PathVariable String id){
        return new ModelAndView("user");

    }


}
