package com.example.erp01.service.impl;

import com.example.erp01.mapper.TailorMapper;
import com.example.erp01.model.Tailor;
import com.example.erp01.service.TailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class TailorServiceImpl implements TailorService {
    @Autowired
    private TailorMapper tailorMapper;

    @Override
    public List<Map<Integer,Tailor>> generateTailorData(Map<String,Object> info) {
        Integer orderId;
        Integer bedNumber;
        Integer layerCount;
        String styleName;
        String colorName;
        Map<Integer,Integer> sizeMap;
        Set<Integer> sizeIndex;
        List<Map<Integer,Tailor>> tailorList = null;
        if(info.containsKey("orderID") && info.get("orderID") instanceof Integer){
            orderId = (Integer) info.get("orderID");
        }else{
            return null;
        }
        if(info.containsKey("bedNumber") && info.get("bedNumber") instanceof Integer){
            bedNumber = (Integer) info.get("bedNumber");
        }else{
            return null;
        }
        if(info.containsKey("layerCount") && info.get("layerCount") instanceof Integer){
            layerCount = (Integer) info.get("layerCount");
        }else{
            return null;
        }
        if(info.containsKey("styleName") && info.get("styleName") instanceof String){
            styleName = (String) info.get("styleName");
        }else {
            return null;
        }
        if(info.containsKey("colorName") && info.get("colorName") instanceof String){
            colorName = (String) info.get("colorName");
        }else {
            return null;
        }
        if(info.containsKey("sizeList") && info.get("sizeList") instanceof Map){
            sizeMap = (Map) info.get("sizeList");
            sizeIndex = sizeMap.keySet();
        }


        return tailorList;
    }

    @Override
    public int addTailorDataBatch(List<Tailor> tailorDataList) {
        try{
            tailorMapper.addTailorDataBatch(tailorDataList);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int deleteTailorDataByOrderID(Integer orderID) {
        try{
            tailorMapper.deleteTailorDataByOrderID(orderID);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int deleteTailorDataByQcodeBatch(List<String> tailorQcodeList) {
        try{
            tailorMapper.deleteTailorDataByQcodeBatch(tailorQcodeList);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Tailor> getTailorDataByOrderID(Integer orderID) {
        List<Tailor> tailorList;
        try{
            tailorList = tailorMapper.getTailorDataByOrderID(orderID);
            return tailorList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
