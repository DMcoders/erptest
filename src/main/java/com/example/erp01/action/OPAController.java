package com.example.erp01.action;

//import com.example.erp01.model.OPA;
//import com.example.erp01.service.OPAService;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OPAController {

//    @Autowired
//    private OPAService opaService;
//
//    @RequestMapping(value = "/addopa", method = RequestMethod.POST)
//    public String addOPA(@RequestParam("opaJson")String opaJson,
//                          ModelMap map){
//        JsonParser jsonParser = new JsonParser();
//        try{
//            JsonObject json = (JsonObject) jsonParser.parse(opaJson);
//            String orderName = json.get("orderName").getAsString();
//            String customerName = json.get("customerName").getAsString();
//            String destination = json.get("destination").getAsString();
//            String sizeName = json.get("sizeName").getAsString();
//            String opaDate = json.get("opaDate").getAsString();
//            int opaCount = json.get("opaCount").getAsInt();
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            OPA opa = new OPA(orderName,customerName,destination,sizeName,opaCount,sdf.parse(opaDate));
//            int res = opaService.addOPA(opa);
//            if (0 == res){
//                map.addAttribute("msg","添加成功！");
//            }else{
//                map.addAttribute("msg","添加失败！");
//            }
//        }catch (JsonIOException e){
//            e.printStackTrace();
//        }catch (JsonSyntaxException e){
//            e.printStackTrace();
//        }catch (ParseException e){
//            e.printStackTrace();
//        }
//        return "index";
//    }
//
//    @RequestMapping(value = "/deleteopa",method = RequestMethod.POST)
//    public String deleteOPA(@RequestParam("opaID")Integer opaID,
//                            ModelMap map){
//        int res = opaService.deleteOPA(opaID);
//
//        if (res == 0){
//            map.addAttribute("msg","删除成功");
//        }else {
//            map.addAttribute("msg","删除失败");
//        }
//        return "index";
//    }
//
//    @RequestMapping(value = "/getallopa",method = RequestMethod.GET)
//    @ResponseBody
//    public List<OPA> getAllOPA(){
//        List<OPA> opaList = new ArrayList<>();
//        opaList = opaService.getAllOPA();
//        return opaList;
//    }

}
