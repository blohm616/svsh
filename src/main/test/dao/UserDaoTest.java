package dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xiezhy.dao.UserDao;
import xiezhy.entity.User;

/**
 * version:
 * --------------------
 * date:2016/4/21
 * author:binbin
 */
public class UserDaoTest {
    @Test
    public void userDaoTest() {

        ApplicationContext act = new ClassPathXmlApplicationContext("spring.xml");
        UserDao userDao = (UserDao) act.getBean("userDao");
        User user = new User();
        userDao.save(user);
    }
}
