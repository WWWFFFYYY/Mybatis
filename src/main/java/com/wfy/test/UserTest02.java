package com.wfy.test;

import com.wfy.dao.UserMapper;
import com.wfy.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")

public class UserTest02 {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    UserMapper userMapper = null;

    SqlSession sqlSession =  null;

    @Before  //@Test运行前加载
    public void before(){
        sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @After  //@Test运行后加载
    public void after(){
        sqlSession.close();
    }

    @Test
    public void testUserLogin(){
        User user = new User();
        user.setUserId(1);
        user.setName("admin");
        user.setPassword("111");
        User loginUser = userMapper.getLoginUser(user);
        System.out.println(loginUser);
    }

    @Test
    public void testQueryUserList(){
        List<User> userList = userMapper.queryUserByName("");
        for(User u : userList){
            System.out.println(u);
        }
    }

    @Test
    public void queryAllUserNameAndAge(){
        User user = new User();
        user.setName("admin");
        user.setAge(0);
        List<User> userList = userMapper.queryAllUserNameAndAge(user);
        for(User u : userList){
            System.out.println(u);
        }
    }

    @Test
    public void queryAllUserByOr(){
        User user = new User();
        user.setName("admin");
        user.setAge(100);
        List<User> userList = userMapper.queryAllUserByOr(user);
        for(User u : userList){
            System.out.println(u);
        }
    }

    @Test
    public void queryByLike(){
        List<User> userList = userMapper.queryAllUserByName("a");
        for(User u : userList){
            System.out.println(u);
        }
    }

    @Test
    public void addUserBackById(){
        User user = new User();
        user.setUserId(100);
        user.setName("haha");
        user.setPassword("123456");
        user.setAge(25);
        int row = userMapper.addUserBackById(user);
        System.out.println("------插入行数："+row+"------");
    }

    @Test
    public void addUserBeforeById(){
        User user = new User();
        user.setName("李四");
        user.setPassword("123456");
        user.setAge(25);
        userMapper.addUserBeforeById(user);
    }
}
