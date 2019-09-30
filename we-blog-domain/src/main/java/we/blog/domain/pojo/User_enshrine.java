package we.blog.domain.pojo;

import lombok.Data;

@Data
public class User_enshrine{

   private Integer	ue_id; /*'收藏表id'*/
   private Integer	my_id; /*'收藏者id'*/
   private Integer	c_id; /*'收藏的人的博客id'*/
   private Integer	is_delete; /*'删除，同上'*/
}
