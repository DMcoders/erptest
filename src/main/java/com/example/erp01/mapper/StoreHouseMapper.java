package com.example.erp01.mapper;

import com.example.erp01.model.StoreHouse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StoreHouseMapper {

    int addStoreHouse(StoreHouse storeHouse);

    int deleteStoreHouse(Integer storehouseID);

    int updateStoreHouse(StoreHouse storeHouse);

    List<StoreHouse> getAllStoreHouse();

    StoreHouse getStoreHouseByQcode(String storehouseQcode);

//    Map<String,Integer> getStorageState();

    List<Map<String,Integer>> getStorageState();


}
