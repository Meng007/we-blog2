package we.blog.web.api.mapper;

import org.apache.ibatis.annotations.Param;
import we.blog.domain.pojo.User_message;

public interface IUserMapper {
    User_message findUserByid(@Param("bm_u_id")String id);
}
