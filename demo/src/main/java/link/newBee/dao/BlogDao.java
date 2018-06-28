package link.newBee.dao;

import link.newBee.Entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * data 2018-06-28   22:20
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */
public interface BlogDao extends JpaRepository<Blog,Long>{

    Blog findContentById(Long id);

}
