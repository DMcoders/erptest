package com.example.erp01.mapper;

import com.example.erp01.model.Tailor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
//@Repository
public interface TailorMapper {

    List<Tailor> generateTailorData(String jsonStr);

    int saveTailorData(List<Tailor> tailorList);

    List<Tailor> getAllTailorData();

    List<Tailor> getAllTailorDataByOrder(String orderName);

    //由订单号获取当前最大床号
    Integer getMaxBedNumber(String orderName);

    List<Tailor> getTailorByOrderNameBedNumSizeColor(@Param("orderName")String orderName,@Param("bedNumber") int bedNumber,@Param("sizeName")String sizeName,@Param("colorName")String colorName);

    List<Tailor> getTailorByOrderNameBedNum(@Param("orderName")String orderName,@Param("bedNumber") int bedNumber);

}
