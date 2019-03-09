package com.example.erp01.service.impl;

import com.example.erp01.mapper.ColorMapper;
import com.example.erp01.model.Color;
import com.example.erp01.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {
    @Autowired
    private ColorMapper colorMapper;

    @Override
    public int addColor(Color color) {
        try{
            colorMapper.addColor(color);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int deleteColorByID(Integer colorID) {
        try{
            colorMapper.deleteColorByID(colorID);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public Color getColorByID(Integer id) {
        Color color;
        try {
            color = colorMapper.getColorByID(id);
            return color;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Color getColorByName(String colorName) {
        Color color;
        try{
            color = colorMapper.getColorByName(colorName);
            return color;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Color> getAllColor() {
        List<Color> colorList;
        try{
            colorList = colorMapper.getAllColor();
            return colorList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
