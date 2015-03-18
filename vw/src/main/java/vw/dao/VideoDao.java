package vw.dao;

import vw.bean.Video;

import java.util.List;

/**
 * Created by like on 2015/2/26.
 */
public interface VideoDao {

    public List<Video> getVideoList();

    public void insertVideoInfo(Video video);
}
