package we.blog.web.admin.service;

import we.blog.commons.bean.PageInfo;
import we.blog.web.admin.dto.BlogContent;

public interface BlogContentService {

    //分页查询
    PageInfo<BlogContent> page(int start, int length, int draw,BlogContent blg);
    //删除
    void deleteMulti(String [] ids);
}
