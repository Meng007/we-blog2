package we.blog.web.admin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import we.blog.commons.bean.BaseResult;
import we.blog.domain.pojo.Admin;
import we.blog.web.admin.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public BaseResult login(@RequestBody Admin admin){
        System.out.println(admin);
        Admin login = adminService.login(admin);
        System.out.println(login);
        if (login !=null){
            return BaseResult.success("登录成功","/views/main.html",login);
        }
        return BaseResult.fail("用户名或密码错误");
    }
}
