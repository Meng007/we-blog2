package we.blog.domain.pojo;

import lombok.Data;

@Data
public class User_load{

   private Integer	ul_id; /*'下载id'*/
   private Integer	my_id; /*'下载用户的id'*/
   private Integer	ul_count; /*'下载次数,默认是0'*/
   private String	ul_time; /*'上传的时间'*/
   private Integer	is_delete; /*'删除，同上'*/
}
