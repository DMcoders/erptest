package com.example.erp01.service.impl;

import com.example.erp01.mapper.TailorMapper;
import com.example.erp01.model.Tailor;
import com.example.erp01.service.TailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TailorServiceImpl implements TailorService {

    @Autowired
    private TailorMapper tailorMapper;

    @Override
    public List<Tailor> generateTailorData(String jsonStr) {
        List<Tailor> tailorList = null;
        try{
            tailorList = tailorMapper.generateTailorData(jsonStr);
            return tailorList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return tailorList;
    }

    @Override
    public int saveTailorData(List<Tailor> tailorList) {
        try{
            tailorMapper.saveTailorData(tailorList);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public List<Tailor> getAllTailorData() {
        List<Tailor> tailorList = null;
        try{
            tailorList = tailorMapper.getAllTailorData();
            return tailorList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return tailorList;
    }

    @Override
    public List<Tailor> getAllTailorDataByOrder(String orderName) {
        List<Tailor> tailorList = null;
        try{
            tailorList = tailorMapper.getAllTailorDataByOrder(orderName);
            return tailorList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return tailorList;
    }

    @Override
    public Integer getMaxBedNumber(String orderName) {
        try{
            Integer bedNumber = tailorMapper.getMaxBedNumber(orderName);
            return bedNumber;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Tailor> getTailorByOrderNameBedNum(String orderName, int bedNumber) {
        List<Tailor> tailorList = new ArrayList<>();

        try{
            tailorList = tailorMapper.getTailorByOrderNameBedNum(orderName,bedNumber);
            return tailorList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return tailorList;
    }
}
