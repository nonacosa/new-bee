package link.newBee.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import link.newBee.Entity.User;
import link.newBee.dao.UserDao;
import link.newBee.service.UserService;
import link.newBee.util.DateUtil;
import link.newBee.util.JsonUtil;
import link.newBee.util.Result;
import org.apache.commons.lang3.StringUtils;
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
    public Result<User> getUserById(Long id) {
        return Result.ok(userDao.findById(id));
    }

    @Override
    public User saveUser(User user) {
        user.setCreateTime(DateUtil.getDefaultDateStr());
        return userDao.saveAndFlush(user);
    }

    @Override
    public Result<User> register(User user) {
        User userResult = userDao.findByEmail(user.getEmail());
        if(userResult == null){
            return  Result.ok(this.saveUser(user));

        }
        return Result.error(userResult,"操作失败,该邮箱已存在！");


    }

    @Override
    public Result<User> login(User user) {
        User userResult = userDao.findByEmail(user.getEmail());
        if(userResult == null){
            return Result.error(null,"操作失败,该账号不存在！");
        }
        if(!user.getPassword().equals(userResult.getPassword())){
            return Result.error(null,"操作失败,密码错误!");
        }
        return  Result.ok(userResult);
    }

    @Override
    public Result<User> loginUser(String token) {
         ObjectMapper oMapper = new ObjectMapper();
         User user = null;
        if(StringUtils.isNoneEmpty(token)){
            try {
                String userJson = JsonUtil.protobufToJson(token);
                user = oMapper.readValue(userJson,User.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.login(user);
    }


}
