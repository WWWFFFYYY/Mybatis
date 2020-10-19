package com.wfy.test;

import com.wfy.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author jacky
 * @date 2020年 09月02日 15:38:41
 */
public class GetSessionBySessionFactory {

    public static void main(String[] args) throws IOException {

        String resource = "configration.xml";

        Reader reader = Resources.getResourceAsReader(resource);

        //根据配置文件获取一个SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        //根据SessionFactory获取一个session
        SqlSession session = factory.openSession();
        System.out.println(session);
        //创建用户
        User user = new User();
        user.setName("aaaa");
        user.setPassword("1111");
        //插入用户
        session.insert("registerUser",user);
        session.commit();;
        session.close();
    }
}
