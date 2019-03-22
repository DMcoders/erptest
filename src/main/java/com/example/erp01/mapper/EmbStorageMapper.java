package com.example.erp01.mapper;

import com.example.erp01.model.EmbStorage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmbStorageMapper {

    int embInStore(List<EmbStorage> embStorageList);

    int embOutStore(List<String> embOutStoreList);

    int embChangeStore(String embChangeStoreJson);

}
