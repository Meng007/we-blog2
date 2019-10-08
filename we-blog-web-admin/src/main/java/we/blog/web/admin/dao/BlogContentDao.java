package we.blog.web.admin.dao;

import we.blog.web.admin.dto.BlogContent;

import java.util.List;
import java.util.Map;

public interface BlogContentDao {

    //分页查找博客
    List<BlogContent> page(Map<String, Object> params);
    //博客记录数
    Integer count(BlogContent blogContent);
    //删除
    void deleteMulti(String [] ids);
}
