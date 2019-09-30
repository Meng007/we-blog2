package we.blog.domain.pojo;

import lombok.Data;

@Data
public class Blog_message{

   private Integer	bm_id; /*'博客id'*/
   private Integer	bm_u_id; /*'和用户id是同一个'*/
   private Integer	bm_goods; /*'点赞数'*/
   private String	bm_title; /*'博客标题'*/
   private String	bm_content; /*'博客内容'*/
   private Integer	bm_read; /*'博客阅读量'*/
   private Integer	bm_comment; /*'评论数'*/
   private String	bm_time; /*'博客创建时间‘*/
   private String	bm_type; /*'博客类型'*/
   private Integer	is_delete; /*'删除默认是1，删除后是0'*/
}
