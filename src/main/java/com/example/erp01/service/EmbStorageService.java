package com.example.erp01.service;

import com.example.erp01.model.EmbStorage;

import java.util.List;

public interface EmbStorageService {

    int embInStore(List<EmbStorage> embStorageList);

    int embOutStore(List<String> embOutStoreList);

    int embChangeStore(String embChangeStoreJson);

}
