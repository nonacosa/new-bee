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
    public Result<User> getUserByUserName(String userName) {
        return Result.ok(userDao.findByUserName(userName));
    }

    @Override
    public User getUserByGithubNodeId(String nodeId) {
        return userDao.findByGithubNodeId(nodeId);
    }

    @Override
    public User saveUser(User user) {
        //若 github_node_id 非空 -> 防止多次生成
        if(!StringUtils.isEmpty(user.getGithubNodeId())){
          User result =  getUserByGithubNodeId(user.getGithubNodeId());
          if(result != null){
              user = result;
          }
        }
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
        //若 github_node_id 非空 -> 验证
        if(!StringUtils.isEmpty(user.getGithubNodeId())){
            User result = getUserByGithubNodeId(user.getGithubNodeId());
            if(result != null) {
                return  Result.ok(result);
            }else{
                Result.error(null,"操作失败,github登录失败");
            }

        }
        User userResult = userDao.findByEmail(user.getEmail());
        if(userResult == null){
            return Result.error(null,"操作失败,该账号不存在！");
        }
        //密码不对
        if(!Objects.equal(userResult.getPassword(),user.getPassword())){
            return Result.error(null,"操作失败,密码错误!");
        }
        return  Result.ok(userResult);

    }



}
