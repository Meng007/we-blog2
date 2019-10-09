package we.blog.web.admin.web.webhat;

public class Message {
    //类型
    public static final String DZ = "dz";//点赞
    public static final String PL = "pl";//评论
    public static final String GZ = "gz";//关注
    public static final String SC = "sc";//收藏

    private String type;//类型
    private String msg;//信息

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Message(String type, String msg) {
        this.type = type;
        this.msg = msg;
    }
}
