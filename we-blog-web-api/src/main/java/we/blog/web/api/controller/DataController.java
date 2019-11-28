package we.blog.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import we.blog.commons.bean.BaseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import we.blog.domain.pojo.*;
import we.blog.web.api.service.IDataService;
import we.blog.web.api.service.Impl.DataServiceImpl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/getData")
public class DataController extends HttpServlet {
    private int blogs = 0;
    @Autowired
    private IDataService iDataService;
    //查找首页里的博客分类
    @RequestMapping(value = "/getType")
    public List<Blogs_function> getDataType(){
        return iDataService.getBlogsType();
    }
    //查找具体博客内容
    @RequestMapping(value = "/getAllBlogs")
    public List<Blog_message> getBlogs(String nowblogs){
        return iDataService.getBlogs(nowblogs);
    }

    @RequestMapping(value = "/checkUser")
    //这里的request我用的是spring，有问题修改包
    public User_message checkUser(HttpServletRequest request, String u_id){
            return iDataService.checkUser(u_id);
    }
    @RequestMapping(value = "/searchSomething")
    public List<Blog_message> searchSomething(String search){
        return iDataService.getSearch(search);
    }
    @RequestMapping(value = "/getThisBlogs")
    public String setThisBlogs(HttpServletRequest request,Integer bm_id){
        blogs = bm_id;
        return "1";
    }
    @RequestMapping(value = "/getBlogs")
    public List<Blog_message> getBlogs(HttpServletRequest request){
        return iDataService.getThisBlog(blogs);
    }
    @RequestMapping("/setComment")
    public List<User_coment> setComment(String blogId,String advise,String um_id){
        return iDataService.setComment(blogId,advise,um_id);
    }
    @RequestMapping("/getComent")
    public List<User_coment> getComent(String blogID){
        return iDataService.getComent(blogID);
    }
    @RequestMapping("/writeBlogs")
    public String writeBlogs(HttpServletRequest request/*Blog_message blog_message*/){
        String bm_title = request.getParameter("bm_title");
        String bm_content = request.getParameter("bm_content");
        String bm_type = request.getParameter("type");
        String id = request.getParameter("id");
        Date date = new Date();
        String time = new SimpleDateFormat("yyyy-MM-dd").format(date);
        return iDataService.writeBlogs(bm_title,bm_content,Integer.parseInt(id),time,bm_type);
        //return dataService.writeBlogs(blog_message.getBm_title(),blog_message.getBm_title(),1);
    }
    @RequestMapping("/collectBlog")
    public String collectBlog(String my_id,String c_id){
        return iDataService.collectBlog(c_id,my_id);
    }
    @RequestMapping("/getnotification")
    public List<User_message> getnotification(String id){
        return iDataService.getnotification(id);
    }
    @RequestMapping("/getThisType")
    public List<Blog_message> getThisType(String bm_type){
        return iDataService.getThisType(bm_type);
    }
    @RequestMapping("/setAttention")
    public String setAttention(String id,String au_id){
        System.out.println(id+","+au_id);
        return iDataService.setAttention(au_id,id);
    }
    @RequestMapping("/notice")
    public List<Notice> notice(){
        return iDataService.notice();
    }
}
