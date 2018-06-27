package link.newBee.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * data 2017-11-02   09:40
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index(Model model){
        model.addAttribute("hello","HELLO WELCOME WEB BEE !");
        System.out.println("hello");
        return "hello";
//        return "Hello World";
    }
}
