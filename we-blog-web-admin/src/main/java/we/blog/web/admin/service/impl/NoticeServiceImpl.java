package we.blog.web.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import we.blog.commons.bean.PageInfo;
import we.blog.domain.pojo.Notice;
import we.blog.web.admin.dao.NoticeDao;
import we.blog.web.admin.service.NoticeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;

    @Override
    public Integer insert(Notice notice) {
        return noticeDao.insert(notice);
    }

    @Override
    public Integer delete(String[] ids) {
        return noticeDao.delete(ids);
    }

    @Override
    public PageInfo<Notice> select(int start, int length, int draw,Notice notice) {
        Integer count = noticeDao.count();

        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("pageParams", notice);

        PageInfo<Notice> pageInfo = new PageInfo<>();
        pageInfo.setRecordsTotal(count);
        pageInfo.setDraw(draw);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(noticeDao.select(params));


        return pageInfo;
    }
}
