package com.example.erp01.mapper;

import com.example.erp01.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    int addUser(User user);

    int deleteUser(Integer userID);

    List<User> getAllUser();

    User getUserByID(Integer id);

    User userLogin(String userName,String passWord);

    User getUserByName(String userName);

}
