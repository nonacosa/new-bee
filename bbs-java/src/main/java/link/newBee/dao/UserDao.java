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

    List<User> findByUserName (String userName);

    User findByEmail(String email);

    User findById(String id);
}
