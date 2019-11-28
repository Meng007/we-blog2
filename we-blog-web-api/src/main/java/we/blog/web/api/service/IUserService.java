package we.blog.web.api.service;

import we.blog.domain.pojo.User;
import we.blog.domain.pojo.User_attention;
import we.blog.domain.pojo.User_message;

import java.util.List;


public interface IUserService {
    Integer checkUsername(String username);
    Integer register(User user);
    Integer login(String username, String password);
    Integer addMessage(Integer id, String time);
    User_message show(Integer id);
    List<User_message> getAttention(Integer id);
    Integer update(String name, String sex, String nation, String birth, String intro, Integer id);
    Integer picInfo(Integer id, String path);
    Integer cancel(Integer id);

}
