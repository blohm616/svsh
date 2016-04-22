package xiezhy.dao.impl;

import org.springframework.stereotype.Repository;
import xiezhy.basic.dao.impl.DaoSupportImpl;
import xiezhy.dao.UserDao;
import xiezhy.entity.User;

/**
 * version:
 * --------------------
 * date:2016/4/21
 * author:binbin
 */
@Repository("userDao")
public class UserDaoImpl extends DaoSupportImpl<User> implements UserDao {
}
