package com.example.erp01.action;

import com.example.erp01.model.OrderClothes;
import com.example.erp01.service.OrderClothesService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


//订单信息基本操作


@Controller
public class OrderClothesController {

    @Autowired
    private OrderClothesService orderClothesService;

    @RequestMapping(value = "/commitclothesorder", method = RequestMethod.POST)
    public String addOrderClothes(@RequestParam("clothesorderJson")String clothesorderJson,
                                  ModelMap map){
        JsonParser jsonParser = new JsonParser();
        try{
            JsonObject json = (JsonObject) jsonParser.parse(clothesorderJson);
            JsonArray orderArray = json.getAsJsonArray();
            List<JsonObject> objectList = new ArrayList<>();
            List<OrderClothes> orderClothesList = new ArrayList<>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for (int i=1; i<orderArray.size();i++){
                JsonObject tmporder = orderArray.get(i).getAsJsonObject();
                String name = String.valueOf(i);
                JsonObject order = tmporder.get(name).getAsJsonObject();
                String customerName = order.get("customerName").getAsString();
                String purchaseMethod = order.get("purchaseMethod").getAsString();
                String orderName = order.get("orderName").getAsString();
                String styleDescription = order.get("styleDescription").getAsString();
                String clothesVersionNumber = order.get("clothesVersionNumber").getAsString();
                String colorNumber = order.get("colorNumber").getAsString();
                String colorName = order.get("colorName").getAsString();
                JsonObject sizeObject = order.get("size").getAsJsonObject();
                String orderDate = order.get("orderDate").getAsString();
                String season = order.get("season").getAsString();
                String deadLine = order.get("deadLine").getAsString();
                List<String> sizeList = new ArrayList<>();
                List<Integer> sizeCountList = new ArrayList<>();
                Iterator iterator = sizeObject.entrySet().iterator();
                while(iterator.hasNext()){
                    Map.Entry entry = (Map.Entry) iterator.next();
                    if (!(entry.getValue() == "")){
                        String tmpkey =  entry.getKey().toString();
                        int tmpvalue = Integer.parseInt(entry.getValue().toString());
                        sizeList.add(tmpkey);
                        sizeCountList.add(tmpvalue);
                    }
                }
                for(int j=0;j<sizeList.size();j++){
                    OrderClothes orderClothes = new OrderClothes(customerName,purchaseMethod,orderName,styleDescription,clothesVersionNumber,colorNumber,colorName,sizeList.get(j),sizeCountList.get(j),sdf.parse(orderDate),season,sdf.parse(deadLine));
                    orderClothesList.add(orderClothes);
                }
            }
            int res = orderClothesService.addOrderClothes(orderClothesList);
            if (res == 0){
                map.addAttribute("msg","添加成功！");
            }else{
                map.addAttribute("msg","添加失败！");
            }
        }catch (JsonIOException e){
            e.printStackTrace();
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }catch (ParseException e){
            e.printStackTrace();
        }
        return "index";
    }

    @RequestMapping(value = "/getallorderclothes", method = RequestMethod.GET)
    @ResponseBody
    List<OrderClothes> getAllOrderClothes(){
        List<OrderClothes> orderClothesList = new ArrayList<>();
        orderClothesList = orderClothesService.getAllOrderClothes();
        return orderClothesList;
    }

    @RequestMapping(value = "/getordersummary", method = RequestMethod.GET)
    @ResponseBody
    String getOrderSummary(){
        String orderSummaryJson = null;
        orderSummaryJson = orderClothesService.getOrderSummary();
        return orderSummaryJson;
    }

    @RequestMapping(value = "/getbynamedate", method = RequestMethod.GET)
    @ResponseBody
    List<OrderClothes> getByNameDate(@RequestParam("orderName")String orderName,
                                     @RequestParam("orderDate")Date orderDate){
        List<OrderClothes> orderClothesList = new ArrayList<>();
        orderClothesList = orderClothesService.getByNameDate(orderName, orderDate);
        return orderClothesList;

    }

    @RequestMapping(value = "/deletebynamedate", method = RequestMethod.POST)
    String deleteByNameDate(@RequestParam("orderName")String orderName,
                            @RequestParam("orderDate")Date orderDate,
                            ModelMap map){
        int res = orderClothesService.deleteByNameDate(orderName, orderDate);
        if (res == 0){
            map.addAttribute("msg","删除成功");
        }else {
            map.addAttribute("msg","删除失败");
        }
        return "index";
    }

    @RequestMapping(value = "getorderhint",method = RequestMethod.GET)
    @ResponseBody
    List<String> getOrderHint(@RequestParam("subOrderName")String subOrderName){
        List<String> orderNameList = new ArrayList<>();
        orderNameList = orderClothesService.getOrderHint(subOrderName);
        return orderNameList;
    }

    @RequestMapping(value = "getcolorhint",method = RequestMethod.GET)
    @ResponseBody
    List<String> getColorHint(@RequestParam("orderName")String orderName){
        List<String> colorList = new ArrayList<>();
        colorList = orderClothesService.getColorHint(orderName);
        return colorList;
    }

    @RequestMapping(value = "getcustomernamebyordername",method = RequestMethod.GET)
    @ResponseBody
    String getCustomerNameByOrderName(@RequestParam("orderName")String orderName){
        String customerName = orderClothesService.getCustomerNameByOrderName(orderName);
        return customerName;
    }


}
