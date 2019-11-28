package we.blog.web.api.mapper;

import org.apache.ibatis.annotations.Param;
import we.blog.domain.pojo.User_enshrine;

import java.util.List;

public interface UserEnshrineMapper {

 List<User_enshrine> selectAllByMyId(@Param("myId") Integer myId);

 //取消收藏
    Integer undateDel(@Param("cId") Integer cId);
}