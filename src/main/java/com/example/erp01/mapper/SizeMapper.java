package com.example.erp01.mapper;

import com.example.erp01.model.Size;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SizeMapper {

    int addSize(Size size);

    int deleteSize(Integer sizeID);

    List<Size> getAllSize();

}
