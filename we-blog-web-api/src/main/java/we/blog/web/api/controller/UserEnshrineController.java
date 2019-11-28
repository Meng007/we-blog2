package we.blog.web.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import we.blog.commons.utils.HttpClientUtils;
import we.blog.domain.pojo.User_enshrine;
import we.blog.web.api.mapper.UserEnshrineMapper;
import we.blog.web.api.service.Impl.UserEnshrineService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/UserEnshrineController")
public class UserEnshrineController {
@Resource
private UserEnshrineService userEnshrineService;

@RequestMapping(value = "/querryAll",method = {RequestMethod.POST, RequestMethod.GET} )
    public List<User_enshrine> querry(Integer myId){
    List<User_enshrine> list = null;
    try {
        list = userEnshrineService.querryAll(myId);
    } catch (Exception e) {
        System.out.println(e);
        return null;
    }
    return list;
    }

    @RequestMapping("/cancel")
    public String cancelColl( Integer cId){
        Integer row = null;
        String simple= null;

        try {

            row = userEnshrineService.cancelCollection(cId);
        } catch (Exception e) {
            return null;
        }
        if(row != null){
            simple="simple";
        }
        return simple;

    }
}
