package we.blog.web.admin.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import we.blog.commons.bean.BaseResult;
import we.blog.commons.bean.PageInfo;
import we.blog.domain.pojo.User;
import we.blog.domain.pojo.User_message;
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

    /**
     * 获取所有vip用户
     */
    @RequestMapping(value = "/getVipUserPage",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageInfo<User> getVipUserPage(HttpServletRequest request ,User user){

        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        PageInfo<User> page = userService.pageVip( start, length,draw, user);

        return page;
    }

    /**
     * 删除用户
     */
    @RequestMapping(value = "/deleteUser")
    public BaseResult deleteUser(String ids){
        BaseResult baseResult = null;
        System.out.println("id:"+ids);
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            userService.deleteUser(idArray);
            baseResult = BaseResult.success("删除用户成功");
        } else {
            baseResult = BaseResult.fail("删除用户失败");
        }
        return baseResult;
    }

    /*获取用户信息*/
    @RequestMapping(value = "/getUserInfo",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User_message getUserInfo(String id){
        return userService.getUserInfo(id);
    }

    /*根据id获取用户*/
    @RequestMapping(value = "/getUserById",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User getUserById(String id){
        return userService.getUserById(id);
    }

    /*修改用户*/
    @RequestMapping(value = "/updateUser",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer updateUser(User user){
        System.out.println("接收到的数据："+user);
        return userService.updateUser(user);
    }

}
