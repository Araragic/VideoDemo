package vw.dao.impl;

import org.springframework.stereotype.Repository;
import vw.bean.User;
import vw.dao.UserDao;
import vw.util.ORMUtil;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by like on 2015/2/26.
 */
@Repository
public class UserDaoImpl extends ORMUtil implements UserDao {

    @Override
    public boolean login(Map<String,Object> map) {
        User user = openMyBatisSession().selectOne("login",map);
        if(user != null){
            return true;
        }
        return false;
    }

    @Override
    public void insertUser(User user) {
       openHibernateSession().save(user);
    }

    @Override
    public List<User> getUserList() {
        return openMyBatisSession().selectList("getUserList");
    }
}
