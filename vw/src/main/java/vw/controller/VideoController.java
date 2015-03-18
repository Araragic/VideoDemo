package vw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import vw.bean.Video;
import vw.dao.VideoDao;
import vw.util.ConvertFlv;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by like on 2015/2/26.
 */

@Controller
@RequestMapping(value = "/video/*")
public class VideoController {

    private Video video = new Video();

    @Autowired
    private VideoDao videoDao;

    @RequestMapping(value = "show")
    public String showUploadPage() {
        return "video/upload";
    }

    @RequestMapping(value = "uploadVideo")
    public void uploadVideo(MultipartHttpServletRequest request) {
        MultipartFile file = null;
        Iterator<String> ite = request.getFileNames();
        while (ite.hasNext()) {
            file = request.getFile(ite.next());
            video.setVideoSize(file.getSize() / (1024 * 1024) + "MB");
            video.setVideoType(file.getContentType().substring(file.getContentType().lastIndexOf("/")+1));
            try {
                //讲上传文件复制到指定工程文件目录下(copy file to the relative path)
                FileCopyUtils.copy(file.getBytes(), new FileOutputStream(request.getSession().getServletContext().getRealPath("/video/file") + "\\" + file.getOriginalFilename()));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "videoInfo", method = RequestMethod.POST)
    public ModelAndView uploadVideoInfo(Video videoForm, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        /*下面这部分代码就是从上传的视频中截一张封面并且保存到指定的工程文件目录下*/
        ConvertFlv convertFlv = new ConvertFlv();
        //获取上传文件的名称 get the name of file
        String name = videoForm.getVideoTitle().substring(0, videoForm.getVideoTitle().lastIndexOf("."));
        //调用的截图工具的路径 invoke the Screenshots tool
        String realpath = request.getSession().getServletContext().getRealPath("/assets/plugin/ffmpeg");
        //上传的文件所在的路径 get the file
        String inputFilePath = request.getSession().getServletContext().getRealPath("/video/file") + "\\" + videoForm.getVideoTitle();
        //输出截图的路径 output the screenshots
        String coverPath = request.getSession().getServletContext().getRealPath("/video/cover") + "\\" + name + ".jpg";
        boolean flag = convertFlv.processImg(inputFilePath, coverPath, realpath);//执行截图 take the screenshots

        video.setVideoTitle(name);
        video.setVideoIntroduction(videoForm.getVideoIntroduction());
        video.setVideoClassification(videoForm.getVideoClassification());
        video.setVideoLabel(videoForm.getVideoLabel());
        video.setVideoCopyright(videoForm.getVideoCopyright());
        video.setIsPrivate(videoForm.getIsPrivate());

        //当截图生成成功之后才会进行数据提交和页面跳转
        if (flag) {
            videoDao.insertVideoInfo(video);
            mv.setViewName("redirect:/index");
        }
        return mv;
    }

    @RequestMapping( value = "play")
    public ModelAndView play(String videoName){
        ModelAndView mv = new ModelAndView();
        mv.addObject("videoName",videoName);
        mv.setViewName("video/play");
        return mv;
    }
}

