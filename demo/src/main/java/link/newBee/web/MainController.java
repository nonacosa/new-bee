package link.newBee.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * data 2017-11-02   09:40
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */


@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping("/")
    public String index(Model model){

        System.out.println("hello");
        return "index";
//        return "Hello World";
    }
}
