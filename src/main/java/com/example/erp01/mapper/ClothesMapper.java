package com.example.erp01.mapper;

import com.example.erp01.model.Clothes;

import java.util.List;

public interface ClothesMapper {

    int addClothes(Clothes clothes);

    int updateClothes(Clothes clothes);

    int deleteClothes(Clothes clothes);

    int deleteClothesByID(Integer clothesID);

    Clothes getClothesByID(Integer clothesID);

    Clothes getClothesByName(String clothesName);

    List<Clothes> getAllClothes();

}
