package vw.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;

import javax.annotation.Resource;

/**
 * Created by like on 2015/2/26.
 */
public class ORMUtil {

    protected ORMUtil() {
    }

    /** hibernate实例*/
    @Resource(name = "sessionFactory" )
    private SessionFactory sessionFactory;

    protected Session openHibernateSession(){
        return sessionFactory.openSession();
    }

    protected Session getHibernateCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    protected StatelessSession getHibernateStatelessSession(){
        return sessionFactory.openStatelessSession();
    }

    /** MyBatis实例*/
    @Resource(name="sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;

    protected SqlSession openMyBatisSession(){
        return sqlSessionFactory.openSession();
    }
}
