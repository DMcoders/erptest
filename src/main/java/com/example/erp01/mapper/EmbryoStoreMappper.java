package com.example.erp01.mapper;

import com.example.erp01.model.EmbryoStore;

import java.util.List;

public interface EmbryoStoreMappper {

    //时间戳+位置生成二维码
    int addEmbryoStore(String embryoLocation);

    int deleteEmbryoStore(EmbryoStore embryostore);

    int deleteEmbryoStoreByLocation(String embryoLocation);

    int updateEmbryoStore(String embryoLocation);

    EmbryoStore getEmbryoStoreByID(Integer embryoStoreID);

    EmbryoStore getEmbryoStoreByQcode(String embryoStoreQcode);

    EmbryoStore getEmbryoStoreByLocation(String embryoLocation);

    List<EmbryoStore> getAllEmbryoStore();


}
