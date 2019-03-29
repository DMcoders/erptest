package com.example.erp01.action;

import com.example.erp01.model.Storage;
import com.example.erp01.service.StorageService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//裁片出入库基本操作，包括裁片入库，裁片调库，裁片出库等
@Controller
public class StorageController {

    @Autowired
    private StorageService storageService;

    @RequestMapping(value = "/instore", method = RequestMethod.POST)
    public String inStore(@RequestParam("instoreJson")String instoreJson,
                          ModelMap map){
        JsonParser jsonParser = new JsonParser();
        try{
            JsonObject json = (JsonObject) jsonParser.parse(instoreJson);
            String storehouseQcode = json.get("storehouseQcode").getAsString();
            JsonObject jsonTailorQcode = json.get("tailorQcode").getAsJsonObject();
            Iterator iterator1 = jsonTailorQcode.entrySet().iterator();
            List<String> tailorQcodeList = new ArrayList<>();
            while(iterator1.hasNext()){
                Map.Entry entry = (Map.Entry) iterator1.next();
                tailorQcodeList.add(entry.getValue().toString());
            }
            List<Storage> storageList = new ArrayList<>();
            for (int i=0; i<tailorQcodeList.size(); i++){
                Storage storage = new Storage(storehouseQcode,tailorQcodeList.get(i).replace("\"","").replace("\"",""));
                storageList.add(storage);
            }
            Gson gson = new Gson();
            String storageJson = gson.toJson(storageList);
            //int res = storageService.inStore(storageJson);
            int res = storageService.inStore(storageList);
            if (0 == res){
                map.addAttribute("msg","入库成功！");
            }else{
                map.addAttribute("msg","入库失败！");
            }
        }catch (JsonIOException e){
            e.printStackTrace();
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }
        return "index";
    }

    @RequestMapping(value = "/outstore", method = RequestMethod.POST)
    public String outStore(@RequestParam("outstoreJson")String outstoreJson,
                           ModelMap map){
        JsonParser jsonParser = new JsonParser();
        try{
            JsonObject json = (JsonObject) jsonParser.parse(outstoreJson);
            Iterator iterator = json.entrySet().iterator();
            List<String> tailorQcodeList = new ArrayList<>();
            while(iterator.hasNext()){
                Map.Entry entry = (Map.Entry) iterator.next();
                tailorQcodeList.add(entry.getValue().toString().replace("\"","").replace("\"",""));
            }
            int res = storageService.outStore(tailorQcodeList);
            if (0 == res){
                map.addAttribute("msg","出库成功！");
            }else{
                map.addAttribute("msg","出库失败！");
            }
        }catch (JsonIOException e){
            e.printStackTrace();
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }
        return "index";
    }

    @RequestMapping(value = "/changestore",method = RequestMethod.POST)
    public String changeStore(@RequestParam("changestoreJson")String changestoreJson,
                              ModelMap map){
        JsonParser jsonParser = new JsonParser();
        try{
            JsonObject json = (JsonObject) jsonParser.parse(changestoreJson);
            String storehouseQcode = json.get("storehouseQcode").getAsString();
            JsonObject jsonTailorQcode = json.get("tailorQcode").getAsJsonObject();
            Iterator iterator2 = jsonTailorQcode.entrySet().iterator();
            List<String> tailorQcodeList = new ArrayList<>();
            while(iterator2.hasNext()){
                Map.Entry entry = (Map.Entry) iterator2.next();
                tailorQcodeList.add(entry.getValue().toString().replace("\"","").replace("\"",""));
            }
            int res1 = storageService.outStore(tailorQcodeList);
            List<Storage> storageList = new ArrayList<>();
            for (int i=0; i<tailorQcodeList.size(); i++){
                Storage storage = new Storage(storehouseQcode,tailorQcodeList.get(i));
                storageList.add(storage);
            }
            //Gson gson = new Gson();
            //String storageJson = gson.toJson(storageList);
            int res2 = storageService.inStore(storageList);
            if (0 == res1 && 0 == res2){
                map.addAttribute("msg","调库成功！");
            }else{
                map.addAttribute("msg","调库失败！");
            }
        }catch (JsonIOException e){
            e.printStackTrace();
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }
        return "index";
    }

//    获取仓库存储状态信息
    @RequestMapping(value = "/getstoragestate", method = RequestMethod.GET)
    @ResponseBody
    public String getStorageState(){
        List<Storage> storageStateList = new ArrayList<>();
        storageStateList = storageService.getStorageState();
        Gson gson=new Gson();
        String storageStateJson=gson.toJson(storageStateList);
        return storageStateJson;
    }

}
