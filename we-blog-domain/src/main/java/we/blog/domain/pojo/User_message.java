package we.blog.domain.pojo;

import lombok.Data;

@Data
public class User_message{

   private Integer	um_id; /*'和用户表的id是同一个'*/
   private String	um_name; /*'昵称'*/
   private String	um_sex; /*'用户性别'*/
   private String	um_birthday; /*'用户生日'*/
   private String	um_register_time; /*'用户注册时间'*/
   private String	um_last_time; /*'用户最后登陆时间'*/
   private Integer	um_blogs; /*'博客数'*/
   private Integer	um_integral; /*'用户积分'*/
   private String	um_collect; /*'收藏的博客id'*/
   private String	um_picture; /*'用户头像'*/
   private Integer	um_fans; /*'粉丝数量'*/
   private Integer	um_vip; /*'用户是否为vip,默认是0,vip则是1'*/
   private Integer	um_visit; /*'访问数'*/
   private Integer	is_delete; /*'默认是1，删除后是0'*/
}
