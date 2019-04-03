package com.example.erp01.action;

import com.example.erp01.model.OPABack;
import com.example.erp01.service.OPABackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class OPABackController {

//    @Autowired
//    private OPABackService opaBackService;

//    @RequestMapping(value = "/addopaback", method = RequestMethod.POST)
//    public String addOPABack(@RequestParam("opaBackJson")String opaBackJson,
//                             ModelMap map){
//        JsonParser jsonParser = new JsonParser();
//        try{
//            JsonObject json = (JsonObject) jsonParser.parse(opaBackJson);
//            Iterator iterator = json.entrySet().iterator();
//            List<OPABack> opaBackList = new ArrayList<>();
//            while (iterator.hasNext()){
//                Map.Entry entry = (Map.Entry) iterator.next();
//                OPABack opaBack = new OPABack(entry.getValue().toString().replace("\"","").replace("\"",""));
//                opaBackList.add(opaBack);
//            }
//            int res = opaBackService.addOPABack(opaBackList);
//            if (0 == res){
//                map.addAttribute("msg","添加成功！");
//            }else{
//                map.addAttribute("msg","添加失败！");
//            }
//        }catch (JsonIOException e){
//            e.printStackTrace();
//        }catch (JsonSyntaxException e){
//            e.printStackTrace();
//        }
//        return "index";
//    }
//
//    @RequestMapping(value = "/getallopaback",method = RequestMethod.GET)
//    public List<OPABack> getAllOPABack(){
//        List<OPABack> opaBackList = new ArrayList<>();
//        opaBackList = opaBackService.getAllOPABack();
//        return opaBackList;
//    }


}
