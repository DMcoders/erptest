package com.example.erp01.mapper;

import com.example.erp01.model.Tailor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TailorMapper {

    List<Tailor> generateTailorData(String jsonStr);

    int saveTailorData(List<Tailor> tailorList);

    List<Tailor> getAllTailorData();

    List<Tailor> getAllTailorDataByOrder(String orderName);

}
