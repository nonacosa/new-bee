package link.newBee.service;

import link.newBee.Entity.User;
import link.newBee.util.Result;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * data 2018-06-28   22:05
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */

public interface UserService  {


      Result<User> getUserById(String id);

      User saveUser(User user);

      Result<User> register(User user);

      Result<User> login(Map<String,String> param);


      Result<User> loginUser(User user);
}
