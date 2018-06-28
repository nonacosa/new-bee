package link.newBee.serviceImpl;

import link.newBee.Entity.User;
import link.newBee.dao.UserDao;
import link.newBee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * data 2018-06-28   22:18
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserByName(String userName) {
        return userDao.findByUserName(userName);
    }

    @Override
    public User saveUser(User user) {
        return userDao.saveAndFlush(user);
    }

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        User user = new User();
        Long id = 1212121212L;
        user.setId(id);
        user.setUserName("庄文达");
        user.setPhone("17181710917");
        user.setEmail("sis.nonacosa@gmail.com");
        user.setPassword("000000");
        userService.saveUser(user);
    }
}
