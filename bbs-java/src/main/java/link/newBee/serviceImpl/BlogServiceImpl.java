package link.newBee.serviceImpl;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import link.newBee.Entity.Blog;
import link.newBee.dao.BlogDao;
import link.newBee.service.BlogService;
import link.newBee.util.EmojiUtils;
import link.newBee.util.EntryUtil;
import link.newBee.util.PageableTools;
import link.newBee.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



/**
 * data 2018-06-28   22:18
 * E-mail   sis.nonacosa@gmail.com
 * Blog 服务
 * @author sis.nonacosa
 */

@Service
public class BlogServiceImpl implements BlogService {

    /**
     * 全部分类文章标识
     */
    private final String BLOG_TAG_ALL = "all";

    @Autowired
    private BlogDao blogDao;


    @Override
    public Blog saveBlog(Blog blog) {
        blog.setContent(EmojiUtils.emojiConvert(blog.getContent()));
        return blogDao.saveAndFlush(blog);
    }

    @Override
    public Blog getBlogById(Long id) {
        return getBlogById(id,false);
    }

    @Override
    public Blog getBlogById(Long id, Boolean addSelf) {
        Blog blog = blogDao.findContentById(Preconditions.checkNotNull(id));
        blog.setContent(EmojiUtils.emojiRecovery(blog.getContent()));
        if(addSelf){
            blog.setReadCount(blog.getReadCount()+1);
        }
        blog = saveBlog(blog);
        return blog;
    }

    public Result<Page<Blog>> getBlogByTag(Blog blog) {
        Pageable pageable = PageableTools.basicPage(0,EntryUtil.instance(blog).getSort());
        if(Objects.equal(BLOG_TAG_ALL, blog.getTag())){
            return Result.ok(blogDao.findAll(pageable));
        }

        return  Result.ok(blogDao.findBlogByTag(blog.getTag(),pageable));
    }

    @Override
    public Page<Blog> getAllBlog(String tag) {
        Pageable pageable =new PageRequest(0, 20);
        if(!Objects.equal(BLOG_TAG_ALL,tag)){
            return blogDao.findBlogByTag(tag,pageable);
        }
        return blogDao.findAll(pageable);


    }

    @Override
    public Result<Page<Blog>> getBlogByTag(Blog blog, Sort sort) {
        Pageable pageable =new PageRequest(0, 20,sort);
        return  Result.ok(blogDao.findBlogByTag(Preconditions.checkNotNull(blog).getTag(),pageable));
    }

    @Override
    public Result<Page<Blog>> getBlogByUSer(String userID) {

        Pageable pageable = PageableTools.basicPage(0,EntryUtil.instance(new Blog()).getSort());
        return  Result.ok(blogDao.findBlogByUserId(Preconditions.checkNotNull(userID),pageable));
    }

    @Override
    public Result<Blog> getBlogCommendAdd(Long blogId) {
        Blog blog = getBlogById(Preconditions.checkNotNull(blogId));
        blog.setCommendCount(Preconditions.checkNotNull(blog).getCommendCount()+1);
        return Result.ok(saveBlog(blog));
    }

    @Override
    public Result<Blog> getBlogCommentAdd(Long blogId) {
        Blog blog = getBlogById(Preconditions.checkNotNull(blogId));
        blog.setCommentCount(Preconditions.checkNotNull(blog).getCommentCount()+1);
        return Result.ok(saveBlog(blog));
    }



}
