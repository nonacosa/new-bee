package link.newBee.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Objects;
import link.newBee.Entity.User;
import link.newBee.dao.UserDao;
import link.newBee.service.UserService;
import link.newBee.util.DateUtil;
import link.newBee.util.JsonUtil;
import link.newBee.util.Result;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

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
    public Result<User> getUserById(String id) {
        return Result.ok(userDao.findById(id));
    }

    @Override
    public User saveUser(User user) {
        if(StringUtils.isEmpty(user.getId())){
            user.setId(UUID.randomUUID().toString());
        }
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
    public Result<User> login(Map<String,String> param) {
        User user ;
        Result<User> result = Result.error(null,"操作失败");
        String token = param.getOrDefault("token",null);
        if(StringUtils.isNoneEmpty(token)){
            try {
                user = JsonUtil.tokenToObject(token,User.class);
                result = this.loginUser(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;

    }

    @Override
    public Result<User> loginUser(User user) {
        User userResult = userDao.findByEmail(user.getEmail());
        if(userResult == null){
            return Result.error(null,"操作失败,该账号不存在！");
        }
        if(!Objects.equal(userResult.getPassword(),user.getPassword())){
            return Result.error(null,"操作失败,密码错误!");
        }
        return  Result.ok(userResult);

    }


}
