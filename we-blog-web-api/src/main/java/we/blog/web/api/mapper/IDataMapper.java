package we.blog.web.api.mapper;

import org.springframework.stereotype.Repository;
import we.blog.domain.pojo.Blog_message;
import we.blog.domain.pojo.Blogs_function;

import java.util.List;

public interface IDataMapper {
    List<Blogs_function> getType();
    List<Blog_message> getAllBlogs();
}
