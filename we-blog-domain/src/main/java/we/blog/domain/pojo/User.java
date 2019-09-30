package we.blog.domain.pojo;

import lombok.Data;

@Data
public class User{

   private Integer	u_id; /*‘用户id’*/
   private String	u_username; /*'用户名'*/
   private String	u_password; /*'用户密码'*/
   private String	u_email; /*'用户邮箱'*/
   private Integer	is_delete; /*'用户默认状态,1显示,0删除'*/
}
