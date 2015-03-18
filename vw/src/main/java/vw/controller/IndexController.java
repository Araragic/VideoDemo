package vw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vw.bean.Video;
import vw.dao.VideoDao;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by like on 2015/3/3.
 */
@Controller
public class IndexController {

    @Autowired
    private VideoDao videoDao;

    @RequestMapping(value = "index")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        List<Video> videoList = new ArrayList<Video>();

        videoList = videoDao.getVideoList();

        mv.addObject("videoList",videoList);
        mv.setViewName("index");
        return mv;
    }
}

