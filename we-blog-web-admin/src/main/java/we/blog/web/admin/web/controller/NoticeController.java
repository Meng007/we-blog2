package we.blog.web.admin.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import we.blog.commons.bean.BaseResult;
import we.blog.commons.bean.PageInfo;
import we.blog.domain.pojo.Notice;
import we.blog.web.admin.service.NoticeService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    //删除
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    private BaseResult delete(String ids){
        BaseResult baseResult=null;
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            noticeService.delete(idArray);
            baseResult = BaseResult.success("删除用户成功");
        } else {
            baseResult = BaseResult.fail("删除用户失败");
        }
        return baseResult;
    }
    @RequestMapping ("/page")
    public PageInfo<Notice> page(HttpServletRequest request,Notice notice){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);
        PageInfo<Notice> page = noticeService.select( start, length,draw,notice);
        return page;
    }
    //添加
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public BaseResult save(@RequestBody Notice notice){
        Integer i = noticeService.insert(notice);
        if (i>0){
            return BaseResult.success("添加成功");
        }
        return BaseResult.fail("添加失败");
    }
}
