package we.blog.web.admin.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BlogContent {
    private Integer  bid;
    private String  bName;
    private String  title;
    private String  type;
    private Date update;
}
