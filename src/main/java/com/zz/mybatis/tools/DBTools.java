package com.zz.mybatis.tools;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DBTools {
    public static SqlSessionFactory sessionFactory;

    static {
        try{
            //MyBatis提供的Resources类加载mybatis配置文件
            Reader reader= Resources.getResourceAsReader("com/zz/mybatis/mybatis.cfg.xml");
            //构建sqlSession 工厂
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //创建映射文件中的sql的sqlSession
    public static SqlSession getSession(){
        return sessionFactory.openSession();
    }
}
