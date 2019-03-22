package com.example.erp01.service;

import com.example.erp01.model.Color;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ColorService {

    int addColor(Color color);

    int deleteColor(Integer colorID);

    List<Color> getAllColor();

}
