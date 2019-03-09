package com.example.erp01.mapper;

import com.example.erp01.model.Color;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ColorMapper {

    int addColor(Color color);

    int deleteColorByID(Integer colorID);

    Color getColorByID(Integer id);

    Color getColorByName(String colorName);

    List<Color> getAllColor();

}
