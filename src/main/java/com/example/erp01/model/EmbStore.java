package com.example.erp01.model;

public class EmbStore {

    private Integer embStoreID;

    private String embStoreLocation;

    private String embStoreQcode;

    private Integer embStoreCount;

    public EmbStore() {
    }

    public EmbStore(Integer embStoreID, String embStoreLocation, String embStoreQcode, Integer embStoreCount) {
        this.embStoreID = embStoreID;
        this.embStoreLocation = embStoreLocation;
        this.embStoreQcode = embStoreQcode;
        this.embStoreCount = embStoreCount;
    }

    public EmbStore(String embStoreLocation, String embStoreQcode, Integer embStoreCount) {
        this.embStoreLocation = embStoreLocation;
        this.embStoreQcode = embStoreQcode;
        this.embStoreCount = embStoreCount;
    }

    public Integer getEmbStoreID() {
        return embStoreID;
    }

    public void setEmbStoreID(Integer embStoreID) {
        this.embStoreID = embStoreID;
    }

    public String getEmbStoreLocation() {
        return embStoreLocation;
    }

    public void setEmbStoreLocation(String embStoreLocation) {
        this.embStoreLocation = embStoreLocation;
    }

    public String getEmbStoreQcode() {
        return embStoreQcode;
    }

    public void setEmbStoreQcode(String embStoreQcode) {
        this.embStoreQcode = embStoreQcode;
    }

    public Integer getEmbStoreCount() {
        return embStoreCount;
    }

    public void setEmbStoreCount(Integer embStoreCount) {
        this.embStoreCount = embStoreCount;
    }
}
