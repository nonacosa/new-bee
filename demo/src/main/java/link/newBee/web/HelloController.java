package link.newBee.web;

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
    public String index(){
        System.out.println("hello");
        return "Hello World";
    }
}
