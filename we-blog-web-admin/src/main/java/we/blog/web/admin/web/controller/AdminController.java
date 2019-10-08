package we.blog.web.admin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import we.blog.commons.bean.BaseResult;
import we.blog.domain.pojo.Admin;
import we.blog.web.admin.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    /**
     *  登录
     * @param admin
     * @param session
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public BaseResult login(@RequestBody Admin admin, HttpSession session){
        Admin ad = adminService.login(admin);
        if (ad !=null){
            session.setAttribute("admin",ad);
            return BaseResult.success("登录成功","/views/main.html",null);
        }
        return BaseResult.fail("用户名或密码错误");
    }

    /**
     *  退出登录
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public BaseResult logout(HttpServletRequest request){
        request.getSession().removeAttribute("admin");
        return BaseResult.success("退出登录","/views/index.html",null);
    }

    /**
     *  获取信息
     * @param request
     * @return
     */
    @RequestMapping("msg")
    public BaseResult getAdminMsg(HttpServletRequest request){
        Admin admin= (Admin)request.getSession().getAttribute("admin");
        if (admin!=null){
            return BaseResult.success(null,null,admin);
        }
        return BaseResult.fail();
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public BaseResult updateAdmin(Admin admin){
        adminService.update(admin);
        return BaseResult.success("更新成功");//更新成功
    }
}
