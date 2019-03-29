package com.example.erp01.model;

public class EmbStorage {

    private Integer embStorageID;

    private String embStoreQcode;

    private String tailorQcode;

    private Integer embStorageState;

    public EmbStorage(String embStoreQcode, Integer embStorageState) {
        this.embStoreQcode = embStoreQcode;
        this.embStorageState = embStorageState;
    }

    public Integer getEmbStorageState() {
        return embStorageState;
    }

    public void setEmbStorageState(Integer embStorageState) {
        this.embStorageState = embStorageState;
    }

    public EmbStorage(String embStoreQcode, String tailorQcode) {
        this.embStoreQcode = embStoreQcode;
        this.tailorQcode = tailorQcode;
    }

    public EmbStorage(Integer embStorageID, String embStoreQcode, String tailorQcode) {
        this.embStorageID = embStorageID;
        this.embStoreQcode = embStoreQcode;
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

    public String getEmbStoreQcode() {
        return embStoreQcode;
    }

    public void setEmbStoreQcode(String embStoreQcode) {
        this.embStoreQcode = embStoreQcode;
    }

    public String getTailorQcode() {
        return tailorQcode;
    }

    public void setTailorQcode(String tailorQcode) {
        this.tailorQcode = tailorQcode;
    }
}
