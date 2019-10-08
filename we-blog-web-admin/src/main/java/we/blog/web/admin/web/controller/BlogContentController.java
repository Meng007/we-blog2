package we.blog.web.admin.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import we.blog.commons.bean.BaseResult;
import we.blog.commons.bean.PageInfo;
import we.blog.web.admin.dto.BlogContent;
import we.blog.web.admin.service.BlogContentService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/blog")
public class BlogContentController {

    @Autowired
    private BlogContentService blogContentService;

    @RequestMapping(value = "/page")
    public PageInfo<BlogContent> page(HttpServletRequest request ,BlogContent blogContent){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        PageInfo<BlogContent> page = blogContentService.page( start, length,draw, blogContent);

        return page;
    }


    @RequestMapping("/delete")
    public BaseResult deleteMulit(String ids){

        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            blogContentService.deleteMulti(idArray);
            baseResult = BaseResult.success("删除用户成功");
        } else {
            baseResult = BaseResult.fail("删除用户失败");
        }

        return baseResult;
    }
}
