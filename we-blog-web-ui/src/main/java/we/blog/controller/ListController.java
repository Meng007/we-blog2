package we.blog.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import we.blog.commons.utils.HttpClientUtils;

@RestController
@RequestMapping("/getListController")
public class ListController {
    @RequestMapping(value = "/getType",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getType(){
        System.out.println("进入ListController");
        String s = HttpClientUtils.doGet("http://localhost:8060/getData/getType");
        System.out.println("s"+s);
        return s;
    }
    @RequestMapping("/test")
    public void test(){
        System.out.println("111111");
    }
}
