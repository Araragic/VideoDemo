package vw.dao.impl;

import org.springframework.stereotype.Repository;
import vw.bean.Video;
import vw.dao.VideoDao;
import vw.util.ORMUtil;

import java.util.List;

/**
 * Created by like on 2015/2/26.
 */
@Repository
public class VideoDaoImpl extends ORMUtil implements VideoDao {


    @Override
    public List<Video> getVideoList() {
        return openMyBatisSession().selectList("getVideoList");
    }

    @Override
    public void insertVideoInfo(Video video) {
        openHibernateSession().save(video);
    }
}
