package com.example.erp01.action;

import com.example.erp01.model.EmbStorage;
import com.example.erp01.service.EmbStorageService;
import com.example.erp01.service.StorageService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class EmbStorageController {

    @Autowired(required=true)
    private EmbStorageService embStorageService;
//    @Resource
    private StorageService storageService;

    @RequestMapping(value = "/embinstore", method = RequestMethod.POST)
    public String embInStore(@RequestParam("embInStoreJson")String embInStoreJson,
                             ModelMap map){
        JsonParser jsonParser = new JsonParser();
        try{
            JsonObject json = (JsonObject) jsonParser.parse(embInStoreJson);
            String embStoreQcode = json.get("embStoreQcode").getAsString();
            JsonObject jsonTailorQcode = json.get("tailorCode").getAsJsonObject();
            Iterator iterator = jsonTailorQcode.entrySet().iterator();
            List<String> tailorQcodeList = new ArrayList<>();
            while(iterator.hasNext()){
                Map.Entry entry = (Map.Entry) iterator.next();
                tailorQcodeList.add(entry.getValue().toString().replace("\"","").replace("\"",""));
            }
            int res1 = storageService.outStore(tailorQcodeList);
            List<EmbStorage> embStorageList = new ArrayList<>();
            for (int i=0; i<tailorQcodeList.size(); i++){
                EmbStorage embStorage = new EmbStorage(embStoreQcode,tailorQcodeList.get(i));
                embStorageList.add(embStorage);
            }
            int res2 = embStorageService.embInStore(embStorageList);
            if (0 == res1 && 0 == res2){
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

    @RequestMapping(value = "/emboutstore", method = RequestMethod.POST)
    public String embOutStore(@RequestParam("embOutStoreJson")String embOutStoreJson,
                              ModelMap map){

        JsonParser jsonParser = new JsonParser();
        try{
            JsonObject json = (JsonObject) jsonParser.parse(embOutStoreJson);
            Iterator iterator = json.entrySet().iterator();
            List<String> tailorQcodeList = new ArrayList<>();
            while(iterator.hasNext()){
                Map.Entry entry = (Map.Entry) iterator.next();
                tailorQcodeList.add(entry.getValue().toString().replace("\"","").replace("\"",""));
            }
            int res = embStorageService.embOutStore(tailorQcodeList);
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

    @RequestMapping(value = "/embchangestore",method = RequestMethod.POST)
    public String changeStore(@RequestParam("embChangeStoreJson")String embChangeStoreJson,
                              ModelMap map){
        JsonParser jsonParser = new JsonParser();
        try{
            JsonObject json = (JsonObject) jsonParser.parse(embChangeStoreJson);
            String embStoreQcode = json.get("embStoreQcode").getAsString();
            JsonObject jsonTailorQcode = json.get("tailorQcode").getAsJsonObject();
            Iterator iterator = jsonTailorQcode.entrySet().iterator();
            List<String> tailorQcodeList = new ArrayList<>();
            while(iterator.hasNext()){
                Map.Entry entry = (Map.Entry) iterator.next();
                tailorQcodeList.add(entry.getValue().toString().replace("\"","").replace("\"",""));
            }
            int res1 = embStorageService.embOutStore(tailorQcodeList);
            List<EmbStorage> embStorageList = new ArrayList<>();
            for (int i=0; i<tailorQcodeList.size(); i++){
                EmbStorage embStorage = new EmbStorage(embStoreQcode,tailorQcodeList.get(i));
                embStorageList.add(embStorage);
            }
            int res2 = embStorageService.embInStore(embStorageList);
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

}
