package we.blog.web.admin.service;

import we.blog.commons.bean.PageInfo;
import we.blog.domain.pojo.User;
import we.blog.web.admin.dto.BlogContent;

import java.util.List;

public interface UserService {
    //获取所有用户
    List<User> getUserList();


    //删除用户
    Integer deleteUser(Integer id);

    //查找用户
    User findUser(String username);

    //分页查询
    PageInfo<User> page(int start, int length, int draw, User user);
}
