package com.example.erp01.action;

import com.example.erp01.model.StoreHouse;
import com.example.erp01.service.StoreHouseService;
import org.apache.ibatis.session.ResultContext;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StoreHouseController {

    @Autowired
    private StoreHouseService storeHouseService;

    /**
     * 进入仓库信息页面
     * @param model
     * @return
     */
    @RequestMapping("/storeHouseStart")
    public String addStoreHouse(Model model){
        model.addAttribute("bigMenuTag",4);
        model.addAttribute("menuTag",1);
        List<StoreHouse>  storeHouses = getAllStoreHouse();
        model.addAttribute("storeHouses",storeHouses);
        return "factoryMsg/storeHouse";
    }

    @RequestMapping(value = "/addstorehouse")
    @ResponseBody
    public int addStoreHouse(StoreHouse storeHouse){
        storeHouse.setStorehouseID(null);
        int res = storeHouseService.addStoreHouse(storeHouse);
        return res;
    }
    @RequestMapping(value = "/deletestorehouse")
    @ResponseBody
    public int deleteStoreHouse(@RequestParam("storehouseID")Integer storehouseID){
        int res = storeHouseService.deleteStoreHouse(storehouseID);
        return res;
    }

    @RequestMapping(value = "/updatestorehouse")
    @ResponseBody
    public int updateStoreHouse(StoreHouse storeHouse){
        int res = storeHouseService.updateStoreHouse(storeHouse);
        return res;

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
