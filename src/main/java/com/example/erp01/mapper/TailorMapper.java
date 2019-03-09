package com.example.erp01.mapper;

import com.example.erp01.model.Tailor;
import org.apache.ibatis.annotations.Mapper;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;
import java.util.Map;

@Mapper
public interface TailorMapper {

    List<Map<Integer,Tailor>> generateTailorData(Map<String,Object> info);

    int addTailorDataBatch(List<Tailor> tailordata);

    int deleteTailorDataByOrderID(Integer orderID);

    int deleteTailorDataByQcodeBatch(List<String> tailorQcodeList);

    List<Tailor> getTailorDataByOrderID(Integer orderID);

}
