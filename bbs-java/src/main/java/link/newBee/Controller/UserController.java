package link.newBee.Controller;

import link.newBee.Entity.User;
import link.newBee.annocation.Log;
import link.newBee.serviceImpl.UserServiceImpl;
import link.newBee.util.Result;
import org.apache.commons.lang3.StringUtils;
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

    @Log("登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST,consumes = "application/json")
    public  Result<User> login(@RequestBody User user){

        return userService.login(user);
    }

    @Log("tocken登录")
    @RequestMapping(value = "/loginUser", method = RequestMethod.POST,consumes = "application/json")
    public  Result<User> loginUser(@RequestBody String token){

        return userService.loginUser(token);
    }

    @RequestMapping(value = "/getUserInfo/{id}", method = RequestMethod.GET)
    public Result<User> getUserInfo ( @PathVariable Long id){
        return userService.getUserById(id);
    }



    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public User insert(User user){

        return userService.saveUser(user);

    }

}
