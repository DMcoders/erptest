package com.example.erp01.service.impl;

import com.example.erp01.mapper.SizeMapper;
import com.example.erp01.model.Size;
import com.example.erp01.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SizeServiceImpl implements SizeService {
    @Autowired
    private SizeMapper sizeMapper;

    @Override
    public int addSize(Size size) {
        try{
            sizeMapper.addSize(size);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int deleteSize(Integer sizeID) {
        try{
            sizeMapper.deleteSize(sizeID);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public List<Size> getAllSize() {
        List<Size> sizeList = new ArrayList<>();
        try{
            sizeList = sizeMapper.getAllSize();
            return sizeList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
