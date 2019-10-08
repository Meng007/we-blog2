package we.blog.web.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import we.blog.domain.pojo.User;
import we.blog.web.admin.dao.UserDao;
import we.blog.web.admin.service.UserService;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserTest {
    @Autowired
    private UserService userService;

    private InputStream in;
    private SqlSession sqlSession;
    private UserDao mapper;

    @Before //测试方法执行之前执行
    public void init() throws IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("mybatis-cfg.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产一个SqlSession对象
        sqlSession = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        mapper = sqlSession.getMapper(UserDao.class);
    }


    @After //测试方法执行之后执行
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void getUserList(){
        User user = new User();
        user.setU_username("zs");
        user.setU_password("123");
        List<User> list = mapper.getUserList();
        System.out.println(list);
    }

    @Test
    public void findUser(){
        User zs = mapper.findUser("zs");
        System.out.println(zs);
    }

    @Test
    public void deleteUser(){
        Integer integer = mapper.deleteUser(3);
        System.out.println(integer);
    }

    @Test
    public void page(){
        int count = mapper.count();
        User user=new User();
        int start=0;
        int length=5;

        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("pageParams", user);
        List<User> page = mapper.page(params);

        System.out.println(page);
    }
}
