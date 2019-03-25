package com.example.erp01.action;

import com.example.erp01.model.EmbStore;
import com.example.erp01.model.StoreHouse;
import com.example.erp01.service.StoreHouseService;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import org.apache.ibatis.session.ResultContext;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//裁片仓库基本操作，添加删除等

@Controller
public class StoreHouseController {

    @Autowired
    private StoreHouseService storeHouseService;

    @RequestMapping(value = "/addstorehouse", method = RequestMethod.POST)
    public String addStoreHouse(@RequestParam("storeHouseJson")String storeHouseJson,
                                ModelMap map){


        JsonParser jsonParser = new JsonParser();
        try{
            JsonObject json = (JsonObject) jsonParser.parse(storeHouseJson);
            String storeHouseLocation = json.get("storeHouseLocation").getAsString();
            String storeHouseQcode = json.get("storeHouseQcode").getAsString();
            Integer storeHouseCount = json.get("storeHouseCount").getAsInt();
            StoreHouse storeHouse = new StoreHouse(storeHouseLocation,storeHouseQcode,storeHouseCount);
            int res = storeHouseService.addStoreHouse(storeHouse);
            if(0 == res){
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
    @RequestMapping(value = "/deletestorehouse", method = RequestMethod.POST)
    public String deleteStoreHouse(@RequestParam("storehouseID")Integer storehouseID,
                                ModelMap map){

        int res = storeHouseService.deleteStoreHouse(storehouseID);
        if(0 == res){
            map.addAttribute("msg","删除成功！");
        }else{
            map.addAttribute("msg","删除失败！");
        }
        return "index";
    }

    @RequestMapping(value = "/updatestorehouse",method = RequestMethod.POST)
    public String updateStoreHouse(@RequestParam("storehouseID")Integer storehouseID,
                                   @RequestParam("storehouseLocation")String storehouseLocation,
                                   @RequestParam("storehouseQcode")String storehouseQcode,
                                   @RequestParam("storehouseCount")Integer storehouseCount,
                                   ModelMap map
                                   ){
        StoreHouse storeHouse = new StoreHouse(storehouseID,storehouseLocation,storehouseQcode,storehouseCount);
        int res = storeHouseService.updateStoreHouse(storeHouse);
        if (0 == res){
            map.addAttribute("msg","修改成功！");
        }else {
            map.addAttribute("msg","修改失败！");
        }
        return "index";

    }

    @RequestMapping(value = "/getallstorehouse", method = RequestMethod.GET)
    @ResponseBody
    public List<StoreHouse> getAllStoreHouse(){
        List<StoreHouse> storeHouseList = storeHouseService.getAllStoreHouse();
        return storeHouseList;
    }



    @RequestMapping(value = "/getstorehousebyqcode", method = RequestMethod.GET)
    @ResponseBody
    public StoreHouse getStoreHouseByQcode(@RequestParam("storehouseQcode")String storehouseQcode){
        StoreHouse storeHouse = storeHouseService.getStoreHouseByQcode(storehouseQcode);
        return storeHouse;
    }

//    @RequestMapping(value = "/changestorage", method = RequestMethod.POST)
//    public String changeStorage(@RequestParam("storehouseQcode")String storehouseQcode,
//                                @RequestParam("number")Integer number,
//                                ModelMap map){
//        int res = storeHouseService.changeStorge(storehouseQcode,number);
//        if(0 == res){
//            map.addAttribute("msg","数据更新成功！");
//        }else{
//            map.addAttribute("msg","数据更新失败！");
//        }
//        return "index";
//    }

//    /**
//     *
//     * 测试不通过
//     * */
//    @RequestMapping(value = "/getstoragestate", method = RequestMethod.GET)
//    @ResponseBody
//    public List<Map<String,Integer>> getStorageSate(){
//
//        List<Map<String, Integer>> storageMapList = new ArrayList<>();
//        storageMapList = storeHouseService.getStorageState();
//        return storageMapList;
//    }

//    @RequestMapping(value = "/getstoragestate", method = RequestMethod.GET)
//    @ResponseBody
//    public Map<String,Integer> getStorageSate(){
//
//        Map<String, Integer> storageMap = new HashMap<>();
//        storageMap = storeHouseService.getStorageState();
//        return storageMap;
//    }
}
