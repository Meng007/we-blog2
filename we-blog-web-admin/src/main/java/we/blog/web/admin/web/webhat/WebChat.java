package we.blog.web.admin.web.webhat;

import we.blog.domain.pojo.Admin;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/web/server/{user}",configurator = HttpSessionConfigurator.class)
public class WebChat {

    public static Integer getOlineCount() {
        return olineCount;
    }

    public static void setOlineCount(Integer olineCount) {
        WebChat.olineCount = olineCount;
    }

    public static Map<String, Object> getOnlineUser() {
        return onlineUser;
    }

    public static void setOnlineUser(Map<String, Object> onlineUser) {
        WebChat.onlineUser = onlineUser;
    }

    private static Integer olineCount=0;//在线人数
    private static Map<String,Object> onlineUser = new ConcurrentHashMap<String,Object>();

    @OnOpen
    public void onOpen(@PathParam("user") String user , Session session, EndpointConfig config){
        WebChat.olineCount++;//人数加一
        // 获取当前用户的session
        HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        // 获得当前用户信息
        Admin admin  = (Admin) httpSession.getAttribute("admin");

        //
        OnlineAdmin onlineAdmin = new OnlineAdmin(admin.getA_name(), admin.getA_pic(), session);
        //onlineUser.put()

    }
}
