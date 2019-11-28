package we.blog.web.api.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import we.blog.domain.pojo.*;

import java.util.List;
@Repository
public interface IDataMapper {
    List<Blogs_function> getType();
    List<Blog_message> getAllBlogs(@Param("nowblogs") Integer nowblogs);
    List<Blog_message> getSearch(@Param("search")String search);
    List<Blog_message> getThisBlog(@Param("bm_id")Integer bm_id);
    List<User_coment> setComment(@Param("bm_id") String blogId,@Param("advise") String advise,@Param("my_id") String um_id);
    Integer updataComent(@Param("bm_id") String blogId);
    List<User_coment> getComent(@Param("blogID") String blogID);
    String writeBlog(@Param("bm_title") String bm_title,@Param("bm_content") String bm_content,@Param("bm_u_id") Integer id,@Param("bm_time") String time,@Param("bm_type") String bm_type);
    String collectBlog(@Param("c_id") String c_id,@Param("my_id") String my_id);
    Integer updateVisit(@Param("bm_id")Integer bm_id);
    List<User_message> getnotification(@Param("um_id") String um_id);
    List<Blog_message> getThisType(@Param("bm_type") String bm_type);
    String setAttention(@Param("au_id") String au_id,@Param("my_id") String my_id);
    User_message checkUser(@Param("um_id") String um_id);
    List<Notice> notice();
}
