package com.example.erp01.service.impl;

import com.example.erp01.mapper.StorageMapper;
import com.example.erp01.model.Storage;
import com.example.erp01.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageMapper storageMapper;
    @Override
    public int inStore(List<Storage> storageList) {
        try{
            storageMapper.inStore(storageList);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int outStore(List<String> outstoreJson) {
        try{
            storageMapper.outStore(outstoreJson);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int changeStore(String changestoreJson) {
        try{
            storageMapper.changeStore(changestoreJson);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public List<Storage> getStorageState() {
        List<Storage> storageArrayList = new ArrayList<>();
        try{
            storageArrayList = storageMapper.getStorageState();

            return storageArrayList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return storageArrayList;
    }

    @Override
    public List<String> getMatch(List<String> tailorQcodeList) {

        List<String> locationList = new ArrayList<>();
        for(String tailorQcode : tailorQcodeList) {
            try{
                String location = storageMapper.getMatch(tailorQcode);
                locationList.add(location);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return locationList;
    }
}
