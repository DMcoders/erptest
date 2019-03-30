package com.example.erp01.model;

public class EmbStorage {

    private Integer embStorageID;

    private String embStoreLocation;

    private String tailorQcode;

    private Integer embStorageState;

    public EmbStorage(String embStoreLocation, Integer embStorageState) {
        this.embStoreLocation = embStoreLocation;
        this.embStorageState = embStorageState;
    }

    public Integer getEmbStorageState() {
        return embStorageState;
    }

    public void setEmbStorageState(Integer embStorageState) {
        this.embStorageState = embStorageState;
    }

    public EmbStorage(String embStoreLocation, String tailorQcode) {
        this.embStoreLocation = embStoreLocation;
        this.tailorQcode = tailorQcode;
    }

    public EmbStorage(Integer embStorageID, String embStoreLocation, String tailorQcode) {
        this.embStorageID = embStorageID;
        this.embStoreLocation = embStoreLocation;
        this.tailorQcode = tailorQcode;
    }

    public EmbStorage() {
    }

    public Integer getEmbStorageID() {
        return embStorageID;
    }

    public void setEmbStorageID(Integer embStorageID) {
        this.embStorageID = embStorageID;
    }

    public String getembStoreLocation() {
        return embStoreLocation;
    }

    public void setembStoreLocation(String embStoreLocation) {
        this.embStoreLocation = embStoreLocation;
    }

    public String getTailorQcode() {
        return tailorQcode;
    }

    public void setTailorQcode(String tailorQcode) {
        this.tailorQcode = tailorQcode;
    }
}
