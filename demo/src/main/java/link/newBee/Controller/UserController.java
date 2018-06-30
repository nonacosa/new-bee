package link.newBee.Controller;

import link.newBee.Entity.User;
import link.newBee.serviceImpl.UserServiceImpl;
import link.newBee.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/register", method = RequestMethod.POST,consumes = "application/json")
    public  Result<User> register(@RequestBody User user){

        return userService.register(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST,consumes = "application/json")
    public  Result<User> login(@RequestBody User user){

        return userService.login(user);
    }

    @RequestMapping(value = "/getUserByName/{userName}", method = RequestMethod.GET)
    public Result<List<User>> getUserByName ( @PathVariable String userName){
        return Result.ok(userService.getUserByName(userName));
    }



    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public User insert(User user){

        return userService.saveUser(user);

    }

}
