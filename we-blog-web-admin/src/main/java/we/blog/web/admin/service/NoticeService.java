package we.blog.web.admin.service;

import we.blog.commons.bean.PageInfo;
import we.blog.domain.pojo.Notice;

import java.util.List;

public interface NoticeService {

    //添加
    Integer insert(Notice notice);
    //删除
    Integer delete(String [] ids);
    //查询
    PageInfo<Notice> select(int start,int length,int draw,Notice notice);
}
