package we.blog.web.admin.dao;

import we.blog.domain.pojo.Blogs_function;

import java.util.List;
import java.util.Map;

public interface BlogTypeDao {

    void save(Blogs_function blogs_function);
    void  deleteMuliit(String [] id);
    void update (Blogs_function blogs_function);
    List<Blogs_function> page(Map<String,Object> map);
    Integer count();
}
