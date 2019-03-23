package com.example.erp01.action;

import com.example.erp01.model.User;
import com.example.erp01.service.UserService;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(value ="/userlogin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> userLogin(@RequestParam("userName")String userName,
                                        @RequestParam("passWord")String passWord){
        System.out.println("用户名："+userName+"密码："+passWord);
        Map<String,Object> result = new HashMap<String,Object>();
        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWord)){
            result.put("flag",false);
            result.put("msg","用户名或密码不能为空！");
        }
        User user = userService.userLogin(userName,passWord);
        if (user != null){
            result.put("flag","true");
            result.put("msg","登录成功！");
        }else{
            result.put("msg","登录失败，用户名或密码错误！");
            result.put("flag",false);
        }
        return result;
    }

    @RequestMapping(value ="/homepage")
    public String getHomePageStart(Model model) {
        model.addAttribute("bigMenuTag",0);
        model.addAttribute("menuTag",0);
        return "homepage/homepage";
    }


    @RequestMapping(value ="/adduser", method = RequestMethod.POST)
    public String addUser(@RequestParam("userJson")String userJson,
                          ModelMap map){
        JsonParser jsonParser = new JsonParser();
        try{
            JsonObject json = (JsonObject) jsonParser.parse(userJson);
            String userName = json.get("userName").getAsString();
            String passWord = json.get("passWord").getAsString();
            String role = json.get("role").getAsString();
            String phoneNumber = json.get("phoneNumber").getAsString();
            String userCardID = json.get("userCardID").getAsString();
            User user = new User(userName,passWord,role,phoneNumber,userCardID);
            int res = userService.addUser(user);
            if (res == 0){
                map.addAttribute("msg","添加成功！");
            }else{
                map.addAttribute("msg","添加失败！");
            }
        }catch (JsonIOException e){
            e.printStackTrace();
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }
        return "index";
    }



//    @RequestMapping(value ="/adduser", method = RequestMethod.POST)
//    public String addUser(@RequestParam("userName")String userName,
//                          @RequestParam("passWord")String passWord,
//                          @RequestParam("phoneNumber")String phoneNumber,
//                          @RequestParam("userCardID")String userCardID,
//                          ModelMap map){
//        User user = new User(userName,passWord,phoneNumber,userCardID);
//        int res = userService.addUser(user);
//        if (res == 0){
//            map.addAttribute("msg","添加成功！");
//        }else{
//            map.addAttribute("msg","添加失败！");
//        }
//        return "index";
//    }

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
