package we.blog.commons.bean;

import java.io.Serializable;

/**
 * 自定义返回结果
 * <p>Title: BaseResult</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/6/19 14:31
 */
public class BaseResult implements Serializable {
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAIL = 500;

    private int status;
    private String url;
    private String message;
    private Object data;

    public static BaseResult success() {
        return BaseResult.createResult(STATUS_SUCCESS, "成功", null,null);
    }

    public static BaseResult success(String message) {
        return BaseResult.createResult(STATUS_SUCCESS, message, null,null);
    }

    public static BaseResult success(String message,String url,Object data) {
        return BaseResult.createResult(STATUS_SUCCESS, message,url, data);
    }

    public static BaseResult fail() {
        return BaseResult.createResult(STATUS_FAIL, "失败", null,null);
    }

    public static BaseResult fail(String message) {
        return BaseResult.createResult(STATUS_FAIL, message, null,null);
    }

    public static BaseResult fail(int status, String message) {
        return BaseResult.createResult(status, message, null,null);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private static BaseResult createResult(int status, String message,String url, Object data) {
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        baseResult.setData(data);
        baseResult.setUrl(url);
        return baseResult;
    }
}
