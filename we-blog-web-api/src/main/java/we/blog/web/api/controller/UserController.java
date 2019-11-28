package we.blog.web.api.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import we.blog.domain.pojo.User;
import we.blog.domain.pojo.User_message;
import we.blog.web.api.service.IUserService;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api_user")
public class UserController {
    @Resource
    private IUserService userService;
    @RequestMapping(value = "/login",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer login(String username, String password){
        Integer login = userService.login(username, password);
        return login;
    }
    @RequestMapping(value = "/checkName",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer check(String username){
        Integer count = userService.checkUsername(username);
        if (count>0){
            System.out.println("用户名已存在");
        }
        return count;
    }
    @RequestMapping(value = "/register",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer register(String email,String username,String password){
        User user = new User();
        user.setU_email(email);
        user.setU_username(username);
        user.setU_password(password);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        Integer count = userService.register(user);
        Integer integer = userService.addMessage(user.getU_id(), format);
        return count;
    }
    @RequestMapping(value = "/show",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User_message show(Integer id){
        User_message list = userService.show(id);
        return list;
    }
    @RequestMapping(value = "/attention",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User_message> attention(Integer id){
        List<User_message> list = userService.getAttention(id);
        return list;
    }
    @RequestMapping(value = "/update",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer info(String name,String sex,String nation, String birth,String intro,Integer id){
        Integer count = userService.update(name,sex,nation,birth,intro,id);
        return count;
    }
   /* @RequestMapping(value = "/uploadPic",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer info(MultipartFile file, Integer id){
        StringBuilder builder = new StringBuilder("D:\\1QFstudy\\IdeaProjects\\we-blog2\\we-blog-web-ui\\src\\main\\webapp\\asserts\\images\\");
        String string = LocalDate.now().toString();
        builder.append(string);
        File file1 = new File(builder.toString());
        if (!file1.exists()){
            file1.mkdir();
        }

        String fileName = file.getOriginalFilename();
        StringBuilder fileStr = new StringBuilder(builder.toString());
        fileStr.append(File.separator).append(fileName);


        Integer count = userService.upload(name,sex,nation,birth,intro,id);
        return count;
    }*/
   @RequestMapping(value = "/upload",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
   public Integer upload(Integer id,String path){
       Integer count = userService.picInfo(id,path);
       return count;
   }
    @RequestMapping(value = "/cancel",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer cancel(Integer idm){
        Integer count = userService.cancel(idm);
        return count;
    }

}
