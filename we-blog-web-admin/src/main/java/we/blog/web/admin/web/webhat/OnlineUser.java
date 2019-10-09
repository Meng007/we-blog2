package we.blog.web.admin.web.webhat;

import javax.websocket.Session;
import java.util.Objects;

public class OnlineUser {
    private String username;
    private String pic;
    private Session session;

    public OnlineUser() {
    }

    public OnlineUser(String username, String pic, Session session) {
        this.username = username;
        this.pic = pic;
        this.session = session;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OnlineUser that = (OnlineUser) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(pic, that.pic) &&
                Objects.equals(session, that.session);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, pic, session);
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
