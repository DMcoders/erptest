package com.example.erp01.mapper;

import com.example.erp01.model.EmbStore;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmbStoreMapper {

    int addEmbStore(EmbStore embStore);

    int deleteEmbStore(Integer storehouseID);

    int updateEmbStore(EmbStore embStore);

    List<EmbStore> getAllEmbStore();

}
