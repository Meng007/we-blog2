package we.blog.web.api.service;

import we.blog.domain.pojo.User_enshrine;

import java.util.List;


public interface Service {

    List<User_enshrine> querryAll(Integer myId);
    Integer cancelCollection(Integer cId);

}
