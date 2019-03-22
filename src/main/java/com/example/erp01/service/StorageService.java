package com.example.erp01.service;

import com.example.erp01.model.Storage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StorageService {

    int inStore(List<Storage> storageList);

    int outStore(List<String> outstoreJson);

    int changeStore(String changestoreJson);
}
