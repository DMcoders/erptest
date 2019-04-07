package com.example.erp01.service;

import com.example.erp01.model.Tailor;

import java.util.List;

public interface TailorService {

    List<Tailor> generateTailorData(String jsonStr);

    int saveTailorData(List<Tailor> tailorList);

    List<Tailor> getAllTailorData();

    List<Tailor> getAllTailorDataByOrder(String orderName);

    Integer getMaxBedNumber(String orderName);

}
