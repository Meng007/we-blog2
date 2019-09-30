package we.blog.domain.pojo;

import lombok.Data;

@Data
public class User_coment{

   private Integer	uc_id; /*'评论id'*/
   private Integer	my_id; /*'评论用户的id'*/
   private String	uc_content; /*'评论内容'*/
   private Integer	is_delete; /*'删除默认是1，删除后是0'*/
}
