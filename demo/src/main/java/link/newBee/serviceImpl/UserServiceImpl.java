package link.newBee.serviceImpl;

import link.newBee.Entity.User;
import link.newBee.dao.UserDao;
import link.newBee.service.UserService;
import link.newBee.util.Result;
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

    public Result<User> register(User user) {
        User userResult = userDao.findByEmail(user.getEmail());
        if(userResult == null){
           return Result.error(userResult,"操作失败,该邮箱已存在！");
        }

        return  Result.ok(this.saveUser(user));
    }





}
