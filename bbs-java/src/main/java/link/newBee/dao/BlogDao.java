package link.newBee.dao;

import link.newBee.Entity.Blog;
import link.newBee.util.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    Page<Blog> findBlogByTag(String tag, Pageable pageable);

    Page<Blog> findBlogByUserId(String userID, Pageable pageable);

//    Page<Blog> findBlogByTag(String tag, Pageable pageable,Sort sort);

}
