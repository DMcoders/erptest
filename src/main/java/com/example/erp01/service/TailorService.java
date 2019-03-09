package com.example.erp01.service;

import com.example.erp01.model.Tailor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface TailorService {

    List<Map<Integer,Tailor>> generateTailorData(Map<String,Object> info);

    int addTailorDataBatch(List<Tailor> tailordata);

    int deleteTailorDataByOrderID(Integer orderID);

    int deleteTailorDataByQcodeBatch(List<String> tailorQcodeList);

    List<Tailor> getTailorDataByOrderID(Integer orderID);


}
