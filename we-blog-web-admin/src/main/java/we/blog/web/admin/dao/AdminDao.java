package we.blog.web.admin.dao;

import org.springframework.stereotype.Repository;
import we.blog.domain.pojo.Admin;

@Repository
public interface AdminDao {
    //通过用户名和密码获取一个用户
    Admin getAdmin(Admin admin);
}
