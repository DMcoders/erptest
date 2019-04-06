package com.example.erp01.action;

import com.example.erp01.model.OPABack;
import com.example.erp01.service.OPABackService;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
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

@Controller(value = "/opaback")
public class OPABackController {

    @Autowired
    private OPABackService opaBackService;

    @RequestMapping(value = "/addopaback", method = RequestMethod.POST)
    @ResponseBody
    public boolean addOPABack(@RequestParam("opaBackJson")String opaBackJson,
                             ModelMap map){
        JsonParser jsonParser = new JsonParser();
        boolean result = false;
        try{
            JsonObject json = (JsonObject) jsonParser.parse(opaBackJson);
            JsonArray jsonArray = json.get("tailorQcode").getAsJsonArray();
            Iterator iterator = jsonArray.iterator();
            List<OPABack> opaBackList = new ArrayList<>();
            while (iterator.hasNext()){
                JsonPrimitive next = (JsonPrimitive) iterator.next();
                OPABack opaBack = new OPABack(next.toString().replace("\"",""));
                opaBackList.add(opaBack);
            }
            int res = opaBackService.addOPABack(opaBackList);
            if (0 == res){
               // map.addAttribute("msg","添加成功！");
                result = true;
            }
        }catch (JsonIOException e){
            e.printStackTrace();
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/getallopaback",method = RequestMethod.GET)
    public List<OPABack> getAllOPABack(){
        List<OPABack> opaBackList = new ArrayList<>();
        opaBackList = opaBackService.getAllOPABack();
        return opaBackList;
    }

}
