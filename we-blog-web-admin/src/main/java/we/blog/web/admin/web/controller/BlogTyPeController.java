package we.blog.web.admin.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import we.blog.commons.bean.BaseResult;
import we.blog.commons.bean.PageInfo;
import we.blog.domain.pojo.Blogs_function;
import we.blog.web.admin.dto.BlogContent;
import we.blog.web.admin.service.BlogTypeService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/blog/type")
public class BlogTyPeController {

    @Autowired
    private BlogTypeService blogTypeService;


    @RequestMapping("/page")
    public PageInfo<Blogs_function> page(HttpServletRequest request){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);
        PageInfo<Blogs_function> page = blogTypeService.page( start, length,draw);
        return page;
    }

    @RequestMapping("/insert")
    public BaseResult insert(Blogs_function blogs_function){
        try {
            blogTypeService.insert(blogs_function);
        }catch (Exception e){
            return BaseResult.fail();
        }
        return BaseResult.success();
    }

    @RequestMapping("/delete")
    public BaseResult delete(String ids){
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            blogTypeService.deleteMuliit(idArray);
            baseResult = BaseResult.success("删除用户成功");
        } else {
            baseResult = BaseResult.fail("删除用户失败");
        }

        return baseResult;
    }
}
