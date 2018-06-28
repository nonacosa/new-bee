package link.newBee.dao;

import link.newBee.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * data 2018-06-28   22:20
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */
public interface UserDao extends JpaRepository<User,Long>{

    User findByUserName (String userName);

}
