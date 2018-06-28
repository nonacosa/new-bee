package link.newBee.serviceImpl;

import link.newBee.Entity.User;
import link.newBee.dao.UserDao;
import link.newBee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * data 2018-06-28   22:18
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */
public class userServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByName(User user) {
        return userDao.findByUserName(user.getUserName());
    }

    @Override
    public User saveUser(User user) {
        return userDao.saveAndFlush(user);
    }
}
