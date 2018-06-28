package link.newBee.serviceImpl;

import link.newBee.Entity.Blog;
import link.newBee.dao.BlogDao;
import link.newBee.service.BlogService;
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
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;


    @Override
    public Blog saveBlog(Blog blog) {
        return blogDao.saveAndFlush(blog);
    }

    @Override
    public Blog getBlogById(Long id) {
        return blogDao.findContentById(id);
    }


}
