package com.example.erp01.service;

import com.example.erp01.model.Tailor;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public interface TailorService {

    List<Tailor> generateTailorData(String jsonStr);

    int saveTailorData(List<Tailor> tailorList);

    List<Tailor> getAllTailorData();

    List<Tailor> getAllTailorDataByOrder(String orderName);

    Integer getMaxBedNumber(String orderName);

    List<Tailor> getTailorByOrderNameBedNum(String orderName,int bedNumber);

    List<Tailor> getTailorByOrderNameBedNumSizeColor(String orderName, int bedNumber, String sizeName, String colorName);

    List<Object> tailorReport(String orderName,int bedNumber);

}
