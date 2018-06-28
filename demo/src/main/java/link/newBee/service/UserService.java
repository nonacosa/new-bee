package link.newBee.service;

import link.newBee.Entity.User;
import org.springframework.stereotype.Service;

/**
 * data 2018-06-28   22:05
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */
@Service
public interface UserService  {


      User getUserByName(User user);

      User saveUser(User user);


}
