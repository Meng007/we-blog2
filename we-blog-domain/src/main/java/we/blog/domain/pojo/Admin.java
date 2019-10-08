package we.blog.domain.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Admin implements Serializable {

   private Integer	a_id; /*'管理员id'*/
   private String	a_username; /*'管理员账号'*/
   private String	a_password; /*'管理员密码'*/
   private String	a_pic; /*‘管理员头像’*/
   private String	a_name; /*'管理员昵称'*/
   private Integer	is_delete; /*'默认是1，删除后是0'*/
   private String   email;//邮箱
   private String   introduce;//介绍
}
