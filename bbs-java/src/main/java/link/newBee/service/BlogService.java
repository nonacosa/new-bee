package link.newBee.service;

import link.newBee.Entity.Blog;
import link.newBee.util.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

/**
 * data 2018-06-28   22:05
 * E-mail   sis.nonacosa@gmail.com
 *  规则：**ById save** del** 不能用Result<T>包装，保障代码复用
 * @author sis.nonacosa
 */

public interface BlogService {


      Blog saveBlog(Blog blog);

      Blog getBlogById(Long id);

      Page<Blog> getAllBlog(String tag);

      Result<Page<Blog>> getBlogByTag (Blog blog,Sort sort);

      Result<Page<Blog>> getBlogByUSer (String userId);

      Result<Blog> getBlogCommendAdd (Long blogId);

      Result<Blog> getBlogCommentAdd (Long blogId);




}
