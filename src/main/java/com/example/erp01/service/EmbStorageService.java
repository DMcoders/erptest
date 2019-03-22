package com.example.erp01.service;

import com.example.erp01.model.EmbStorage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmbStorageService {

    int embInStore(List<EmbStorage> embStorageList);

    int embOutStore(List<String> embOutStoreList);

    int embChangeStore(String embChangeStoreJson);

}
