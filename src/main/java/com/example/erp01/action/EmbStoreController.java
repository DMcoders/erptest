package com.example.erp01.action;

import com.example.erp01.model.EmbStore;
import com.example.erp01.service.EmbStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmbStoreController {

    @Autowired
    private EmbStoreService embStoreService;

    @RequestMapping("/embInStoreStart")
    public String embInStoreStart(Model model) {
        model.addAttribute("bigMenuTag",3);
        model.addAttribute("menuTag",1);
        return "embMarket/embInStore";
    }

    @RequestMapping(value = "/addembstore", method = RequestMethod.POST)
    public String addEmbStore(@RequestParam("embStoreLocation")String embStoreLocation,
                              @RequestParam("embStoreQcode")String embStoreQcode,
                              @RequestParam("embStoreCount")Integer embStoreCount,
                              ModelMap map
                              ){
        EmbStore embStore = new EmbStore(embStoreLocation,embStoreQcode,embStoreCount);
        int res = embStoreService.addEmbStore(embStore);
        if (0 == res){
            map.addAttribute("msg","添加成功！");
        }else{
            map.addAttribute("msg","添加失败！");
        }
        return "index";
    }

    @RequestMapping(value = "deleteembstore", method = RequestMethod.POST)
    public String deleteEmbStore(@RequestParam("embStoreID")Integer embStoreID,
                                 ModelMap map){
        int res = embStoreService.deleteEmbStore(embStoreID);
        if(0 == res){
            map.addAttribute("msg","删除成功！");
        }else{
            map.addAttribute("msg","删除失败！");
        }
        return "index";
    }

    @RequestMapping(value = "updateembstore", method = RequestMethod.POST)
    public String updateEmbStore(@RequestParam("embStoreID")Integer embStoreID,
                                 @RequestParam("embStoreLocation")String embStoreLocation,
                                 @RequestParam("embStoreQcode")String embStoreQcode,
                                 @RequestParam("embStoreCount")Integer embStoreCount,
                                 ModelMap map){
        EmbStore embStore = new EmbStore(embStoreID,embStoreLocation,embStoreQcode,embStoreCount);
        int res = embStoreService.updateEmbStore(embStore);
        if(0 == res){
            map.addAttribute("msg","更新成功！");
        }else {
            map.addAttribute("msg","更新失败！");
        }
        return "index";
    }

    @RequestMapping(value = "getallembstore", method = RequestMethod.GET)
    @ResponseBody
    public List<EmbStore> getAllEmbStore(){
        List<EmbStore> embStoreList = new ArrayList<>();
        embStoreList = embStoreService.getAllEmbStore();
        return embStoreList;
    }

}
