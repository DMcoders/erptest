package com.example.erp01.action;


import com.example.erp01.model.Color;
import com.example.erp01.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ColorController {

    @Autowired
    private ColorService colorService;

    @RequestMapping(value = "/addcolor")
    public String addColor(@RequestParam("colorName")String colorName){
        Color color = new Color(colorName);
        int res = colorService.addColor(color);
        if(0 == res){
            return "添加成功！";
        }else{
            return "添加失败！";
        }
    }

    @RequestMapping(value = "/deletecolor")
    public String deleteColor(@RequestParam("colorID")Integer colorID){
        int res = colorService.deleteColorByID(colorID);
        if(0 == res){
            return "删除成功！";
        }else {
            return "删除失败！";
        }
    }

    @RequestMapping(value = "/getallcolor")
    public List<Color> getAllColor(){
        List<Color> colorList = colorService.getAllColor();
        if (colorList != null){
            return colorList;
        }else{
            return null;
        }
    }

    @RequestMapping(value = "/getcolorbyname")
    public Color getColorByName(@RequestParam("colorName")String colorName){
        Color color = colorService.getColorByName(colorName);
        if (color != null){
            return color;
        }else {
            return null;
        }
    }

    @RequestMapping(value = "getcolorbyid")
    public Color getColorByID(@RequestParam("colorID")Integer colorID){
        Color color = colorService.getColorByID(colorID);
        if (color != null){
            return color;
        }else {
            return null;
        }
    }

}
