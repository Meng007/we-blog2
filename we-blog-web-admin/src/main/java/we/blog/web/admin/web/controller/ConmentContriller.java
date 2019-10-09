package we.blog.web.admin.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import we.blog.commons.bean.BaseResult;
import we.blog.commons.bean.PageInfo;
import we.blog.domain.pojo.User_coment;
import we.blog.web.admin.service.ComentService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/coment")
public class ConmentContriller {
    @Autowired
    private ComentService comentService;

    @RequestMapping(value = "/deletes",method = RequestMethod.GET)
    public BaseResult delete (String ids){
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            comentService.delete(idArray);
            baseResult = BaseResult.success("删除用户成功");
        } else {
            baseResult = BaseResult.fail("删除用户失败");
        }

        return baseResult;
    }

    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public PageInfo<User_coment> page (HttpServletRequest request,User_coment user_coment){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        PageInfo<User_coment> page = comentService.page( start, length,draw, user_coment);

        return page;
    }
}
