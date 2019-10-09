package we.blog.web.admin.service;

import we.blog.commons.bean.PageInfo;
import we.blog.domain.pojo.User;
import we.blog.domain.pojo.User_message;
import we.blog.web.admin.dto.BlogContent;

import java.util.List;

public interface UserService {
    //删除用户
    Integer deleteUser(String[] ids);

    //查找用户
    User findUser(String username);

    //分页查询普通用户
    PageInfo<User> page(int start, int length, int draw, User user);

    //分页查询vip用户
    PageInfo<User> pageVip(int start, int length, int draw, User user);

    //获取用户信息
    User_message getUserInfo(String id);

    //根据id获取一个用户
    User getUserById(String id);

    //修改用户
    Integer updateUser(User user);
}
