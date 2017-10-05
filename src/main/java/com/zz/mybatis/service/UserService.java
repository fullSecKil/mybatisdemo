package com.zz.mybatis.service;

import com.zz.mybatis.beans.UserBean;
import com.zz.mybatis.mapper.UserMapper;
import com.zz.mybatis.tools.DBTools;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

public class UserService {
    @Test
    public void insertUser() throws Exception{
        SqlSession session = DBTools.getSession();
        UserMapper mapper =session.getMapper(UserMapper.class);
        UserBean userBean = new UserBean("coffce","12331",701.0);
        try {
            mapper.insertUser(userBean);
            System.out.println(userBean.toString());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
    @Test
    public void selectAllUser() throws Exception {
        SqlSession session=DBTools.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
            UserBean user=mapper.selectUserById(2);
            System.out.println(user.toString());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
    @Test
    public void timeAfter(){
        Timestamp ts1 = Timestamp.valueOf("2012-04-06 09:01:10");
        Timestamp ts2 = Timestamp.valueOf("2012-04-06 09:02:10");
        Timestamp ts3 = new Timestamp(System.currentTimeMillis());
        System.out.println(ts3);
        System.out.println(ts3);
        Timestamp ts4 = Timestamp.valueOf(DateFormatUtils.format(new Timestamp(System.currentTimeMillis()), "yyyy-MM-dd 00:00:00"));
        System.out.println(ts4);
        System.out.println(ts4.before(ts1));
    }
}
