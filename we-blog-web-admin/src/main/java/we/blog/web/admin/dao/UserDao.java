package we.blog.web.admin.dao;

import org.springframework.stereotype.Repository;
import we.blog.domain.pojo.User;
import we.blog.web.admin.dto.BlogContent;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao {

    //获取所有用户
    List<User> getUserList();

    //分页获取用户
    List<User> page(Map<String, Object> params);

    //删除用户
    Integer deleteUser(Integer id);

    //查找用户
    User findUser(String username);

    //博客记录数
    Integer count();
}
