package vw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import vw.bean.User;
import vw.dao.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by like on 2015/2/26.
 */
@Controller
@RequestMapping(value="/user/*")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value="show")
    public ModelAndView showUser(){
        ModelAndView mv = new ModelAndView();
        List<User> list = userDao.getUserList();
        mv.addObject("list",list);
        mv.setViewName("user");
        return mv;
    }

    @RequestMapping(value="login")
    public @ResponseBody boolean login(User user){
        //I didn't finish the login process
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userName",user.getUserName());
        map.put("password",user.getPassword());
        boolean flag = userDao.login(map);
        return flag;
    }

    @RequestMapping(value="insert")
    public void insertUser(User user){
         userDao.insertUser(user);
    }
}
