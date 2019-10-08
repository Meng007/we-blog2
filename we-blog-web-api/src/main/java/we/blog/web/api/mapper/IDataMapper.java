package we.blog.web.api.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import we.blog.domain.pojo.Blog_message;
import we.blog.domain.pojo.Blogs_function;
import we.blog.domain.pojo.User_coment;

import java.util.List;

public interface IDataMapper {
    List<Blogs_function> getType();
    List<Blog_message> getAllBlogs(@Param("nowblogs") Integer nowblogs);
    List<Blog_message> getSearch(@Param("search")String search);
    List<Blog_message> getThisBlog(@Param("bm_id")Integer bm_id);
    List<User_coment> setComment(@Param("bm_id") String blogId,@Param("advise") String advise);
    Integer updataComent(@Param("bm_id") String blogId);
    List<User_coment> getComent(@Param("blogID") String blogID);
}
