package com.example.erp01.action;

import com.example.erp01.model.Color;
import com.example.erp01.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ColorController {

    @Autowired
    private ColorService colorService;

    @RequestMapping(value = "addcolor", method = RequestMethod.POST)
    public String addColor(@RequestParam("colorNumber")String colorNumber,
                           @RequestParam("colorName")String colorName,
                           ModelMap map){

        Color color = new Color(colorNumber,colorName);
        int res = colorService.addColor(color);
        if (0 == res){
            map.addAttribute("msg","添加成功！");
        }else {
            map.addAttribute("msg","添加失败！");
        }
        return "index";

    }

    @RequestMapping(value = "deletecolor",method = RequestMethod.POST)
    public String deleteColor(@RequestParam("colorID")Integer colorID,
                              ModelMap map){
        int res = colorService.deleteColor(colorID);
        if (0 == res){
            map.addAttribute("msg","删除成功！");
        }else {
            map.addAttribute("msg","删除失败！");
        }
        return "index";
    }

    @RequestMapping(value = "getallcolor",method = RequestMethod.GET)
    @ResponseBody
    public List<Color> getAllColor(){
        List<Color> colorList = new ArrayList<>();
        colorList = colorService.getAllColor();
        return colorList;
    }


}
