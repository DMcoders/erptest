package com.example.erp01.action;

import com.example.erp01.model.EmbStore;
import com.example.erp01.service.EmbStoreService;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
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

//衣胚仓库相关操作，仓库信息维护，增加衣胚仓库，删除衣胚仓库，衣胚仓库信息维护

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
    public String addEmbStore(@RequestParam("embStoreJson")String embStoreJson,
                              ModelMap map
                              ){
        JsonParser jsonParser = new JsonParser();
        try{
            JsonObject json = (JsonObject) jsonParser.parse(embStoreJson);
            String embStoreLocation = json.get("embStoreLocation").getAsString();
            Integer embStoreCount = json.get("embStoreCount").getAsInt();
            String embStoreQcode = json.get("embStoreQcode").getAsString();
            EmbStore embStore = new EmbStore(embStoreLocation,embStoreQcode,embStoreCount);
            int res = embStoreService.addEmbStore(embStore);
            if (0 == res){
                map.addAttribute("msg","添加成功！");
            }else{
                map.addAttribute("msg","添加失败！");
            }
            return "index";
        }catch (JsonIOException e){
            e.printStackTrace();
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }
        return "index";
    }


//    @RequestMapping(value = "/addembstore", method = RequestMethod.POST)
//    public String addEmbStore(@RequestParam("embStoreLocation")String embStoreLocation,
//                              @RequestParam("embStoreQcode")String embStoreQcode,
//                              @RequestParam("embStoreCount")Integer embStoreCount,
//                              ModelMap map
//    ){
//        EmbStore embStore = new EmbStore(embStoreLocation,embStoreQcode,embStoreCount);
//        int res = embStoreService.addEmbStore(embStore);
//        if (0 == res){
//            map.addAttribute("msg","添加成功！");
//        }else{
//            map.addAttribute("msg","添加失败！");
//        }
//        return "index";
//    }


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
