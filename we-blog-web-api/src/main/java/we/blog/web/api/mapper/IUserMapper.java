package we.blog.web.api.mapper;


import org.apache.ibatis.annotations.Param;
import we.blog.domain.pojo.User;
import we.blog.domain.pojo.User_attention;
import we.blog.domain.pojo.User_message;

import java.util.List;


public interface IUserMapper {
    Integer checkUsername(@Param("name") String username);
    Integer register(@Param("user") User user);
    Integer addMessage(@Param("um_id") Integer id, @Param("time") String time);
    Integer login(@Param("Name") String username, @Param("Pass") String password);
    User_message findUserByid(@Param("bm_u_id") String id);
    User_message show(@Param("uId") Integer id);
    List<User_message> getAttention(@Param("u_id") Integer id);
    Integer update(@Param("ni") String name, @Param("sex") String sex, @Param("nation") String nation, @Param("day") String birth, @Param("intro") String intro, @Param("idm") Integer id);
     Integer picInfo(@Param("id") Integer id, @Param("path") String path);
    Integer cancel(@Param("cid")Integer id);
}
