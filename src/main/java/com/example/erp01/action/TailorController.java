package com.example.erp01.action;

import com.example.erp01.model.Tailor;
import com.example.erp01.service.TailorService;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;


@Controller
public class TailorController {
    @Autowired
    private TailorService tailorService;

    @RequestMapping(value = "/generatetailordata", method = RequestMethod.POST)
    @ResponseBody
    public String generateTailorData(@RequestParam("tailorDataJson")String tailorDataJson){
        JsonParser jsonParser = new JsonParser();
        try{
            JsonObject json = (JsonObject) jsonParser.parse(tailorDataJson);
            String orderName = json.get("orderName").getAsString();
            String customerName = json.get("customerName").getAsString();
            int bedNumber = json.get("bedNumber").getAsInt();
            String jarName = json.get("jarName").getAsString();
            JsonObject jsonColorName = json.get("colorName").getAsJsonObject();
            JsonObject jsonLayerCount = json.get("layerCount").getAsJsonObject();
            JsonObject jsonPartName = json.get("partName").getAsJsonObject();
            JsonObject jsonSizeRatio = json.get("sizeRatio").getAsJsonObject();
            Iterator iterator1 = jsonSizeRatio.entrySet().iterator();
            List<String> sizeList = new ArrayList<>();
            List<Integer> sizeCountList = new ArrayList<>();
            while (iterator1.hasNext()){
                Map.Entry entry = (Map.Entry) iterator1.next();
                String tmpkey =  entry.getKey().toString();
                int tmpvalue = Integer.parseInt(entry.getValue().toString());
                sizeList.add(tmpkey);
                sizeCountList.add(tmpvalue);
            }
            List<String> colorNameList = new ArrayList<>();
            List<Integer> layerCountList = new ArrayList<>();
            List<String> partNameList = new ArrayList<>();
            Iterator iterator2 = jsonColorName.entrySet().iterator();
            while(iterator2.hasNext()){
                Map.Entry entry = (Map.Entry) iterator2.next();
                colorNameList.add(entry.getValue().toString());
            }
            Iterator iterator3 = jsonLayerCount.entrySet().iterator();
            while(iterator3.hasNext()){
                Map.Entry entry = (Map.Entry) iterator3.next();
                layerCountList.add(Integer.parseInt(entry.getValue().toString()));
            }
            Iterator iterator4 = jsonPartName.entrySet().iterator();
            while(iterator4.hasNext()){
                Map.Entry entry = (Map.Entry) iterator4.next();
                partNameList.add(entry.getValue().toString());
            }
            List<String> totalSizeList = new ArrayList<>();
            for (int i=0; i<sizeList.size(); i++){
                for (int j=0; j<sizeCountList.get(i); j++){
                    totalSizeList.add(sizeList.get(i));
                }
            }

            List<Tailor> tailorList = new ArrayList<>();
            int tmpPackageNmber = 0;
            for (int i=0; i<layerCountList.size(); i++){
                for (int j=0; j<totalSizeList.size(); j++){
                    tmpPackageNmber += 1;
                    for (int k=0; k<partNameList.size(); k++){
                        String tmpTailorQcode = orderName+"-"+customerName+"-"+bedNumber+"-"+jarName+"-"+colorNameList.get(i).replace("\"","").replace("\"","")+"-"+totalSizeList.get(j)+"-"+layerCountList.get(i)+"-"+tmpPackageNmber;
                        Tailor tailor = new Tailor(orderName,customerName,bedNumber,jarName,colorNameList.get(i).replace("\"","").replace("\"",""),totalSizeList.get(j),partNameList.get(k).replace("\"","").replace("\"",""),layerCountList.get(i),tmpPackageNmber,tmpTailorQcode);
                        tailorList.add(tailor);
                    }
                }
            }
            Gson gson = new Gson();
            String tailorJson = gson.toJson(tailorList);
            return tailorJson;
        }catch (JsonIOException e){
            e.printStackTrace();
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }
        return null;

    }


    @RequestMapping(value = "/savetailordata", method = RequestMethod.POST)
    public String saveTailorData(@RequestParam("tailorList")String tailorList,
                                 ModelMap map){
        Gson gson = new Gson();
        List<Tailor> tailorList1 = gson.fromJson(tailorList,new TypeToken<List<Tailor>>(){}.getType());
        int res = tailorService.saveTailorData(tailorList1);
        if (0 == res){
            map.addAttribute("msg","保存成功！");
        }else {
            map.addAttribute("msg","保存失败！");
        }
        return "index";
    }

    @RequestMapping(value = "/getalltailordata", method = RequestMethod.GET)
    @ResponseBody
    public List<Tailor> getAllTailorData(){
        List<Tailor> tailorList = tailorService.getAllTailorData();
        return tailorList;
    }

    @RequestMapping(value = "/gettailordatabyorder", method = RequestMethod.GET)
    @ResponseBody
    public List<Tailor> getAllTailorDataByOrder(@RequestParam("orderName")String orderName){
        List<Tailor> tailorList = tailorService.getAllTailorDataByOrder(orderName);
        return tailorList;
    }

}
