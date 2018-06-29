package link.newBee.service;

import link.newBee.Entity.Blog;

import java.util.List;

/**
 * data 2018-06-28   22:05
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */

public interface BlogService {


      Blog saveBlog(Blog blog);

      Blog getBlogById(Long id);




}
