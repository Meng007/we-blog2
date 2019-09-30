package we.blog.domain.pojo;

import lombok.Data;

@Data
public class Blogs_function{

   private Integer	bf_id; /*'博客类型id'*/
   private String	bf_type; /*'博客类型'*/
   private Integer	is_delete; /*'删除,同上'*/
}
