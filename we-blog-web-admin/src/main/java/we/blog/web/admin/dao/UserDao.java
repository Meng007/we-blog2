package we.blog.web.admin.dao;

import org.springframework.stereotype.Repository;
import we.blog.domain.pojo.User;
import we.blog.domain.pojo.User_message;
import we.blog.web.admin.dto.BlogContent;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao {

    //获取所有用户
    User getUserById(String id);

    //分页获取用户
    List<User> page(Map<String, Object> params);

    //删除用户
    Integer deleteUser(String[] ids);

    //查找用户
    User findUser(String username);

    //博客记录数
    Integer count();

    //分页获取vip用户
    List<User> pageVip(Map<String, Object> params);

    //获取用户信息
    User_message getUserInfo(String id);

    //修改用户
    Integer updateUser(User user);

}
