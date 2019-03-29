package com.example.erp01.service;

import com.example.erp01.model.OPABack;

import java.util.List;

public interface OPABackService {

    int addOPABack(List<OPABack> opaBackList);

    List<OPABack> getAllOPABack();
}
