package com.example.erp01.mapper;

import com.example.erp01.model.Style;

import java.util.List;

public interface StyleMapper {


    int addStyle(Style style);

    int updateStyle(Style style);

    int deleteStyle(Style style);

    int deleteStyleByID(Integer styleID);

    List<Style> getAllStyle();

    Style getStyleByID(Integer id);

}
