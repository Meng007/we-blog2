package we.blog.web.admin.service;

import we.blog.commons.bean.PageInfo;
import we.blog.domain.pojo.User_coment;

public interface ComentService {

    Integer delete(String[] ids);
    PageInfo<User_coment> page(Integer start, Integer length, Integer draw, User_coment user_coment);
}
