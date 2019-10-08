package we.blog.web.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import we.blog.commons.bean.PageInfo;
import we.blog.domain.pojo.Blogs_function;
import we.blog.web.admin.dao.BlogTypeDao;
import we.blog.web.admin.service.BlogTypeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class BlogTypeServiceImpl implements BlogTypeService {
    @Autowired
    private BlogTypeDao blogTypeDao;
    @Override
    public void save(Blogs_function blogs_function) {
        blogTypeDao.save(blogs_function);
    }

    @Override
    public void deleteMuliit(String[] id) {
        blogTypeDao.deleteMuliit(id);
    }

    @Override
    public void update(Blogs_function blogs_function) {
        blogTypeDao.update(blogs_function);
    }

    @Override
    public PageInfo<Blogs_function> page(int start, int length, int draw) {
        int count = blogTypeDao.count();
        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);

        PageInfo<Blogs_function> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(blogTypeDao.page(params));

        return pageInfo;
    }

    @Override
    public Integer count() {
        return null;
    }

    @Override
    public void insert(Blogs_function blogs_function) {
        if (blogs_function.getBf_id()==null){
            save(blogs_function);
        }else {
            update(blogs_function);
        }
    }
}
