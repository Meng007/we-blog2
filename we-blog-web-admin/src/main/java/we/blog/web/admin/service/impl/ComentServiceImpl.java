package we.blog.web.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import we.blog.commons.bean.PageInfo;
import we.blog.domain.pojo.User_coment;
import we.blog.web.admin.dao.ComentDao;
import we.blog.web.admin.service.ComentService;

import java.util.HashMap;
import java.util.Map;

@Service
public class ComentServiceImpl implements ComentService {
    @Autowired
    private ComentDao comentDao;
    @Override
    public Integer delete(String[] ids) {
        return comentDao.delete(ids);
    }

    @Override
    public PageInfo<User_coment> page(Integer start, Integer length, Integer draw, User_coment user_coment) {
        Integer count = comentDao.count();
        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("pageParams", user_coment);

        PageInfo<User_coment> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(comentDao.select(params));

        return pageInfo;
    }
}
