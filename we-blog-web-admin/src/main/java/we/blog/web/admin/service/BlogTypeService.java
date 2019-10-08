package we.blog.web.admin.service;

import we.blog.commons.bean.PageInfo;
import we.blog.domain.pojo.Blogs_function;

import java.util.Map;

public interface BlogTypeService {

    void save(Blogs_function blogs_function);
    void  deleteMuliit(String [] id);
    void update (Blogs_function blogs_function);
    PageInfo<Blogs_function> page(int start, int length, int draw);
    Integer count();
    void insert(Blogs_function blogs_function);

}
