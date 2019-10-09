package we.blog.web.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import we.blog.commons.bean.PageInfo;
import we.blog.domain.pojo.User;
import we.blog.domain.pojo.User_message;
import we.blog.web.admin.dao.UserDao;
import we.blog.web.admin.dto.BlogContent;
import we.blog.web.admin.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Integer deleteUser(String[] ids) {
        return userDao.deleteUser(ids);
    }

    @Override
    public User findUser(String username) {
        return userDao.findUser(username);
    }

    @Override
    public PageInfo<User> page(int start, int length, int draw, User user) {
        int count = userDao.count();

        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("pageParams", user);

        PageInfo<User> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(userDao.page(params));

        return pageInfo;
    }

    @Override
    public PageInfo<User> pageVip(int start, int length, int draw, User user) {
        int count = userDao.count();

        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("pageParams", user);

        PageInfo<User> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(userDao.pageVip(params));

        return pageInfo;
    }

    @Override
    public User_message getUserInfo(String id) {
        return userDao.getUserInfo(id);
    }

    @Override
    public User getUserById(String id) {
        return userDao.getUserById(id);
    }

    @Override
    public Integer updateUser(User user) {
        return userDao.updateUser(user);
    }

}
