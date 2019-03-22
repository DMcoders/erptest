package com.example.erp01.service;

import com.example.erp01.model.Size;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SizeService {

    int addSize(Size size);

    int deleteSize(Integer sizeID);

    List<Size> getAllSize();

}
