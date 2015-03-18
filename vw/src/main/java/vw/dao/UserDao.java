package vw.dao;

import vw.bean.User;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by like on 2015/2/26.
 */
public interface UserDao {
    public boolean login(Map<String,Object> map);

    public void insertUser(User user);

    public List<User> getUserList();

}
