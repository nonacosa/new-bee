package link.newBee.service;

import link.newBee.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * data 2018-06-28   22:05
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */

public interface UserService  {


      List<User> getUserByName(User user);

      User saveUser(User user);


}
