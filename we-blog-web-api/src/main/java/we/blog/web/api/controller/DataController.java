package we.blog.web.api.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import we.blog.web.api.service.Impl.DataServiceImpl;

import javax.annotation.Resource;

@RestController
@RequestMapping("/getData")
public class DataController {
    @Resource
    private DataServiceImpl dataService;
    //查找首页里的博客分类
    @RequestMapping(value = "/getType",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getDataType(){
        System.out.println("进入api的controller");
        return JSONObject.toJSONString(dataService.getBlogsType());
    }
    //查找具体博客内容
    @RequestMapping(value = "/getAllBlogs",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getBlogs(){
        return JSONObject.toJSONString(dataService.getBlogs());
    }
}
