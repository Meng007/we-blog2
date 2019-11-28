package we.blog.web.api.service;

import we.blog.domain.pojo.*;

import java.util.List;

public interface IDataService {
    List<Blogs_function> getBlogsType();
    List<Blog_message> getBlogs(String nowblogs);
    List<Blog_message> getSearch(String search);
    List<Blog_message> getThisBlog(Integer bm_id);
    List<User_coment> setComment(String blogId,String advise,String um_id);
    List<User_coment> getComent(String blogID);
    String writeBlogs(String bm_title,String bm_content,Integer id,String time,String bm_type);
    String collectBlog(String c_id,String my_id);
    List<User_message> getnotification(String um_id);
    List<Blog_message> getThisType(String bm_type);
    String setAttention(String au_id,String my_id);
    User_message checkUser(String u_id);
    List<Notice> notice();
}
