package we.blog.web.api.service.Impl;

import org.springframework.stereotype.Service;
import we.blog.domain.pojo.Blog_message;
import we.blog.domain.pojo.Blogs_function;
import we.blog.domain.pojo.User_coment;
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
    public List<Blog_message> getBlogs(String nowblogs) {
        return iDataMapper.getAllBlogs(Integer.parseInt(nowblogs));
    }

    @Override
    public List<Blog_message> getSearch(String search) {
        return iDataMapper.getSearch(search);
    }

    @Override
    public List<Blog_message> getThisBlog(Integer bm_id) {
        return iDataMapper.getThisBlog(bm_id);
    }

    @Override
    public List<User_coment> setComment(String blogId,String advise) {
        iDataMapper.updataComent(blogId);
        return iDataMapper.setComment(blogId,advise);
    }

    @Override
    public List<User_coment> getComent(String blogID) {
        return iDataMapper.getComent(blogID);
    }


}
