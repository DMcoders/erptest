package com.example.erp01.mapper;

import com.example.erp01.model.EmbStorage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
//@Repository
public interface EmbStorageMapper {

    int embInStore(List<EmbStorage> embStorageList);

    int embOutStore(List<String> embOutStoreList);

    int embChangeStore(String embChangeStoreJson);

    List<EmbStorage> getEmbStorageState();

    List<Object> embStorageQuery(String orderName,String colorName,Integer bedNumber,String sizeName);

}
