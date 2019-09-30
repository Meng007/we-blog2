package we.blog.domain.pojo;

import lombok.Data;

@Data
public class User_attention{

   private Integer	ua_id; /*'关注表id'*/
   private Integer	my_id; /*'关注者id'*/
   private Integer	au_id; /*'被关注的id'*/
   private Integer	is_delete; /*'删除，同上'*/
}
