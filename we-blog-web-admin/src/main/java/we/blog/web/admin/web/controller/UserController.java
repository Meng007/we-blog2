package we.blog.web.admin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import we.blog.commons.bean.PageInfo;
import we.blog.domain.pojo.User;
import we.blog.web.admin.service.UserService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 删除用户
     * @param id 用户id
     */
    @RequestMapping(value = "/delete",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void delete(@RequestParam("id") Integer id){

    }

    /**
     * 查询用户
     * @param username 用户名
     */
    @RequestMapping(value = "/find",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void find(@RequestParam("name") String username){

    }

    /**
     * 获取普通所有用户
     */
    @RequestMapping(value = "/getUserPage",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageInfo<User> getUserPage(HttpServletRequest request ,User user){

        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        PageInfo<User> page = userService.page( start, length,draw, user);

        return page;
    }
}
