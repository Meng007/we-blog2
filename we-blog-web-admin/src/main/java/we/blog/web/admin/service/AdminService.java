package we.blog.web.admin.service;

import we.blog.domain.pojo.Admin;

public interface AdminService {
    //管理员登录
    Admin login(Admin admin);
    //更新
    void update(Admin admin);
}
