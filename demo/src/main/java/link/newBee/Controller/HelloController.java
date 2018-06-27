package link.newBee.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * data 2017-11-02   09:40
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */


@Controller
public class HelloController {

    @RequestMapping("/helloWord")
    public String index(Model model){
        model.addAttribute("hello","HELLO WELCOME WEB BEE !");
        System.out.println("hello");
        return "hello";
//        return "Hello World";
    }
}
