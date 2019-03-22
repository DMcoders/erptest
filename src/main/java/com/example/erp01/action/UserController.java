package com.example.erp01.action;

import com.example.erp01.model.User;
import com.example.erp01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(value ="/userlogin", method = RequestMethod.POST)
    public String userLogin(@RequestParam("userName")String userName,
                            @RequestParam("passWord")String passWord,
                            ModelMap map){
        System.out.println("用户名："+userName+"密码："+passWord);
        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWord)){
            map.addAttribute("msg","用户名或密码不能为空！");
            return "redirect:/login";
        }
        User user = userService.userLogin(userName,passWord);
        if (user != null){
            map.addAttribute("msg","登录成功！");
            return "index";
        }else{
            map.addAttribute("msg","登录失败，用户名或密码错误！");
        }
        return "redirect:/login";
        //return "登录失败，用户名或密码错误！";
    }

    @RequestMapping(value ="/adduser", method = RequestMethod.POST)
    public String addUser(@RequestParam("userName")String userName,
                          @RequestParam("passWord")String passWord,
                          @RequestParam("phoneNumber")String phoneNumber,
                          @RequestParam("userCardID")String userCardID,
                          ModelMap map){
        User user = new User(userName,passWord,phoneNumber,userCardID);
        int res = userService.addUser(user);
        if (res == 0){
            map.addAttribute("msg","添加成功！");
        }else{
            map.addAttribute("msg","添加失败！");
        }
        return "index";
    }

    @RequestMapping(value = "/getuserbyname", method = RequestMethod.GET)
    @ResponseBody
    public User getUserByName(@RequestParam("userName")String userName){
        User user = userService.getUserByName(userName);
        return user;
    }

    @RequestMapping(value = "/deleteuser", method = RequestMethod.POST)
    public String deleteUser(@RequestParam("userID")Integer userID, ModelMap map){
        int res = userService.deleteUser(userID);
        if (0 == res){
            map.addAttribute("msg","删除成功!");
        }else{
            map.addAttribute("msg","删除失败!");
        }
        return "index";
    }
    @RequestMapping(value = "/getuserbyid", method = RequestMethod.GET)
    @ResponseBody
    public User getUserByID(@RequestParam("userID")Integer userID){
        User user = userService.getUserByID(userID);
        return user;
    }
    @RequestMapping(value = "/getalluser", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUser(){
        List<User> userList = null;
        userList = userService.getAllUser();
        return userList;
    }


}
