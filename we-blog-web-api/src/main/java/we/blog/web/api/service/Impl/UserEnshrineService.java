package we.blog.web.api.service.Impl;

import we.blog.domain.pojo.User_enshrine;
import we.blog.web.api.mapper.UserEnshrineMapper;
import we.blog.web.api.service.Service;

import javax.annotation.Resource;
import java.util.List;

@org.springframework.stereotype.Service
public class UserEnshrineService implements Service {

    @Resource
 private UserEnshrineMapper userEnshrineMapper;

    @Override
    public List<User_enshrine> querryAll(Integer myId) {
        List<User_enshrine> list = userEnshrineMapper.selectAllByMyId(myId);
        return list;
    }

    @Override
    public Integer cancelCollection(Integer cId) {
        Integer row = userEnshrineMapper.undateDel(cId);
        return row;
    }
}
