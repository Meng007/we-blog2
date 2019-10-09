package we.blog.web.admin.dao;

import we.blog.domain.pojo.User_coment;

import java.util.List;
import java.util.Map;

public interface ComentDao {

    Integer delete(String []ids);
    List<User_coment> select(Map map);
    Integer count();
}
