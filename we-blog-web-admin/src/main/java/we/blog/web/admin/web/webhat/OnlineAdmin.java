package we.blog.web.admin.web.webhat;

import javax.websocket.Session;

public class OnlineAdmin {
    private String username;
    private String pic;
    private Session session;

    public OnlineAdmin() {
    }

    public OnlineAdmin(String username, String pic, Session session) {
        this.username = username;
        this.pic = pic;
        this.session = session;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
