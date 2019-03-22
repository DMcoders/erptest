package com.example.erp01.action;

import com.example.erp01.model.Size;
import com.example.erp01.service.SizeService;
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
public class SizeController {

    @Autowired
    private SizeService sizeService;

    @RequestMapping(value = "/addsize", method = RequestMethod.POST)
    public String addSize(@RequestParam("sizeName")String sizeName,
                          ModelMap map){
        Size size = new Size(sizeName);
        int res = sizeService.addSize(size);
        if (0 == res){
            map.addAttribute("msg","添加成功！");
        }else {
            map.addAttribute("msg","添加失败！");
        }
        return "index";
    }


    @RequestMapping(value = "/deletesize", method = RequestMethod.POST)
    public String deleteSize(@RequestParam("sizeID")Integer sizeID,
                             ModelMap map){
        int res = sizeService.deleteSize(sizeID);
        if(0 == res){
            map.addAttribute("msg","删除成功！");
        }else {
            map.addAttribute("msg","删除失败！");
        }
        return "index";
    }

    @RequestMapping(value = "/getallsize", method = RequestMethod.GET)
    @ResponseBody
    public List<Size> getAllSize(){
        List<Size> sizeList = new ArrayList<>();
        sizeList = sizeService.getAllSize();
        return sizeList;
    }

}
