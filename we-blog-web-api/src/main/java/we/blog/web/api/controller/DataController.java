package we.blog.web.api.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import we.blog.domain.pojo.Blog_message;
import we.blog.domain.pojo.Blogs_function;
import we.blog.domain.pojo.User_coment;
import we.blog.web.api.service.Impl.DataServiceImpl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/getData")
public class DataController extends HttpServlet {
    private int blogs = 0;
    @Resource
    private DataServiceImpl dataService;
    //查找首页里的博客分类
    @RequestMapping(value = "/getType")
    public List<Blogs_function> getDataType(){
        return dataService.getBlogsType();
    }
    //查找具体博客内容
    @RequestMapping(value = "/getAllBlogs")
    public List<Blog_message> getBlogs(String nowblogs){
        return dataService.getBlogs(nowblogs);
    }
    @RequestMapping(value = "/checkUser")
    //这里的request我用的是spring，有问题修改包
    public String checkUser(HttpServletRequest request){
        Object u_id = request.getSession().getAttribute("u_id");
        if(u_id!=null){
            return "1";
        }
        return "0";
    }
    @RequestMapping(value = "/searchSomething")
    public List<Blog_message> searchSomething(String search){
        return dataService.getSearch(search);
    }
    @RequestMapping(value = "/getThisBlogs")
    public String setThisBlogs(HttpServletRequest request,Integer bm_id){
        //request.getSession().setAttribute("bm_id",bm_id);
        //System.out.println("直接获取:"+request.getSession().getAttribute("bm_id"));
        blogs = bm_id;
        return "1";
    }
    @RequestMapping(value = "/getBlogs")
    public List<Blog_message> getBlogs(HttpServletRequest request){
        /*Integer bm_id = (Integer) request.getSession().getAttribute("bm_id");
        System.out.println("bm_id"+bm_id);
        System.out.println(dataService.getThisBlog(bm_id));*/
        return dataService.getThisBlog(blogs);
    }
    @RequestMapping("/setComment")
    public List<User_coment> setComment(String blogId,String advise){
        return dataService.setComment(blogId,advise);
    }
    @RequestMapping("/getComent")
    public List<User_coment> getComent(String blogID){
        return dataService.getComent(blogID);
    }

}
