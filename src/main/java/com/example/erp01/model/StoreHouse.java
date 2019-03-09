package com.example.erp01.model;

public class StoreHouse {

    private Integer storehouseID;

    private String storehouseLocation;

    private String storehouseQcode;

    public StoreHouse(String storehouseLocation, String storehouseQcode) {
        this.storehouseLocation = storehouseLocation;
        this.storehouseQcode = storehouseQcode;
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
}
