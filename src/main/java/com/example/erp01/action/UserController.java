package com.example.erp01.action;

import com.example.erp01.model.User;
import com.example.erp01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(value ="/userlogin")
    public String userLogin(@RequestParam("userName")String userName,
                            @RequestParam("passWord")String passWord){
        System.out.println("用户名："+userName+"密码："+passWord);
        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWord)){
            return "用户名或密码不能为空！";
        }
        User user = userService.userLogin(userName,passWord);
        if (user != null){
            return "登录成功！";
        }
        System.out.println("登录失败，用户名或密码错误！");
        return "login.html";
        //return "登录失败，用户名或密码错误！";
    }

    @RequestMapping(value ="/adduser")
    public String addUser(@RequestParam("userName")String userName,
                       @RequestParam("passWord")String passWord,
                       @RequestParam("userPhone")String userPhone,
                       @RequestParam("userCardID")String userCardID,
                       String userNote){
        User user = new User(userName,passWord,userPhone,userCardID,userNote);
        int res = userService.addUser(user);
        if (res == 0){
            return "添加成功！";
        }else{
            return "添加失败！";
        }
    }

    @RequestMapping(value = "/getuserbyname")
    public User getUserByName(@RequestParam("userName")String userName){
        User user = userService.getUserByName(userName);
        return user;
    }

    @RequestMapping(value = "/deleteuserbyid")
    public String deleteUserByID(@RequestParam("userID")Integer userID){
        int res = userService.deleteUserByID(userID);
        if (0 == res){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }
    @RequestMapping(value = "/getuserbyid")
    public User getUserByID(@RequestParam("userID")Integer userID){
        User user = userService.getUserByID(userID);
        return user;
    }
    @RequestMapping(value = "/getalluser")
    public List<User> getAllUser(){
        List<User> userList = null;
        userList = userService.getAllUser();
        return userList;
    }
}
