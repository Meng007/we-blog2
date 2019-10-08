package we.blog.domain.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Notice {
    private Integer nid;
    private String title;
    private String pic;
    private Date ntime;
    private String content;
}
