package com.example.erp01.model;

import org.apache.ibatis.type.DateTypeHandler;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.Date;

public class StoreHouse {

    private Integer storehouseID;

    private String storehouseLocation;

    private String storehouseQcode;

    private Integer storehouseCount;

    public StoreHouse() {
    }

    public StoreHouse(String storehouseLocation, String storehouseQcode, Integer storehouseCount) {
        this.storehouseLocation = storehouseLocation;
        this.storehouseQcode = storehouseQcode;
        this.storehouseCount = storehouseCount;
    }

    public StoreHouse(Integer storehouseID, String storehouseLocation, String storehouseQcode, Integer storehouseCount) {
        this.storehouseID = storehouseID;
        this.storehouseLocation = storehouseLocation;
        this.storehouseQcode = storehouseQcode;
        this.storehouseCount = storehouseCount;
    }

    public Integer getStorehouseID() {
        return storehouseID;
    }

    public void setStorehouseID(Integer storehouseID) {
        this.storehouseID = storehouseID;
    }

    public String getStorehouseLocation() {
        return storehouseLocation;
    }

    public void setStorehouseLocation(String storehouseLocation) {
        this.storehouseLocation = storehouseLocation;
    }

    public String getStorehouseQcode() {
        return storehouseQcode;
    }

    public void setStorehouseQcode(String storehouseQcode) {
        this.storehouseQcode = storehouseQcode;
    }

    public Integer getStorehouseCount() {
        return storehouseCount;
    }

    public void setStorehouseCount(Integer storehouseCount) {
        this.storehouseCount = storehouseCount;
    }
}
