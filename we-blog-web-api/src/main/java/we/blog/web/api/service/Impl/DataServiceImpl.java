package we.blog.web.api.service.Impl;

import org.springframework.stereotype.Service;
import we.blog.domain.pojo.Blog_message;
import we.blog.domain.pojo.Blogs_function;
import we.blog.web.api.mapper.IDataMapper;
import we.blog.web.api.service.IDataService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DataServiceImpl implements IDataService {
    @Resource
    private IDataMapper iDataMapper;
    @Override
    public List<Blogs_function> getBlogsType() {
        return iDataMapper.getType();
    }

    @Override
    public List<Blog_message> getBlogs() {
        return iDataMapper.getAllBlogs();
    }

}
