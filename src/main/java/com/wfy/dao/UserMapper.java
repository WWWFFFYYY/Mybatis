package com.wfy.dao;

import com.wfy.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    User getLoginUser(User user);

    void registerUser(User user);

    void updateUser(User user);


    void deleteUser(User user);

    List<User> getUserList();

    //测试动态sql
    List<User> queryUserByName(@Param("name") String name);

    List<User> queryAllUserNameAndAge(User user);

    List<User> queryAllUserByOr(User user);

    List<User> queryAllUserByName(String name);

    int addUserBackById(User user);  //执行后返回值

    void addUserBeforeById(User user); //执行前返回值

    List<User> getAllUserList(User user);  //组合查询获取列表

    List<User> getAllUserList2(User user);

    void updateUser2(User user);

}
