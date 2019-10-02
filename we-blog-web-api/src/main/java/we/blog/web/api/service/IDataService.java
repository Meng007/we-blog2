package we.blog.web.api.service;

import we.blog.domain.pojo.Blog_message;
import we.blog.domain.pojo.Blogs_function;

import java.util.List;

public interface IDataService {
    List<Blogs_function> getBlogsType();
    List<Blog_message> getBlogs();
}
