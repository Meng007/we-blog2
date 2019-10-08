package we.blog.web.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import we.blog.commons.bean.PageInfo;
import we.blog.web.admin.dao.BlogContentDao;
import we.blog.web.admin.dto.BlogContent;
import we.blog.web.admin.service.BlogContentService;

import java.util.HashMap;
import java.util.Map;

@Service
public class BlogContentServiceImpl implements BlogContentService {
    @Autowired
    private BlogContentDao blogContentDao;
    @Override
    public PageInfo<BlogContent> page(int start, int length, int draw, BlogContent blg) {
        int count = blogContentDao.count(blg);
        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("pageParams", blg);

        PageInfo<BlogContent> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(blogContentDao.page(params));

        return pageInfo;
    }

    @Override
    public void deleteMulti(String[] ids) {
        blogContentDao.deleteMulti(ids);
    }
}
