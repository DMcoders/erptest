package com.example.erp01.mapper;

import com.example.erp01.model.Size;

import java.util.List;

public interface SizeMapper {

    int addSize(Size size);

    int deleteSize(Size size);

    int deleteSizeByID(Integer sizeID);

    int updateSize(Size size);

    Size getSizeByID(Integer sizeID);

    List<Size> getAllSize();



}
