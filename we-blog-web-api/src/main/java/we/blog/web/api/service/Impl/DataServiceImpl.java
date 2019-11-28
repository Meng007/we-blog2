package we.blog.web.api.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import we.blog.domain.pojo.*;
import we.blog.web.api.exception.SearchException;
import we.blog.web.api.mapper.IDataMapper;
import we.blog.web.api.service.IDataService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DataServiceImpl implements IDataService {
    @Autowired
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
        if(search == null){
            throw new SearchException("没有查询事件");
        }
        return iDataMapper.getSearch(search);
    }

    @Override
    public List<Blog_message> getThisBlog(Integer bm_id) {
        //更新一下访问量
        iDataMapper.updateVisit(bm_id);
        return iDataMapper.getThisBlog(bm_id);
    }

    @Override
    public List<User_coment> setComment(String blogId,String advise,String um_id) {
        System.out.println(blogId+","+advise+","+um_id);
        iDataMapper.updataComent(blogId);
        return iDataMapper.setComment(blogId,advise,um_id);
    }

    @Override
    public List<User_coment> getComent(String blogID) {
        return iDataMapper.getComent(blogID);
    }

    @Override
    public String writeBlogs(String bm_title, String bm_content, Integer id,String time,String bm_type) {
        return iDataMapper.writeBlog(bm_title,bm_content,id,time,bm_type);
    }

    @Override
    public String collectBlog(String c_id, String my_id) {
        return iDataMapper.collectBlog(c_id,my_id);
    }

    @Override
    public List<User_message> getnotification(String um_id) {
        return iDataMapper.getnotification(um_id);
    }

    @Override
    public List<Blog_message> getThisType(String bm_type) {
        return iDataMapper.getThisType(bm_type);
    }

    @Override
    public String setAttention(String au_id, String my_id) {
        return iDataMapper.setAttention(au_id,my_id);
    }

    @Override
    public User_message checkUser(String u_id) {
        return iDataMapper.checkUser(u_id);
    }

    @Override
    public List<Notice> notice() {
        return iDataMapper.notice();
    }


}
