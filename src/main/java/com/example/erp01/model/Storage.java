package com.example.erp01.model;

public class Storage {

    private Integer storageID;

    private String storehouseQcode;

    private String tailorQcode;

    public Storage() {
    }


    public Storage(String storehouseQcode, String tailorQcode) {
        this.storehouseQcode = storehouseQcode;
        this.tailorQcode = tailorQcode;
    }

    public Integer getStorageID() {
        return storageID;
    }

    public void setStorageID(Integer storageID) {
        this.storageID = storageID;
    }

    public String getStorehouseQcode() {
        return storehouseQcode;
    }

    public void setStorehouseQcode(String storehouseQcode) {
        this.storehouseQcode = storehouseQcode;
    }

    public String getTailorQcode() {
        return tailorQcode;
    }

    public void setTailorQcode(String tailorQcode) {
        this.tailorQcode = tailorQcode;
    }
}
