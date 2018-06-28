package link.newBee.Controller;

import link.newBee.Entity.User;
import link.newBee.serviceImpl.UserServiceImpl;
import link.newBee.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * data 2018-06-28   02:47
 * E-mail   sis.nonacosa@gmail.com
 * @author sis.nonacosa
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/register")
    public User register(User user){

        return user;
    }

    @RequestMapping(value = "/getUserByName/{userName}", method = RequestMethod.GET)
    public Result<List<User>> getUserByName ( @PathVariable String userName){
        return Result.ok(userService.getUserByName(userName));
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public User insert(User user){

        Long id = 1212121212L;
        user.setId(id);
        user.setUserName("庄文达");
        user.setPhone("17181710917");
        user.setEmail("sis.nonacosa@gmail.com");
        user.setPassword("000000");
        return userService.saveUser(user);

    }

}
