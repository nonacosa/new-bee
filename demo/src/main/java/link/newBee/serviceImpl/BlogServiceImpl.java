package link.newBee.serviceImpl;

import link.newBee.Entity.Blog;
import link.newBee.dao.BlogDao;
import link.newBee.service.BlogService;
import link.newBee.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * data 2018-06-28   22:18
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */

@Service
public class BlogServiceImpl implements BlogService {

    private final String BLOG_TAG_ALL = "all";

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

    @Override
    public Result<Page<Blog>> getBlogByTag(Blog blog) {
        Pageable pageable =new PageRequest(0, 20);
        return  Result.ok(blogDao.findBlogByTag(blog.getTag(),pageable));
    }

    @Override
    public Page<Blog> getAllBlog(String tag) {
        Pageable pageable =new PageRequest(0, 20);
        if(!BLOG_TAG_ALL.equals(tag)){
            return blogDao.findBlogByTag(tag,pageable);
        }
        return blogDao.findAll(pageable);


    }


}
