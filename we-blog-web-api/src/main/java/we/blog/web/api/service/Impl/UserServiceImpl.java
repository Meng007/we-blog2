package we.blog.web.api.service.Impl;

import org.springframework.stereotype.Service;
import we.blog.domain.pojo.User;
import we.blog.domain.pojo.User_attention;
import we.blog.domain.pojo.User_message;
import we.blog.web.api.mapper.IUserMapper;
import we.blog.web.api.service.IUserService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserMapper iUserMapper;
    @Override
    public Integer checkUsername(String username) {
        Integer integer = iUserMapper.checkUsername(username);
        return integer;
    }

    @Override
    public Integer register(User user) {
        Integer count = iUserMapper.register(user);
        return count;
    }

    @Override
    public Integer login(String username, String password) {
        Integer resos = iUserMapper.login(username, password);
        return resos;
    }

    @Override
    public Integer addMessage(Integer id, String time) {
        Integer integer = iUserMapper.addMessage(id, time);
        return integer;
    }

    @Override
    public User_message show(Integer id) {
        User_message list = iUserMapper.show(id);
        return list;
    }

    @Override
    public List<User_message> getAttention(Integer id) {
        List<User_message> list = iUserMapper.getAttention(id);
        return list;
    }

    @Override
    public Integer update(String name, String sex, String nation, String birth, String intro, Integer id) {
        Integer update = iUserMapper.update(name, sex, nation, birth, intro, id);
        return update;
    }

    @Override
    public Integer picInfo(Integer id, String path) {
        Integer re = iUserMapper.picInfo(id, path);
        return re;
    }
    @Override
    public Integer cancel(Integer id) {
        return iUserMapper.cancel(id);
    }

}
