package we.blog.web.admin.dao;

import we.blog.domain.pojo.Notice;

import java.util.List;
import java.util.Map;

public interface NoticeDao {

    //添加
    Integer insert(Notice notice);
    //删除
    Integer delete(String [] ids);
    //查询
    List<Notice> select(Map map);
    //记录条数
    Integer count();
}
