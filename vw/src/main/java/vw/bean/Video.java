package vw.bean;

import javax.persistence.*;

/**
 * Created by like on 2015/2/26.
 */
@Entity(name = "tb_video")
public class Video {

    private int id;
    private String videoTitle;//视频标题
    private String videoSize;//视频大小
    private String videoType;//视频后缀
    private String videoIntroduction;//简介
    private String videoClassification;//分类
    private String videoLabel;//标签
    private String videoCopyright;//版权
    private String isPrivate;//公开或隐私

    public Video() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "t_videotitle")
    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    @Column(name = "t_videosize")
    public String getVideoSize() {
        return videoSize;
    }

    public void setVideoSize(String videoSize) {
        this.videoSize = videoSize;
    }

    @Column(name = "t_videotype")
    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    @Column(name = "t_videointro")
    public String getVideoIntroduction() {
        return videoIntroduction;
    }

    public void setVideoIntroduction(String videoIntroduction) {
        this.videoIntroduction = videoIntroduction;
    }

    @Column(name = "t_videoclassification")
    public String getVideoClassification() {
        return videoClassification;
    }

    public void setVideoClassification(String videoClassification) {
        this.videoClassification = videoClassification;
    }

    @Column(name = "t_videolabel")
    public String getVideoLabel() {
        return videoLabel;
    }

    public void setVideoLabel(String videoLabel) {
        this.videoLabel = videoLabel;
    }

    @Column(name = "t_videocopyright")
    public String getVideoCopyright() {
        return videoCopyright;
    }

    public void setVideoCopyright(String videoCopyright) {
        this.videoCopyright = videoCopyright;
    }

    @Column(name = "t_isprivate")
    public String getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(String isPrivate) {
        this.isPrivate = isPrivate;
    }

}
