package we.blog.web.api.mapper;


import org.apache.ibatis.annotations.Param;
import we.blog.domain.pojo.Blog_message;

import java.util.List;

public interface BlogMessageMapper {


    List<Blog_message> selectByUid(@Param("bmId") Integer bmId);


}