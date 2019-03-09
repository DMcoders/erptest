package com.example.erp01.action;

import com.example.erp01.model.Tailor;
import com.example.erp01.service.TailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class TailorController {

    @Autowired
    private TailorService tailorService;

    @RequestMapping(value = "/generatetailordata")
    public String generateTailorDta(@RequestParam Map<String,Object> tailorInfo){
        List<Map<Integer, Tailor>> tailorList = null;
        if(tailorInfo == null){
            return "信息不能为空！";
        }
        tailorList = tailorService.generateTailorData(tailorInfo);
        return tailorList.toString();
    }
}
