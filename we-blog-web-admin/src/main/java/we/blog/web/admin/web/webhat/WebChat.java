package we.blog.web.admin.web.webhat;

import net.sf.json.JSONObject;
import org.apache.commons.collections.CollectionUtils;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/web/server/{user}"/*,configurator = HttpSessionConfigurator.class*/)
public class WebChat {


    private static Integer olineCount=0;//在线人数
    private static Map<String,OnlineUser> onlineUser = new ConcurrentHashMap<String,OnlineUser>();

    @OnOpen
    public void onOpen(@PathParam("user") String user , Session session/*, EndpointConfig config*/){
        if (!WebChat.onlineUser.containsKey(user)){
            WebChat.olineCount++;//人数加一
            System.out.println(user+ WebChat.olineCount);
            WebChat.onlineUser.put(user,new OnlineUser(null,null,session));
        }

    }
    @OnMessage
    public void onMessage(@PathParam("user")String user,String data){

        JSONObject json = JSONObject.fromObject(data);
        String msg = json.optString("msg");
        String type = json.optString("type");
        String to = json.optString("to");
        System.out.println(msg+"--"+type+"--"+to);
        OnlineUser u = WebChat.onlineUser.get(user);

        switch (type){
            case "dz":dz(user,to);
            break;
            case "pl":pl(user,to);
            break;
            case "sc":sc(user,to);
            break;
            case "gz":gz(user,to);
            break;
            case "lt":lt(user,to,msg);
            break;
            case "gg":gg(user,to,msg);
            break;
        }


    }
    private void gg(String user,String to,String msg){
        OnlineUser toUser = WebChat.onlineUser.get(user);
        Collection<OnlineUser> list = WebChat.onlineUser.values();
        if (CollectionUtils.isNotEmpty(list)){
            for (OnlineUser onuser:list){
                if (toUser.equals(onuser)){
                    continue;
                }
                try {
                    JSONObject json = JSONObject.fromObject(new Message("lt", msg));
                    onuser.getSession().getBasicRemote().sendText(json.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void lt(String user,String to,String msg){
        OnlineUser toUser = WebChat.onlineUser.get(to);
        if (toUser!=null){
            try {
                JSONObject json = JSONObject.fromObject(new Message("lt", msg));
                toUser.getSession().getBasicRemote().sendText(json.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void dz(String user,String to) {
        OnlineUser toUser = WebChat.onlineUser.get(user);
        if (toUser!=null){
            try {
                JSONObject json = JSONObject.fromObject(new Message("dz", "点赞"));
                toUser.getSession().getBasicRemote().sendText(json.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void pl(String user,String to) {
        OnlineUser toUser = WebChat.onlineUser.get(to);
        if (toUser!=null){
            try {
                JSONObject json = JSONObject.fromObject(new Message("pl", "评论"));
                toUser.getSession().getBasicRemote().sendText(json.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void sc(String user,String to) {
        OnlineUser toUser = WebChat.onlineUser.get(to);
        if (toUser!=null){
            try {
                JSONObject json = JSONObject.fromObject(new Message("sc", "收藏"));
                toUser.getSession().getBasicRemote().sendText(json.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void gz(String user,String to) {
        OnlineUser toUser = WebChat.onlineUser.get(to);
        if (toUser!=null){
            try {
                JSONObject json = JSONObject.fromObject(new Message("gz", "关注"));
                toUser.getSession().getBasicRemote().sendText(json.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @OnClose
    public void onClose(@PathParam("user")String user){
        //移除
        WebChat.onlineUser.remove(user);
        WebChat.olineCount--;
        System.out.println("断开连接");
    }

    public void onError(){
        System.out.println("发生错误");
    }

    public static Integer getOlineCount() {
        return olineCount;
    }

    public static void setOlineCount(Integer olineCount) {
        WebChat.olineCount = olineCount;
    }

    public static Map<String, OnlineUser> getOnlineUser() {
        return onlineUser;
    }

    public static void setOnlineUser(Map<String, OnlineUser> onlineUser) {
        WebChat.onlineUser = onlineUser;
    }

}
