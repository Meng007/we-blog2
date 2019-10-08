package we.blog.web.api.service;

import we.blog.domain.pojo.Blog_message;
import we.blog.domain.pojo.Blogs_function;
import we.blog.domain.pojo.User_coment;

import java.util.List;

public interface IDataService {
    List<Blogs_function> getBlogsType();
    List<Blog_message> getBlogs(String nowblogs);
    List<Blog_message> getSearch(String search);
    List<Blog_message> getThisBlog(Integer bm_id);
    List<User_coment> setComment(String blogId,String advise);
    List<User_coment> getComent(String blogID);
}
