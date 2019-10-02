package we.blog.web.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import we.blog.domain.pojo.Admin;
import we.blog.web.admin.dao.AdminDao;
import we.blog.web.admin.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    /**
     *  管理员登录
     * @param admin
     * @return
     */
    @Override
    public Admin login(Admin admin) {
        return  adminDao.getAdmin(admin);
    }
}
