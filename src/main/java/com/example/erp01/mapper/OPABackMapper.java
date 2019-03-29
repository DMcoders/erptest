package com.example.erp01.mapper;

import com.example.erp01.model.OPABack;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OPABackMapper {

    int addOPABack(List<OPABack> opaBackList);

    List<OPABack> getAllOPABack();

}
