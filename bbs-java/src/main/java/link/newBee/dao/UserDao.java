package link.newBee.dao;

import link.newBee.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * data 2018-06-28   22:20
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */
public interface UserDao extends JpaRepository<User,String>{

    User findByUserName (String userName);

    User findByEmailOrUserName(String email, String userName);

    User findById(String id);

    User findByGithubNodeId(String nodeId);

    User findByGithubNodeIdOrUserName(String nodeId, String userName);
}
