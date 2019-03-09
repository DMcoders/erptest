package com.example.erp01.service;

import com.example.erp01.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    int addUser(User user);

    User userLogin(String userName,String passWord);

    User getUserByName(String userName);

    int deleteUserByID(Integer id);

    List<User> getAllUser();

    User getUserByID(Integer id);

}
