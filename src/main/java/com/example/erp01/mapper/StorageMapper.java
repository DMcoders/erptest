package com.example.erp01.mapper;

import com.example.erp01.model.Storage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
//@Repository
public interface StorageMapper {

    int inStore(List<Storage> storageList);

    int outStore(List<String> outstoreJson);

    int changeStore(String changestoreJson);

    List<Storage> getStorageState();

}
