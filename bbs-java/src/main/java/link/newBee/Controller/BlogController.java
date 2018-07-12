package link.newBee.Controller;

import link.newBee.Entity.Blog;
import link.newBee.Entity.User;
import link.newBee.annocation.Log;
import link.newBee.serviceImpl.BlogServiceImpl;
import link.newBee.util.EntryUtil;
import link.newBee.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * data 2018-06-28   02:47
 * E-mail   sis.nonacosa@gmail.com
 * @author sis.nonacosa
 */
@RestController
@RequestMapping("/blog")
public class BlogController extends BaseController{

    @Autowired
    BlogServiceImpl blogService;

    @Log("获取博客{id}")
    @RequestMapping(value = "/getBlogById/{id}", method = RequestMethod.GET)
    public Result<Blog> getBlogById (@PathVariable Long id){
        return Result.ok(blogService.getBlogById(id,true));
    }


    @Log("保存博客")
    @RequestMapping(value = "/insert", method = RequestMethod.POST,consumes = "application/json")
    public Result<Blog> insert(@RequestBody Blog blog){
        User user  = new User();
        user.setId(getUserId());
        blog.setUser(user);
        return Result.ok(blogService.saveBlog(blog));
    }

    @Log("根据标签获取全部文章")
    @RequestMapping(value = "/getBlogByTag", method = RequestMethod.POST,consumes = "application/json")
    public Result<Page<Blog>> getBlogByTag(@RequestBody Blog blog){
        return blogService.getBlogByTag(blog);
    }

    @Log("根据用户全部文章")
    @RequestMapping(value = "/getBlogsByUser", method = RequestMethod.GET)
    public Result<Page<Blog>> getBlogsByUser(){
        return blogService.getBlogByUSer(getUserId());
    }

    @Log("博客点赞++")
    @RequestMapping(value = "/getBlogCommendAdd/{id}", method = RequestMethod.GET)
    public Result<Blog> getBlogCommendAdd(@PathVariable Long id){
        return blogService.getBlogCommendAdd(id);
    }

    @Log("博客评论++")
    @RequestMapping(value = "/getBlogCommentAdd/{id}", method = RequestMethod.GET)
    public Result<Blog> getBlogCommentAdd(@PathVariable Long id){
        return blogService.getBlogCommentAdd(id);
    }



}
